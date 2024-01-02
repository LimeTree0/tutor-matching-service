package com.tutormatching.dotommorow.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface TestMapper {
    void save(String name);

    void update(@Param("id") Long id, @Param("name") String name);

    List<String> findAll();

    String findById(Long name);


}
