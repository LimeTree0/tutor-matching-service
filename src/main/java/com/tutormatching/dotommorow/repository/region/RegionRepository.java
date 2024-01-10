package com.tutormatching.dotommorow.repository.region;

import com.tutormatching.dotommorow.repository.mapper.region.RegionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RegionRepository {
    private final RegionMapper regionMapper;

    public long save(String si, String gun, String gu) {
        return regionMapper.save(si, gun, gu);
    }
}
