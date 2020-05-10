package com.heydon.ezheli.controller;

import com.heydon.ezheli.service.TeacherService;
import com.heydon.ezheli.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("teacher")
@ResponseBody
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultUtil login(@RequestParam Map<String, String> map) {
        return teacherService.login(map);
    }
}
