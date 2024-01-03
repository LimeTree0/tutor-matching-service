package com.tutormatching.dotommorow.repository.mapper.test;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface TestMapper {
    @Insert("INSERT INTO test(name) VALUES(#{name})")
    void save(String name);

    @Update("UPDATE test SET name = #{name} WHERE id = #{id}")
    void update(@Param("id") Long id, @Param("name") String name);

    @Select("SELECT name FROM test")
    List<String> findAll();

    @Select("SELECT name FROM test WHERE id = #{id}")
    String findById(Long name);
}