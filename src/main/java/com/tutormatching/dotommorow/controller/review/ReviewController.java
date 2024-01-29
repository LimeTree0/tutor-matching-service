package com.tutormatching.dotommorow.controller.review;

import com.tutormatching.dotommorow.dto.review.ReviewDto;
import com.tutormatching.dotommorow.dto.review.ReviewRequestDto;
import com.tutormatching.dotommorow.dto.user.student.StudentDto;
import com.tutormatching.dotommorow.service.review.ReviewService;
import com.tutormatching.dotommorow.service.user.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final StudentService studentService;
    @PostMapping("/review")
    @ResponseBody
    public HttpStatus review(@ModelAttribute ReviewRequestDto reviewRequestDto, Principal principal) {
        String userId = principal.getName();
        StudentDto studentDto = studentService.findById(userId);
        Integer studentId = studentDto.getStudentId();
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setStudentId(studentId);
        reviewDto.setReviewRequestDto(reviewRequestDto);
        reviewDto.setReviewDate(LocalDateTime.now());

        reviewService.save(reviewDto);

        log.info("reviewRequestDto: {}", reviewRequestDto);
        log.info("reviewDto: {}", reviewDto);

        return HttpStatus.OK;

    }

    @DeleteMapping("/review/{studentId}/{reviewId}")
    @ResponseBody
    public HttpStatus deleteReview(@PathVariable("studentId") Integer studentId,
                                   @PathVariable("reviewId") Integer reviewId,
                                   Principal principal) {
        String userId = principal.getName();
        StudentDto studentDto = studentService.findById(userId);

        if (studentDto.getStudentId().equals(studentId)) {
            reviewService.deleteByReviewId(reviewId);
        }
        return HttpStatus.OK;
    }

}
