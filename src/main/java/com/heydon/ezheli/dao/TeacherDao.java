package com.heydon.ezheli.dao;

import com.heydon.ezheli.entity.AllTeacs;
import com.heydon.ezheli.entity.Award;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeacherDao {
    Map<String, String> findTeacByTeacIdAndPassword(@Param("teacId") String teacId,
                                                    @Param("password") String password);

    List<Award> findAwardByTeacId(@Param("teacId") String teacId);

    int getMaxAwardId();

    void addNewAward(@Param("awardId") int awardId,
                     @Param("bigType") String bigType,
                     @Param("smallType") String smallType,
                     @Param("collegeId") int collegeId,
                     @Param("awardName") String awardName,
                     @Param("createTime") String createTime,
                     @Param("introduce") String introduce,
                     @Param("limitNum") String limitNum,
                     @Param("teacId") String teacId,
                     @Param("realName") String realName,
                     @Param("stateId") int stateId);

    void changeAwardState(@Param("awardId") String awardId,
                          @Param("stateId") String stateId);

    void deleteAward(@Param("awardId") String awardId);

    void deleteStuAward(@Param("awardId") String awardId);

    List<AllTeacs> findTeachers();

    List<AllTeacs> findCheckTeacsByAwardId(@Param("awardId") String awardId);

    String findNameByTeacId(@Param("teacId") String teacId);

    void addCheckTeac(@Param("teacId") String teacId,
                      @Param("teacName") String teacName,
                      @Param("awardId") String awardId);

    void deleteCheckTeac(@Param("teacId") String teacId,@Param("awardId") String awardId);
}
