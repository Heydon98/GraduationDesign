package com.heydon.ezheli.controller;

import com.heydon.ezheli.service.StudentService;
import com.heydon.ezheli.util.RetResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@Controller
@RequestMapping("student")
@ResponseBody
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "login", method = POST)
    public RetResultUtil login(@RequestBody Map<String, String> map) {

        /*
        boolean isSuccess = studentService.login(username, password);
        if (isSuccess) {
            String token = JwtUtil.createToken(username);
                return R
        }*/
        return studentService.login(map);
    }

}
