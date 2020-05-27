package com.heydon.ezheli.service;

import com.heydon.ezheli.dao.TeacherDao;
import com.heydon.ezheli.entity.*;
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
            String token = JwtUtil.createToken(username, collegeId, realName);
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

    @Override
    public ResultUtil myAward(String token) {
        String teacId = JwtUtil.getUsername(token);
        int collegeId = JwtUtil.getCollegeId(token);
        List<Award> awards = teacherDao.findAwardByTeacId(teacId);
        Map<String, List<Award>> data = new HashMap<>();
        data.put("awards", awards);
        return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
    }

    @Override
    public ResultUtil newAward(String token, Map<String, String> map) {
        try {
            String teacId = JwtUtil.getUsername(token);
            int collegeId = JwtUtil.getCollegeId(token);
            String realName = JwtUtil.getRealName(token);
            String bigType = map.get("bigType");
            System.out.println(bigType);
            String smallType = map.get("smallType");
            String awardName = map.get("awardName");
            String limitNum = map.get("limitNum");
            String introduce = map.get("introduce");
            int awardId = teacherDao.getMaxAwardId() + 1;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = dateFormat.format(new Date());
            int stateId = 1;
            teacherDao.addNewAward(awardId, bigType, smallType, collegeId, awardName, createTime, introduce, limitNum, teacId, realName, stateId);
            return new ResultUtil(RetCode.SUCCESS.getCode(), "success");
        }catch (Exception e){
            System.out.println(e);
            return new ResultUtil(RetCode.FAIL.getCode(), "fail");
        }
    }

    @Override
    public ResultUtil changeAwardState(String token, Map<String, String> map) {
        try {
            String awardId = map.get("awardId");
            String stateId = map.get("stateId");
            System.out.println(stateId);
            teacherDao.changeAwardState(awardId, stateId);
            return new ResultUtil(RetCode.SUCCESS.getCode(), "success");
        }catch (Exception e){
            System.out.println(e);
            return new ResultUtil(RetCode.FAIL.getCode(), "fail");
        }
    }

    @Override
    public ResultUtil deleteAward(String token, Map<String, String> map) {
        try {
            String awardId = map.get("awardId");
            teacherDao.deleteAward(awardId);
            teacherDao.deleteStuAward(awardId);
            return new ResultUtil(RetCode.SUCCESS.getCode(), "success");
        }catch (Exception e){
            System.out.println(e);
            return new ResultUtil(RetCode.FAIL.getCode(), "fail");
        }
    }

    @Override
    public ResultUtil getAllTeacs() {

        List<AllTeacs> allTeacs = teacherDao.findTeachers();
        Map data = new HashMap<>();
        data.put("allTeacs", allTeacs);
        return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
    }

    @Override
    public ResultUtil checkTeacs(Map<String, String> map) {
        String awardId = map.get("awardId");
        List<AllTeacs> checkTeacs = teacherDao.findCheckTeacsByAwardId(awardId);
        Map data = new HashMap<>();
        data.put("checkTeacs", checkTeacs);
        return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
    }

    @Override
    public ResultUtil addCheckTeac(Map<String, String> map) {
        try {
            String teacId = map.get("teacId");
            String awardId = map.get("awardId");
            String teacName = teacherDao.findNameByTeacId(teacId);
            String nameId = teacName + '(' + teacId + ')';
            teacherDao.addCheckTeac(teacId, teacName, awardId);
            Map data = new HashMap<>();
            data.put("teadId", teacId);
            data.put("nameId", nameId);
            return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
        }catch (Exception e){
            System.out.println(e);
            return new ResultUtil(RetCode.FAIL.getCode(), "fail");
        }
    }

    @Override
    public ResultUtil deleteCheckTeac(Map<String, String> map) {
        try {
            String teacId = map.get("teacId");
            String awardId = map.get("awardId");
            teacherDao.deleteCheckTeac(teacId, awardId);
            return new ResultUtil(RetCode.SUCCESS.getCode(), "success");
        }catch (Exception e){
            System.out.println(e);
            return new ResultUtil(RetCode.FAIL.getCode(), "fail");
        }
    }

    @Override
    public ResultUtil myCheckAward(String token, Map<String, String> map) {
        String teacId = JwtUtil.getUsername(token);
        String bigTypeId = map.get("bigTypeId");
        List<Award> result = teacherDao.findAwardNameByBigType(teacId, bigTypeId);
        Map<String, List<Award>> data = new HashMap<>();
        data.put("awards", result);
        return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
    }

    @Override
    public ResultUtil queryApplies(Map<String, String> map) {
        String awardId = map.get("awardId");
        String isChecked = map.get("isChecked");
        List<Apply> result = null;
        if (isChecked.equals("0")){
            result = teacherDao.getNotCheckApplies(awardId);
        } else {
            result = teacherDao.getCheckedApplies(awardId);
        }
        Map<String, List<Apply>> data = new HashMap<>();
        data.put("applies", result);
        return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
    }

    @Override
    public ResultUtil checkApply(String token, Map<String, String> map) {
        String teacId = JwtUtil.getUsername(token);
        String teacName = JwtUtil.getRealName(token);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String checkTime = dateFormat.format(new Date());
        try {
            for (Map.Entry<String, String> entry : map.entrySet()){
                teacherDao.updateCheck(entry.getKey(), entry.getValue(), teacId, teacName, checkTime);
            }
            return new ResultUtil(RetCode.SUCCESS.getCode(), "success");
        }catch (Exception e){
            System.out.println(e);
            return new ResultUtil(RetCode.FAIL.getCode(), "fail");
        }
    }

    @Override
    public ResultUtil winStudents(Map<String, String> map) {
        String awardId = map.get("awardId");
        List<WinStudent> result = teacherDao.getWinStudents(awardId);
        Map<String, List<WinStudent>> data = new HashMap<>();
        data.put("students", result);
        return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
    }

    @Override
    public ResultUtil statistics(Map<String, String> map) {
        String awardId = map.get("awardId");
        List<Statistics> result = teacherDao.getWinStuNum(awardId);
        Map<String, List<Statistics>> data = new HashMap<>();
        data.put("statistics", result);
        return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
    }

    @Override
    public ResultUtil awardName(Map<String, String> map) {
        String awardId = map.get("awardId");
        String awardName = teacherDao.getAwardNameByAwardId(awardId);
        Map<String, String> data = new HashMap<>();
        data.put("awardName", awardName);
        return new ResultUtil(RetCode.SUCCESS.getCode(), "success", data);
    }
}
