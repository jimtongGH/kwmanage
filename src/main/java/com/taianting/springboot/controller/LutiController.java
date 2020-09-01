package com.taianting.springboot.controller;

import com.taianting.springboot.model.Luti;
import com.taianting.springboot.model.Lutistate;
import com.taianting.springboot.service.LutiService;
import com.taianting.springboot.service.LutistateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LutiController {
    @Autowired
    LutiService lutiService;

    @Autowired
    LutistateService lutistateService;

    //增加录题
    @CrossOrigin
    @RequestMapping(value = "/luti/addluti")
    @ResponseBody
    public Map<String, Object> addLuti(HttpServletRequest request, Luti luti, Lutistate lutistate) {
        Map<String, Object> resultMap = new HashMap<>();
        //获取字符串["1000000857923234","1000001271069775"]
        String lururensString = request.getParameter("lururens");
        String shenherensString = request.getParameter("shenherens");

        //处理录入人字符串的内容
        //去除中括号"1000000857923234","1000001271069775"
        String lururensStringTemp1 = StringUtils.strip(lururensString, "[]");
        System.out.println("去除中括号" + lururensStringTemp1);
        //去除双引号1000000857923234,1000001271069775
        String lururensStringTemp2 = lururensStringTemp1.replaceAll("\"", "");
        System.out.println("去除双引号" + lururensStringTemp2);
        //逗号分割遍历
        String[] lururens = lururensStringTemp2.split(",");
        //录入人idlist
        List<String> lururensList = Arrays.asList(lururens);

        //处理审核人字符串中的内容
        //去除中括号"1000000857923234","1000001271069775"
        String shenherensStringTemp1 = StringUtils.strip(shenherensString, "[]");
        System.out.println("去除中括号" + shenherensStringTemp1);
        //去除双引号1000000857923234,1000001271069775
        String shenherensStringTemp2 = shenherensStringTemp1.replaceAll("\"", "");
        System.out.println("去除双引号" + shenherensStringTemp2);
        //逗号分割遍历
        String[] shenherens = shenherensStringTemp2.split(",");
        //审核人idlist
        List<String> shenherensList = Arrays.asList(shenherens);

        //Luti
        String luti_code = luti.getLuti_code();
        System.out.println("luti_code" + luti_code);
        Integer xuexiao_id = luti.getXuexiao_id();
        Integer kemu_id = luti.getKemu_id();
        String luti_shuoming = luti.getLuti_shuoming();
        String luti_jiezhishijian = luti.getLuti_jiezhishijian();
        Luti luti1 = new Luti(luti_code, xuexiao_id, kemu_id, luti_shuoming, luti_jiezhishijian);
        //添加luti信息
        int flag1 = lutiService.addLuti(luti1);
        //Lutistate
        Integer luti_id = luti1.getLuti_id();//获取返回的id
        //录入人id和审核人id有很多，需要遍历多次存入!!!!!!

        String lutistate_lurubeizhu = lutistate.getLutistate_lurubeizhu();
        String lutistate_shenhebeizhu = lutistate.getLutistate_shenhebeizhu();
        Integer lutistate_lurustate = lutistate.getLutistate_lurustate();
        Integer lutistate_shenhestate = lutistate.getLutistate_shenhestate();
        Integer lutistate_state = lutistate.getLutistate_state();

        int state = 0;
        //先判断luti是否添加成功，再添加状态，如果录题成功再添加状态
        if (flag1 != -1) {
            //添加录入人
            for (int i = 0; i < lururensList.size(); i++) {
                System.out.println(lururensList.size());
                Lutistate lutistate1 = new Lutistate(luti_id, lururensList.get(i), lutistate_lurubeizhu, 0, null, 0);
                //添加lutistate信息
                int flag2 = lutistateService.addLururen(lutistate1);
                if (flag2 != -1) {
                    state++;
                    if (state + 1 == lururensList.size()) {
                        resultMap.put("code", 2001);
                        resultMap.put("msg", "录题添加成功！");
                        resultMap.put("result1", lutistate1);

                    }
                } else {
                    resultMap.put("code", 202);
                    resultMap.put("msg", "录题状态添加失败！");
                    break;
                }
            }
            //添加审核人
            for (int i = 0; i < shenherensList.size(); i++) {
                System.out.println(shenherensList.get(i));
                Lutistate lutistate2 = new Lutistate(luti_id, shenherensList.get(i), "", lutistate_shenhebeizhu, null, 0, 0);
                //添加lutistate信息
                int flag2 = lutistateService.addShenheren(lutistate2);
                if (flag2 != -1) {
                    state++;
                    if (state + 1 == lururensList.size()) {
                        resultMap.put("code", 2002);
                        resultMap.put("msg", "添加成功！");
                        resultMap.put("result2", lutistate2);
                    }
                } else {
                    resultMap.put("code", 202);
                    resultMap.put("msg", "录题状态添加失败！");
                    break;
                }
            }
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "录题添加失败！");
        }
        System.out.println("resultMap:" + resultMap);
        return resultMap;
    }

    //查找录题记录
    @CrossOrigin
    @RequestMapping(value = "/luti/getAllLuti")
    @ResponseBody
    public Map<String, Object> getAllLuti() {
        Map<String, Object> resultMap = new HashMap<>();
        List<Map<String, String>> luti = lutiService.getAllLuti();
        if (luti == null) {
            resultMap.put("code", 201);
            resultMap.put("msg", "没有考试信息");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", luti);
        }
        System.out.println("resultMap:" + resultMap);
        return resultMap;
    }

    //软删除单条记录
    @CrossOrigin
    @RequestMapping(value = "/luti/deleteLuti")
    @ResponseBody
    public Map<String, Object> deleteSingleLuti(Luti luti) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int luti_id = luti.getLuti_id();
        int flag = lutiService.deleteSingleLuti(luti_id);
        if (flag != -1) {
            resultMap.put("code", 200);
            resultMap.put("msg", "删除成功!");
            resultMap.put("result", luti_id);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "删除失败！");
        }
        System.out.println("resultMap:" + resultMap);
        return resultMap;
    }

    //查找自己未完成录题任务
    @CrossOrigin
    @RequestMapping(value = "/luti/getAllLutiByLururenId")
    @ResponseBody
    public Map<String, Object> getAllLutiByLururenId(Lutistate lutistate) {
        Map<String, Object> resultMap = new HashMap<>();
        String lutistate_lururenid = lutistate.getLutistate_lururenid();
        List<Map<String, String>> luti = lutiService.getAllLutiByLururenId(lutistate_lururenid);
        if (luti == null) {
            resultMap.put("code", 201);
            resultMap.put("msg", "没有考试信息");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", luti);
        }
        System.out.println("resultMap:" + resultMap);
        return resultMap;
    }

    //录入完成，当所有录入人都完成时改变审核状态为审核中，总状态为审核中
    @CrossOrigin
    @RequestMapping(value = "/luti/accLuruTask")
    @ResponseBody
    public Map<String, Object> accLuruTask(Lutistate lutistate) {
        Map<String, Object> resultMap = new HashMap<>();
        int luti_id = lutistate.getLuti_id();
        String lutistate_lururenid = lutistate.getLutistate_lururenid();
        Lutistate lutistate1 = new Lutistate(luti_id, lutistate_lururenid);
        int flag = lutistateService.updateLurustateByLutiIdAndLururenId(lutistate1);
        if (flag != -1) {
            //统计正在做的人的数量
            int count = lutiService.countLurustateByLutiId(luti_id);
            //如果都做完了那么修改总状态为已完成
            if (count == 0) {
                lutistateService.updateShenhestate(luti_id);
                lutistateService.updateStateAsShenhezhong(luti_id);
            }
            resultMap.put("code", 200);
            resultMap.put("msg", "修改成功!");
            resultMap.put("result", luti_id);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "修改失败！");
        }
        System.out.println("resultMap:" + resultMap);
        return resultMap;
    }

    //查找自己已完成录题任务
    @CrossOrigin
    @RequestMapping(value = "/luti/getDoneLutiByLururenId")
    @ResponseBody
    public Map<String, Object> getDoneLutiByLururenId(Lutistate lutistate) {
        Map<String, Object> resultMap = new HashMap<>();
        String lutistate_lururenid = lutistate.getLutistate_lururenid();
        List<Map<String, String>> luti = lutiService.getDoneLutiByLururenId(lutistate_lururenid);
        if (luti == null) {
            resultMap.put("code", 201);
            resultMap.put("msg", "没有考试信息");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", luti);
        }
        System.out.println("resultMap:" + resultMap);
        return resultMap;
    }

    //查找自己未完成审核任务
    @CrossOrigin
    @RequestMapping(value = "/luti/getAllShenheByShenherenId")
    @ResponseBody
    public Map<String, Object> getAllShenheByShenherenId(Lutistate lutistate) {
        Map<String, Object> resultMap = new HashMap<>();
        String lutistate_shenherenid = lutistate.getLutistate_shenherenid();
        List<Map<String, String>> luti = lutiService.getAllShenheByShenherenId(lutistate_shenherenid);
        if (luti == null) {
            resultMap.put("code", 201);
            resultMap.put("msg", "没有审核信息");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", luti);
        }
        System.out.println("resultMap:" + resultMap);
        return resultMap;
    }

    //审核完成，当所有审核人都完成时改变审核状态为已审核，总状态为已完成
    @CrossOrigin
    @RequestMapping(value = "/luti/accShenheTask")
    @ResponseBody
    public Map<String, Object> accShenheTask(Lutistate lutistate){
        Map<String, Object> resultMap = new HashMap<>();
        int luti_id = lutistate.getLuti_id();
        String lutistate_shenherenid = lutistate.getLutistate_shenherenid();
        System.out.println(luti_id);
        System.out.println(lutistate_shenherenid);
        Lutistate lutistate1 = new Lutistate(lutistate_shenherenid,luti_id);
        int flag = lutistateService.updateShenhestateByLutiIdAndShenherenId(lutistate1);
        if(flag != -1){
            //统计正在做的人的数量
            int count = lutiService.countShenhestateByLutiId(luti_id);
            //如果都做完了那么修改总状态为已完成
            if(count == 0){
                lutistateService.updateState(luti_id);
            }
            resultMap.put("code",200);
            resultMap.put("msg","修改成功!");
            resultMap.put("result", luti_id);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "修改失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //查找自己已完成审核任务
    @CrossOrigin
    @RequestMapping(value = "/luti/getDoneShenheByShenherenId")
    @ResponseBody
    public Map<String, Object> getDoneShenheByShenheId(Lutistate lutistate) {
        Map<String, Object> resultMap = new HashMap<>();
        String lutistate_shenherenid = lutistate.getLutistate_shenherenid();
        List<Map<String, String>> luti = lutiService.getDoneShenheByShenherenId(lutistate_shenherenid);
        if (luti == null) {
            resultMap.put("code", 201);
            resultMap.put("msg", "没有信息");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", luti);
        }
        System.out.println("resultMap:" + resultMap);
        return resultMap;
    }
}
