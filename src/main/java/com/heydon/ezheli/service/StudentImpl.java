package com.heydon.ezheli.service;

import com.heydon.ezheli.dao.StudentDao;
import com.heydon.ezheli.entity.ApplyingAwards;
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

    @Override
    public ResultUtil login(Map<String, String> map) {

        System.out.println(map.toString());
        String username = map.get("username");
        String password = map.get("password");
        System.out.println(username + "===========" + password);
        Map result = studentDao.findUserByStuIdAndPassword(username, password);
        if (result != null) {
            int collegeId = (int) result.get("college_id");
            long stuId = (long) result.get("stu_id");
            String token = JwtUtil.createToken(username, collegeId);
            Map<String, Object> data = new HashMap<>();
            data.put("username", stuId);
            data.put("collegeId", collegeId);
            data.put("token", token);
            return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
        } else {
            return new ResultUtil(RetCode.FAIL.getCode(), "用户名或密码错误");
        }
    }

    @Override
    public ResultUtil showAwards(String token) {
        String stuId = JwtUtil.getUsername(token);
        int collegeId = JwtUtil.getCollegeId(token);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<ApplyingAwards> applyingAwards = studentDao.findOpenAwardByStuIdAndCollegeId1(collegeId, dateFormat.format(new Date()));
        Map<String, List<ApplyingAwards>> data = new HashMap<>();
        data.put("awards", applyingAwards);
        return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
    }

    @Override
    public ResultUtil applyAwards(String token) {
        String stuId = JwtUtil.getUsername(token);
        int collegeId = JwtUtil.getCollegeId(token);
        return null;
    }
}
