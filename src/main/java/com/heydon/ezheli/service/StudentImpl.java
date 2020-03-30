package com.heydon.ezheli.service;

import com.heydon.ezheli.dao.StudentDao;
import com.heydon.ezheli.util.JwtUtil;
import com.heydon.ezheli.util.RetCode;
import com.heydon.ezheli.util.RetResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@Service
public class StudentImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public RetResultUtil login(Map<String, String> map) {

        String username = map.get("username");
        String password = map.get("password");
        Map result = studentDao.findByStuIdAndPassword(username, password);
        if (result != null) {
            String token = JwtUtil.createToken(username);
            return new RetResultUtil(RetCode.SUCCESS.getCode(), "success");
        } else {
            return new RetResultUtil(RetCode.FAIL.getCode(), "用户名或密码错误");
        }
    }
}
