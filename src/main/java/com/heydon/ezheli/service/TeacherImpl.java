package com.heydon.ezheli.service;

import com.heydon.ezheli.dao.TeacherDao;
import com.heydon.ezheli.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class TeacherImpl implements TeacherService{

    @Autowired
    TeacherDao teacherDao;

    @Override
    public ResultUtil login(Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        Map result = teacherDao.findTeacByTeacIdAndPassword(username, password);
        if (result != null) {
            
        }
        return null;
    }
}
