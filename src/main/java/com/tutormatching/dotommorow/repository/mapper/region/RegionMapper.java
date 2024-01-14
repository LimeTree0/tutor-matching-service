package com.tutormatching.dotommorow.repository.mapper.region;

import com.tutormatching.dotommorow.dto.region.RegionDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegionMapper {
    // 지역 정보 등록
    public long save(RegionDto regionDto);

    // ID로 지역 정보 조회
    public RegionDto findById(Long id);

    // 지역 정보 수정
    public void update(RegionDto regionDto);
}
