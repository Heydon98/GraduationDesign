package com.heydon.ezheli.service;

import com.heydon.ezheli.dao.TeacherDao;
import com.heydon.ezheli.util.JwtUtil;
import com.heydon.ezheli.util.ResultUtil;
import com.heydon.ezheli.util.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Transactional
@Service
public class TeacherImpl implements TeacherService{

    @Autowired
    TeacherDao teacherDao;

    @Override
    public ResultUtil login(Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        Map result = teacherDao.findTeacByTeacIdAndPassword(username, password);
        if (result != null) {
            int collegeId = (int) result.get("college_id");
            long teacId = (long) result.get("teac_id");
            String realName = (String) result.get("name");
            String token = JwtUtil.createToken(username, collegeId);
            Map<String, Object> data = new HashMap<>();
            data.put("username", teacId);
            data.put("collegeId", collegeId);
            data.put("realName", realName);
            data.put("token", token);
            return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
        } else {
            return new ResultUtil(RetCode.FAIL.getCode(), "用户名或密码错误");
        }
    }
}
