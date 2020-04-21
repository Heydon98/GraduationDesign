package com.heydon.ezheli.dao;

import com.heydon.ezheli.entity.ApplyingAwards;
import com.heydon.ezheli.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface StudentDao {

    String addStudent(Student student);

    Map<String, Object> findUserByStuIdAndPassword(@Param("stuId") String stuId, @Param("password") String password);
    List<Map<String, Object>> findOpenAwardByStuIdAndCollegeId(@Param("stuId") String stuId,
                                                               @Param("collegeId") int collegeId);
    List<ApplyingAwards> findOpenAwardByStuIdAndCollegeId1(@Param("collegeId") int collegeId, @Param("endApplyTime") String endApplyTime);


}
