package com.heydon.ezheli.dao;

import com.heydon.ezheli.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Map;


public interface StudentDao {

    String addStudent(Student student);

    Map findByStuIdAndPassword(@Param("stuId") String stuId, @Param("password") String password);
}
