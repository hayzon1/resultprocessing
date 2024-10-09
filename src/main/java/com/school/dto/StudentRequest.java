package com.school.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@Builder
public class StudentRequest {
    private String fullName;
    private String email;
    private String MetricNumber;
    private String college;
    private String role;
    private String department;
    private String level;
    private Date createdDate;
    private Date updatedDate;

}
