package com.heydon.ezheli.controller;

import com.heydon.ezheli.service.TeacherService;
import com.heydon.ezheli.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("teacher")
@ResponseBody
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 登陆
     * @param map
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultUtil login(@RequestParam Map<String, String> map) {
        return teacherService.login(map);
    }

    /**
     * 我管理的奖项
     * @param request
     * @return
     */
    @RequestMapping(value = "manageAward", method = RequestMethod.GET)
    public ResultUtil myAward(HttpServletRequest request) {
        String token = request.getHeader("token");
        return teacherService.myAward(token);
    }

    /**
     * 新建奖项
     * @param request
     * @return
     */
    @RequestMapping(value = "newAward", method = RequestMethod.POST)
    public ResultUtil newAward(HttpServletRequest request, @RequestParam Map<String, String> map) {
        String token = request.getHeader("token");
        return teacherService.newAward(token, map);
    }

    @RequestMapping(value = "changeAwardState", method = RequestMethod.POST)
    public ResultUtil changeAwardState(HttpServletRequest request, @RequestParam Map<String, String> map) {
        String token = request.getHeader("token");
        return teacherService.changeAwardState(token, map);
    }

    @RequestMapping(value = "deleteAward", method = RequestMethod.POST)
    public ResultUtil deleteAward(HttpServletRequest request, @RequestParam Map<String, String> map) {
        String token = request.getHeader("token");
        return teacherService.deleteAward(token, map);
    }

    @RequestMapping(value = "getAllTeacs", method = RequestMethod.GET)
    public ResultUtil getAllTeacs() {
        return teacherService.getAllTeacs();
    }

    @RequestMapping(value = "checkTeacs", method = RequestMethod.POST)
    public ResultUtil checkTeacs(@RequestParam Map<String, String> map) {
        return teacherService.checkTeacs(map);
    }

    @RequestMapping(value = "addCheckTeac", method = RequestMethod.POST)
    public ResultUtil addCheckTeac(@RequestParam Map<String, String> map) {
        return teacherService.addCheckTeac(map);
    }

    @RequestMapping(value = "deleteCheckTeac", method = RequestMethod.POST)
    public ResultUtil deleteCheckTeac(@RequestParam Map<String, String> map) {
        return teacherService.deleteCheckTeac(map);
    }

    @RequestMapping(value = "myCheckAward", method = RequestMethod.POST)
    public ResultUtil myCheckAward(HttpServletRequest request, @RequestParam Map<String, String> map) {
        String token = request.getHeader("token");
        return teacherService.myCheckAward(token, map);
    }

    @RequestMapping(value = "queryApplies", method = RequestMethod.POST)
    public ResultUtil queryApplies(@RequestParam Map<String, String> map) {
        return teacherService.queryApplies(map);
    }

    @RequestMapping(value = "checkApply", method = RequestMethod.POST)
    public ResultUtil checkApply(HttpServletRequest request, @RequestParam Map<String, String> map) {
        String token = request.getHeader("token");
        return teacherService.checkApply(token, map);
    }

    @RequestMapping(value = "winStudents", method = RequestMethod.POST)
    public ResultUtil winStudents(@RequestParam Map<String, String> map) {
        return teacherService.winStudents(map);
    }

    @RequestMapping(value = "statistics", method = RequestMethod.POST)
    public ResultUtil statistics(@RequestParam Map<String, String> map) {
        return teacherService.statistics(map);
    }

    @RequestMapping(value = "awardName", method = RequestMethod.POST)
    public ResultUtil awardName(@RequestParam Map<String, String> map) {
        return teacherService.awardName(map);
    }

}
