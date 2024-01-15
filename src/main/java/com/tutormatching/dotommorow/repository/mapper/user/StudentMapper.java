package com.tutormatching.dotommorow.repository.mapper.user;

import com.tutormatching.dotommorow.dto.user.student.StudentDto;
import com.tutormatching.dotommorow.dto.user.student.StudentWithUserDto;
import org.apache.ibatis.annotations.*;

import java.time.LocalTime;

/**
 * Student에 대한 정보를 CRUD할 수 있는 Mapper 클래스
 */
@Mapper
public interface StudentMapper {
    // 학생 정보 등록
    @Insert("INSERT INTO student(USERID, REGION_ID, RANGE, YAIL, TIME, CATEGORY, CLASS, ACADEMIC) " +
            "VALUES (#{param1}, #{param2}, #{param3}, " +
            "#{param4}, #{param5}, #{param6}, " +
            "#{param7}, #{param8})")
    void save(String userId,
              Integer regionId,
              String range,
              String yail,
              LocalTime time,
              String category,
              String classLevel,
              String academic);

    // 학생 정보 수정
    @Update("UPDATE student set region_id = #{param2}, " +
            "range = #{param3}, " +
            "yail = #{param4}, " +
            "time = #{param5}, " +
            "category = #{param6}, " +
            "class = #{param7}, " +
            "academic = #{param8} " +
            "where userid = #{param1}")
    void update(String userid,
                Integer regionId,
                String range,
                String yail,
                LocalTime time,
                String category,
                String classLevel,
                String academic);


    // 특정 학생 정보 조회
    StudentDto findById(@Param("userId") String userId);

    // 학생 정보 삭제
    @Delete("DELETE FROM student WHERE userid = #{param1}")
    void delete(String userId);

    StudentWithUserDto selectByIdWithUser(String userId);
}
