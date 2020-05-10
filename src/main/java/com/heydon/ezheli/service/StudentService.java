package com.heydon.ezheli.service;

import com.heydon.ezheli.util.ResultUtil;

import java.util.Map;

public interface StudentService {
    ResultUtil login(Map<String, String> map);

    ResultUtil showAwards(String token);

    ResultUtil applyAwards(String token, Map<String, String> map);

    ResultUtil applyingAwards(String token);
}
