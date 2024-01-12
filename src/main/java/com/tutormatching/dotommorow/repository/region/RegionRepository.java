package com.tutormatching.dotommorow.repository.region;

import com.tutormatching.dotommorow.dto.region.RegionDto;
import com.tutormatching.dotommorow.repository.mapper.region.RegionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RegionRepository {
    private final RegionMapper regionMapper;

    // 지역 정보 등록
    public long save(String si, String gun, String gu) {
        return regionMapper.save(si, gun, gu);
    }

    // ID로 지역 정보 조회
    public RegionDto findById(Long id) {
        return regionMapper.findById(id);
    }

    // 지역 정보 수정
    public void update(RegionDto regionDto) {
        regionMapper.update(regionDto);
    }
}
