package com.heydon.ezheli.controller;

import com.heydon.ezheli.service.StudentService;
import com.heydon.ezheli.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("student")
@ResponseBody
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 登陆控制器
     * @param map
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultUtil login(@RequestParam Map<String, String> map) {
        return studentService.login(map);
    }


    /**
     * 查看开放申请的奖项
     * @param request
     * @return
     */
    @RequestMapping(value = "showOpenAwards", method = RequestMethod.GET)
    public ResultUtil showOpenAwards(HttpServletRequest request) {
        String token = request.getHeader("token");
        return studentService.showAwards(token);
    }

    /**
     * 提交申请奖项
     * @param request
     * @return
     */
    @RequestMapping(value = "applyAward", method = RequestMethod.POST)
    public ResultUtil applyAward(HttpServletRequest request, @RequestParam Map<String, String> map) {
        System.out.println("applyAwardController");
        System.out.println(map);
        String token = request.getHeader("token");
        return studentService.applyAwards(token, map);
    }

    @RequestMapping(value = "applyingAwards", method = RequestMethod.GET)
    public ResultUtil applyingAwards(HttpServletRequest request) {
        String token = request.getHeader("token");
        return studentService.applyingAwards(token);
    }


}
