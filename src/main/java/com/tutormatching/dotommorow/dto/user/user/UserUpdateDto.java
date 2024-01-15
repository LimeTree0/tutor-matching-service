package com.tutormatching.dotommorow.dto.user.user;

import com.tutormatching.dotommorow.dto.region.RegionDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.eclipse.tags.shaded.org.apache.xml.utils.MutableAttrListImpl;
import org.springframework.web.multipart.MultipartFile;

// 유저 수정 정보를 받아오는 DTO

@Getter
@Setter
@ToString
public class UserUpdateDto {
    private String userId;
    private String si;
    private String gun;
    private String gu;
    private String gender;
    private Integer age;
    private String userName;
    private String profileImageName;
    private String phoneNumber;
}
