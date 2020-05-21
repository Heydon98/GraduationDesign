package com.heydon.ezheli.service;

import com.heydon.ezheli.dao.StudentDao;
import com.heydon.ezheli.entity.ApplyingAwards;
import com.heydon.ezheli.entity.OpenAwards;
import com.heydon.ezheli.util.JwtUtil;
import com.heydon.ezheli.util.ResultUtil;
import com.heydon.ezheli.util.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class StudentImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    /**
     * 登陆接口
     * @param map
     * @return
     */
    @Override
    public ResultUtil login(Map<String, String> map) {

        System.out.println(map.toString());
        String username = map.get("username");
        String password = map.get("password");
        Map result = studentDao.findUserByStuIdAndPassword(username, password);
        if (result != null) {
            int collegeId = (int) result.get("college_id");
            long stuId = (long) result.get("stu_id");
            String realName = (String)result.get("name");
            String token = JwtUtil.createToken(username, collegeId, realName);
            Map<String, Object> data = new HashMap<>();
            data.put("username", stuId);
            data.put("collegeId", collegeId);
            data.put("realName", realName);
            data.put("token", token);
            return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
        } else {
            return new ResultUtil(RetCode.FAIL.getCode(), "用户名或密码错误");
        }
    }

    /**
     * 查询开放申请的奖项
     * @param token
     * @return
     */
    @Override
    public ResultUtil showAwards(String token) {
        System.out.println(token);
        String stuId = JwtUtil.getUsername(token);
        System.out.println(stuId);
        int collegeId = JwtUtil.getCollegeId(token);
        List<OpenAwards> openAwards = studentDao.findOpenAwardByStuIdAndCollegeId(stuId, collegeId);
        Map<String, List<OpenAwards>> data = new HashMap<>();
        data.put("awards", openAwards);
        return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
    }

    /**
     * 申请奖项接口
     * @param token
     * @param map
     * @return
     */
    @Override
    public ResultUtil applyAwards(String token, Map<String, String> map) {
        System.out.println("applyAwardService");
        try{
            System.out.println(map);
            String stuId = JwtUtil.getUsername(token);
            System.out.println(stuId);
            String awardId = map.get("awardId");
            String reason = map.get("applyReason");
            String realName = map.get("realName");
            String awardName = map.get("awardName");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String applyTime = dateFormat.format(new Date());
            studentDao.addApplyAward(stuId, realName, awardId, awardName, reason, applyTime);
            return new ResultUtil(RetCode.SUCCESS.getCode(), "success");
        }catch (Exception e){
            System.out.println(e);
            return new ResultUtil(RetCode.FAIL.getCode(), "fail");
        }
    }

    /**
     * 查看正在申请奖项接口
     * @param token
     * @return
     */
    @Override
    public ResultUtil applyingAwards(String token) {
        String stuId = JwtUtil.getUsername(token);
        System.out.println(stuId);
        List<ApplyingAwards> applyRecord = studentDao.findApplyingAwardsByStuId(stuId);
        Map<String, List<ApplyingAwards>> data = new HashMap<>();
        data.put("applyRecord", applyRecord);
        return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
    }
}
