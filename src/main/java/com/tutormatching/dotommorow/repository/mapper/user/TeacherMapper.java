package com.tutormatching.dotommorow.repository.mapper.user;

import com.tutormatching.dotommorow.dto.user.StudentDto;
import com.tutormatching.dotommorow.dto.user.TeacherDto;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;

/**
 * teacher에 대한 정보를 CRUD할 수 있는 Mapper 클래스
 */
@Mapper
public interface TeacherMapper {
    // 선생님 정보 등록
    @Insert("INSERT INTO teacher(USERID, REGION_ID, YAIL, TIME, COMMENT, CATEGORY, CLASS, ACADEMIC) " +
            "VALUES (#{param1}, #{param2}, #{param3}, " +
            "#{param4}, #{param5}, #{param6}, " +
            "#{param7}, #{param8})")
    void save(String userId,
              Integer regionId,
              LocalDateTime yail,
              LocalDateTime time,
              String comment,
              String category,
              String classLevel,
              String academic);

    // 선생님 정보 수정
    @Update("UPDATE teacher set region_id = #{param2}, " +
            "yail = #{param3}, " +
            "time = #{param4}, " +
            "comment = #{param5}, " +
            "category = #{param6}, " +
            "class = #{param7}, " +
            "academic = #{param8} " +
            "where userid = #{param1}")
    void update(String userid,
                Integer regionId,
                LocalDateTime yail,
                LocalDateTime time,
                String comment,
                String category,
                String classLevel,
                String academic);


    // 특정 선생님 정보 조회
    @Select("SELECT * FROM teacher WHERE userid = #{param1}")
    TeacherDto findById(String userId);

    // 선생님 정보 삭제
    @Delete("DELETE FROM teacher WHERE userid = #{param1}")
    void delete(String userId);
}
