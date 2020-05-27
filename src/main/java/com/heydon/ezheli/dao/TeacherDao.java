package com.heydon.ezheli.dao;

import com.heydon.ezheli.entity.*;
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

    List<Award> findAwardNameByBigType(@Param("teacId") String teacId,
                                       @Param("bigTypeId") String bigTypeId);

    List<Apply> getNotCheckApplies(@Param("awardId") String awardId);

    List<Apply> getCheckedApplies(@Param("awardId") String awardId);

    void updateCheck(@Param("stuAwardId") String stuAwardId,
                     @Param("checkResult") String checkResult,
                     @Param("teacId") String teacId,
                     @Param("teacName") String teacName,
                     @Param("checkTime") String checkTime);

    List<WinStudent> getWinStudents(@Param("awardId") String awardId);

    List<Statistics> getWinStuNum(@Param("awardId") String awardId);

    String getAwardNameByAwardId(@Param("awardId") String awardId);
}
