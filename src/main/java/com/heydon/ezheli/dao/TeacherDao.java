package com.heydon.ezheli.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface TeacherDao {
    Map<String, String> findTeacByTeacIdAndPassword(@Param("teacId") String teacId,
                                                    @Param("password") String password);
}
