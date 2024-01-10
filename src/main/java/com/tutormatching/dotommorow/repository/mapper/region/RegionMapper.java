package com.tutormatching.dotommorow.repository.mapper.region;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegionMapper {
    public long save(@Param("si") String si,@Param("gun") String gun,@Param("gu") String gu);
}
