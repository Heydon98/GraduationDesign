package com.heydon.ezheli.service;

import com.heydon.ezheli.util.RetResultUtil;

import java.util.Map;

public interface StudentService {
    RetResultUtil login(Map<String, String> map);
}
