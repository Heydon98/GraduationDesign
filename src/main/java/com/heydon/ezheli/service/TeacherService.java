package com.heydon.ezheli.service;

import com.heydon.ezheli.util.ResultUtil;

import java.util.Map;

public interface TeacherService {
    ResultUtil login(Map<String, String> map);

    ResultUtil myAward(String token);

    ResultUtil newAward(String token, Map<String, String> map);

    ResultUtil changeAwardState(String token, Map<String, String> map);

    ResultUtil deleteAward(String token, Map<String, String> map);

    ResultUtil getAllTeacs();

    ResultUtil checkTeacs(Map<String, String> map);

    ResultUtil addCheckTeac(Map<String, String> map);

    ResultUtil deleteCheckTeac(Map<String, String> map);
}
