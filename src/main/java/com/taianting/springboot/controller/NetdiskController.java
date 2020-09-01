package com.taianting.springboot.controller;

import cn.hutool.core.date.DateUtil;
import com.taianting.springboot.model.Netdisk;
import com.taianting.springboot.model.Users;
import com.taianting.springboot.service.NetdiskService;
import com.taianting.springboot.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NetdiskController {
    @Autowired
    private NetdiskService netdiskService;

    //Spring这里是通过实现ServletContextAware接口来注入ServletContext对象
    private ServletContext servletContext;

    //上传
    @CrossOrigin
    @RequestMapping(value = "/netdisk/upload")
    @ResponseBody
    public Map<String, Object> upload(MultipartFile file, Users users, Netdisk netdisk) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        String user_id = users.getUser_id();
        String netdisk_uploaduser = netdisk.getNetdisk_uploaduser();

        System.out.println(user_id);
        System.out.println(netdisk_uploaduser);
        //定义存储路径，获取存储路径
        String netdisk_lujing = "src/main/resources/static/fileUpload/";
        File Folder = new File(netdisk_lujing);
        //用UUID为文件重新命名
        File f = new File(Folder.getAbsolutePath(), UUIDUtil.getUniqueIdByUUId() + file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            //获取文件名
            String netdisk_name = file.getOriginalFilename();
            System.out.println(netdisk_name);

            //获取增加文件时间
            String netdisk_time = (DateUtil.date(System.currentTimeMillis())).toString();
            System.out.println(netdisk_time);

            //获取下载可以用的URL
            //部署要改项目地址，服务器ip
            //http://localhost:8888/uploadtest/aa.txt
            String netdisk_url = "http://localhost:8888/fileUpload/" + f.getName();
            System.out.println(netdisk_url);

            //获取后缀
            String netdisk_icon = netdisk_name.substring(netdisk_name.lastIndexOf(".") + 1);
            System.out.println(netdisk_icon);

            //获取文件大小最后存储
            long netdisk_size = file.getSize();
            //命名为MB或者GB
            DecimalFormat df = new DecimalFormat("0.00");
            Double a = Double.valueOf(String.valueOf(netdisk_size))/1024/1024;
            if(a>1024){
                a= a/1024;
                String gb_size = df.format(a)+"GB";
                System.out.println(gb_size);
                //创建netdisk对象
                Netdisk netdisk1 = new Netdisk(netdisk_time,netdisk_name,gb_size,netdisk_url,netdisk_lujing,netdisk_icon,0,user_id,netdisk_uploaduser);
                //执行存储函数
                netdiskService.addFile(netdisk1);
            }else {
                String mb_size = df.format(a)+"MB";
                System.out.println(mb_size);
                //创建netdisk对象
                Netdisk netdisk2 = new Netdisk(netdisk_time,netdisk_name,mb_size,netdisk_url,netdisk_lujing,netdisk_icon,0,user_id,netdisk_uploaduser);
                //执行存储函数
                netdiskService.addFile(netdisk2);
            }

            //执行文件上传
            file.transferTo(f);
            //返回结果
            resultMap.put("code",200);
            resultMap.put("msg","上传成功");
            return resultMap;
        } catch (IOException e) {
            e.printStackTrace();
            resultMap.put("code",201);
            resultMap.put("msg","上传失败");
            return resultMap;
        }
    }
    //下载文件和预览图片和pdf txt
    @CrossOrigin
    @RequestMapping(value = "/netdisk/filedownload")
    @ResponseBody
    public static ResponseEntity<InputStreamResource> fileDownload(Netdisk netdisk){
        Map<String, Object> resultMap = new HashMap<>();
        //前端获取URL和名字
        //新文件名
        String netdisk_name = netdisk.getNetdisk_name();
        //index为最后的“/”字符所在的位置
        int index=netdisk.getNetdisk_url().lastIndexOf(File.separator);
        //得到倒数第一个“/”之后的字符串 原文件名
        String netdisk_url=netdisk.getNetdisk_url().substring(index+1);


        String route = "static" + File.separator;
        String path = null;
        ResponseEntity<InputStreamResource> response = null;
        try {
            path = route + "fileUpload" + File.separator + netdisk_url;
            ClassPathResource classPathResource = new ClassPathResource(path);
            InputStream inputStream = classPathResource.getInputStream();
            //File file = new File(path);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition",
                    "attachment; filename="
                            + new String(netdisk_name.getBytes("gbk"), "iso8859-1") + ".xlsx");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            response = ResponseEntity.ok().headers(headers)
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(inputStream));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return response;
        }

        return response;
    }

    //网盘展示
    @CrossOrigin
    @RequestMapping(value = "/netdisk/getAll")
    @ResponseBody
    public Map<String, Object> getAll() throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        List<Map<String,String>> allFile = netdiskService.getAllFile();
        if(allFile == null){
            resultMap.put("code",201);
            resultMap.put("msg","没有文件");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", allFile);
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //个人网盘展示
    @CrossOrigin
    @RequestMapping(value = "/netdisk/getAllByUserId")
    @ResponseBody
    public Map<String, Object> getAllByUserId(Users users) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        String user_id = users.getUser_id();
        System.out.println(user_id);
        List<Map<String,String>> allFile = netdiskService.getAllFileByUserId(user_id);
        if(allFile == null){
            resultMap.put("code",201);
            resultMap.put("msg","没有文件");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", allFile);
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //个人回收站展示
    @CrossOrigin
    @RequestMapping(value = "/netdisk/getRecoverFileByUserId")
    @ResponseBody
    public Map<String, Object> getRecoverFileByUserId(Users users) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        String user_id = users.getUser_id();
        System.out.println(user_id);
        List<Map<String,String>> allFile = netdiskService.getRecoverFileByUserId(user_id);
        if(allFile == null){
            resultMap.put("code",201);
            resultMap.put("msg","没有文件");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", allFile);
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //个人网盘软删除
    @CrossOrigin
    @RequestMapping(value = "/netdisk/deleteByNetdiskId")
    @ResponseBody
    public Map<String, Object> deleteByNetdiskId(Netdisk netdisk) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int netdisk_id = netdisk.getNetdisk_id();
        int flag = netdiskService.deleteByNetdiskId(netdisk_id);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","删除成功!");
            resultMap.put("result", netdisk_id);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "删除失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //个人网盘永久软删除
    @CrossOrigin
    @RequestMapping(value = "/netdisk/deleteForeverByNetdiskId")
    @ResponseBody
    public Map<String, Object> deleteForeverByNetdiskId(Netdisk netdisk) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int netdisk_id = netdisk.getNetdisk_id();
        int flag = netdiskService.deleteForeverByNetdiskId(netdisk_id);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","删除成功!");
            resultMap.put("result", netdisk_id);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "删除失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //个人网盘删除还原
    @CrossOrigin
    @RequestMapping(value = "/netdisk/recoverFile")
    @ResponseBody
    public Map<String, Object> recoverFile(Netdisk netdisk) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int netdisk_id = netdisk.getNetdisk_id();
        int flag = netdiskService.recoverFile(netdisk_id);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","还原成功!");
            resultMap.put("result", netdisk_id);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "还原失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //个人网盘更改单条记录
    @CrossOrigin
    @RequestMapping(value = "/netdisk/updateSingleFile")
    @ResponseBody
    public Map<String, Object> updateSingleFile (Netdisk netdisk) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int netdisk_id = netdisk.getNetdisk_id();
        String netdisk_name = netdisk.getNetdisk_name();
        String netdisk_icon = netdisk.getNetdisk_icon();
        int netdisk_state = netdisk.getNetdisk_state();
        System.out.println(netdisk_state);
        Netdisk netdisk1 = new Netdisk(netdisk_id,netdisk_name,netdisk_icon,netdisk_state);
        System.out.println(netdisk1);
        int flag = netdiskService.updateSingleFile(netdisk1);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","更改成功!");
            resultMap.put("result", netdisk1);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "更改失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

//    //链接url下载图片
//    @CrossOrigin
//    @RequestMapping(value = "api/netdisk/imagedownload")
//    @ResponseBody
//    public Map<String, Object> imageDownload(Netdisk netdisk) {
//        System.out.println();
//        Map<String, Object> resultMap = new HashMap<>();
//        String path = netdisk.getNetdisk_name();
//        try {
//            URL url = new URL(netdisk.getNetdisk_url());
//            DataInputStream dataInputStream = new DataInputStream(url.openStream());
//
//            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
//            ByteArrayOutputStream output = new ByteArrayOutputStream();
//
//            byte[] buffer = new byte[1024];
//            int length;
//
//            while ((length = dataInputStream.read(buffer)) > 0) {
//                output.write(buffer, 0, length);
//            }
//            fileOutputStream.write(output.toByteArray());
//            dataInputStream.close();
//            fileOutputStream.close();
//            resultMap.put("code",200);
//            resultMap.put("msg","下载成功！");
//            System.out.println("下载成功！");
//            return resultMap;
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            resultMap.put("code",201);
//            resultMap.put("msg","MalformedURLException");
//            System.out.println(resultMap);
//            return resultMap;
//        } catch (IOException e) {
//            e.printStackTrace();
//            resultMap.put("code",202);
//            resultMap.put("msg","IOException");
//            return resultMap;
//        }
//    }
}
