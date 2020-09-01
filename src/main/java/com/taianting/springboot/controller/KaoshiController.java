package com.taianting.springboot.controller;

import cn.hutool.core.date.DateUtil;
import com.taianting.springboot.model.Kaoshi;
import com.taianting.springboot.service.KaoshiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shengjin Tong
 * @date 2019/12/26 - 2:18 下午
 */

@RestController
public class KaoshiController {
    @Autowired
    private KaoshiService kaoshiService;

    //按照学期Id查找考试信息
    @CrossOrigin
    @GetMapping(value = "/kaowu/kaoshi/getAllByXueqiId")
    @ResponseBody
    public Map<String, Object> getAllKaoshi(Kaoshi kaoshi){
        Map<String, Object> resultMap = new HashMap<>();
        int xueqi_id = kaoshi.getXueqi_id();
        List<Map<String,String>> kaoshi1 = kaoshiService.getAllKaoshiByXueqiId(xueqi_id);
        if(kaoshi1 == null){
            resultMap.put("code",201);
            resultMap.put("msg","没有考试信息");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", kaoshi1);
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //增加考试信息
    @CrossOrigin
    @RequestMapping(value = "/kaowu/kaoshi/insertKaoshi")
    @ResponseBody
    public Map<String, Object> insertKaoshi(Kaoshi kaoshi, HttpSession httpSession){
        Map<String, Object> resultMap = new HashMap<>();
        String kaoshi_code = kaoshi.getKaoshi_code();
        Integer xuexiao_id = kaoshi.getXuexiao_id();
        Integer kemu_id = kaoshi.getKemu_id();
        Integer xueqi_id = kaoshi.getXueqi_id();
        Integer jiaoshi_id = kaoshi.getJiaoshi_id();
        String kaoshi_mingcheng = kaoshi.getKaoshi_mingcheng();
        String kaoshi_shijian = kaoshi.getKaoshi_shijian();
        String kaoshi_canyujiaoshi = kaoshi.getKaoshi_canyujiaoshi();
        String kaoshi_xueshengmingdan = kaoshi.getKaoshi_xueshengmingdan();
        String kaoshi_renshu = kaoshi.getKaoshi_renshu();
        String kaoshi_timu = kaoshi.getKaoshi_timu();
        String kaoshi_shijuan = kaoshi.getKaoshi_shijuan();
        String kaoshi_dianzhenbi = kaoshi.getKaoshi_dianzhenbi();
        String kaoshi_dianzhenzhi = kaoshi.getKaoshi_dianzhenzhi();
        String kaoshi_baoming = kaoshi.getKaoshi_baoming();
        String kaoshi_kaochangzhunbei = kaoshi.getKaoshi_kaochangzhunbei();
        String kaoshi_changci = kaoshi.getKaoshi_changci();
        String kaoshi_shezhi = kaoshi.getKaoshi_shezhi();
        String kaoshi_leixing = kaoshi.getKaoshi_leixing();
        String kaoshi_beizhu = kaoshi.getKaoshi_beizhu();
        String kaoshi_tixing = kaoshi.getKaoshi_tixing();
        Integer kaoshi_zhuangtai = kaoshi.getKaoshi_zhuangtai();
        //创建人//废弃从后端session取值改为从前端loaclStorage取值
//        Map<String,String> users = (Map<String, String>) httpSession.getAttribute("users");
        String kaoshi_chuangjianren = kaoshi.getKaoshi_chuangjianren();
        String kaoshi_chuangjianshijian = (DateUtil.date(System.currentTimeMillis())).toString();

        Kaoshi kaoshi1 = new Kaoshi(kaoshi_code,xueqi_id,xuexiao_id,kemu_id,jiaoshi_id,kaoshi_mingcheng,kaoshi_shijian,kaoshi_canyujiaoshi,kaoshi_xueshengmingdan,kaoshi_renshu,kaoshi_timu,kaoshi_shijuan,kaoshi_dianzhenbi,kaoshi_dianzhenzhi,kaoshi_baoming,kaoshi_kaochangzhunbei,kaoshi_changci,kaoshi_shezhi,kaoshi_leixing,kaoshi_beizhu,kaoshi_tixing,kaoshi_zhuangtai,kaoshi_chuangjianren,kaoshi_chuangjianshijian);
        int flag = kaoshiService.insertKaoshi(kaoshi1);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","添加成功！");
            resultMap.put("result", kaoshi1);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "添加失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //软删除单条记录
    @CrossOrigin
    @RequestMapping(value = "/kaowu/kaoshi/deleteSingleKaoshi")
    @ResponseBody
    public Map<String, Object> deleteSingleKaoshi (Kaoshi kaoshi) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int kaoshi_id = kaoshi.getKaoshi_id();
        int flag = kaoshiService.deleteSingleKaoshi(kaoshi_id);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","删除成功!");
            resultMap.put("result", kaoshi_id);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "删除失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //更改单条记录
    @CrossOrigin
    @RequestMapping(value = "/kaowu/kaoshi/updateSingleKaoshi")
    @ResponseBody
    public Map<String, Object> updateSingleKaoshi (Kaoshi kaoshi, HttpSession httpSession) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int kaoshi_id = kaoshi.getKaoshi_id();
        String kaoshi_code = kaoshi.getKaoshi_code();
        Integer xuexiao_id = kaoshi.getXuexiao_id();
        Integer kemu_id = kaoshi.getKemu_id();
        Integer xueqi_id = kaoshi.getXueqi_id();
        Integer jiaoshi_id = kaoshi.getJiaoshi_id();
        String kaoshi_mingcheng = kaoshi.getKaoshi_mingcheng();
        String kaoshi_shijian = kaoshi.getKaoshi_shijian();
        String kaoshi_canyujiaoshi = kaoshi.getKaoshi_canyujiaoshi();
        String kaoshi_xueshengmingdan = kaoshi.getKaoshi_xueshengmingdan();
        String kaoshi_renshu = kaoshi.getKaoshi_renshu();
        String kaoshi_timu = kaoshi.getKaoshi_timu();
        String kaoshi_shijuan = kaoshi.getKaoshi_shijuan();
        String kaoshi_dianzhenbi = kaoshi.getKaoshi_dianzhenbi();
        String kaoshi_dianzhenzhi = kaoshi.getKaoshi_dianzhenzhi();
        String kaoshi_baoming = kaoshi.getKaoshi_baoming();
        String kaoshi_kaochangzhunbei = kaoshi.getKaoshi_kaochangzhunbei();
        String kaoshi_changci = kaoshi.getKaoshi_changci();
        String kaoshi_shezhi = kaoshi.getKaoshi_shezhi();
        String kaoshi_leixing = kaoshi.getKaoshi_leixing();
        String kaoshi_beizhu = kaoshi.getKaoshi_beizhu();
        String kaoshi_tixing = kaoshi.getKaoshi_tixing();
        Integer kaoshi_zhuangtai = kaoshi.getKaoshi_zhuangtai();
        //修改人//废弃从后端session取值改为从前端loaclStorage取值
//        Map<String,String> users = (Map<String, String>) httpSession.getAttribute("users");
//        String kaoshi_xiugairen = users.get("user_name");
        String kaoshi_xiugairen = kaoshi.getKaoshi_xiugairen();
        String kaoshi_xiugaishijian = (DateUtil.date(System.currentTimeMillis())).toString();
        Kaoshi kaoshi1 = new Kaoshi(kaoshi_id,kaoshi_code,xueqi_id,xuexiao_id,kemu_id,jiaoshi_id,kaoshi_mingcheng,kaoshi_shijian,kaoshi_canyujiaoshi,kaoshi_xueshengmingdan,kaoshi_renshu,kaoshi_timu,kaoshi_shijuan,kaoshi_dianzhenbi,kaoshi_dianzhenzhi,kaoshi_baoming,kaoshi_kaochangzhunbei,kaoshi_changci,kaoshi_shezhi,kaoshi_leixing,kaoshi_beizhu,kaoshi_tixing,kaoshi_zhuangtai,kaoshi_xiugairen,kaoshi_xiugaishijian);
        System.out.println(kaoshi1);
        int flag = kaoshiService.updateSingleKaoshi(kaoshi1);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","更改成功!");
            resultMap.put("result", kaoshi1);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "更改失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }
}
