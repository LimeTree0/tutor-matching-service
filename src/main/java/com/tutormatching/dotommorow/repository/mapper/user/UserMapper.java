package com.tutormatching.dotommorow.repository.mapper.user;

import com.tutormatching.dotommorow.dto.user.UserDto;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * User에 대한 정보를 CRUD할 수 있는 Mapper 클래스
 */
@Mapper
public interface UserMapper {
    // 회원 정보 등록
    @Insert("INSERT INTO users VALUES (#{param1}, #{param2}, #{param3}, " +
            "#{param4}, #{param5}, #{param6}, " +
            "#{param7}, #{param8}, #{param9})")
    void save(String userId, Long regionId, String password, String gender
            , Integer age, String userName, String profileImage, String phoneNumber
            , LocalDateTime signUpDate);

    // 회원 정보 수정
    @Update("UPDATE users set region_id = #{param2}, " +
            "gender = #{param3}, " +
            "age = #{param4}, " +
            "username = #{param5}, " +
            "profile_image = #{param6}, " +
            "phoneNumber = #{param7} where userid = #{param1}")
    void update(String userId, Long regionId, String gender
            , Integer age, String userName, String profileImage, String phoneNumber);

    // 모든 회원 정보 조회
    @Select("SELECT * FROM users ORDER BY userid ASC")
    List<UserDto> findAll();

    // 특정 회원 정보 조회
    @Select("SELECT * FROM users WHERE userid = #{param1}")
    UserDto findById(String userId);

    // 회원 정보 삭제
    @Delete("DELETE FROM users WHERE userid = #{param1}")
    void delete(String userId);
}
