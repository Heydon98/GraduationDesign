package com.heydon.ezheli.dao;

import com.heydon.ezheli.entity.ApplyingAwards;
import com.heydon.ezheli.entity.OpenAwards;
import com.heydon.ezheli.entity.PersonalInfo;
import com.heydon.ezheli.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface StudentDao {

    String addStudent(Student student);

    Map<String, Object> findUserByStuIdAndPassword(@Param("stuId") String stuId,
                                                   @Param("password") String password);

    List<OpenAwards> findOpenAwardByStuIdAndCollegeId(@Param("stuId") String stuId,
                                                      @Param("collegeId") int collegeId);

    List<OpenAwards> findOpenAwardByStuIdAndCollegeId1(@Param("collegeId") int collegeId, @Param("endApplyTime") String endApplyTime);

    void addApplyAward(@Param("stuId") String stuId,
                       @Param("realName") String realName,
                       @Param("awardId") String awardId,
                       @Param("awardName") String awardName,
                       @Param("reason") String reason,
                       @Param("applyTime") String applyTime);

    List<ApplyingAwards> findApplyingAwardsByStuId(@Param("stuId") String stuId);

    PersonalInfo getPersonalInfo(@Param("stuId") String stuId);

    void changeInfo(@Param("stuId") String stuId,
                    @Param("wechat") String wechat,
                    @Param("qq") String qq,
                    @Param("tel") String tel,
                    @Param("email") String email);
}
