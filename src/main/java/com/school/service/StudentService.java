package com.school.service;


import com.school.dto.StudentRequest;
import com.school.dto.Studentupdate;
import com.school.model.Student;
import com.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class StudentService {
    private final StudentRepository studentRepository;


    public ResponseEntity<String> registerStudent(StudentRequest request) {
        Optional<Student> studentOptional = studentRepository.findByMetricNumber(String.valueOf(request.getMetricNumber()));
        if (studentOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Student already exists");
        }
        Student student = new Student();
        student.setCollege(request.getCollege());
        student.setDepartment(request.getDepartment());
        student.setEmail(request.getEmail());
        student.setMetricNumber(String.valueOf(request.getMetricNumber()));
        student.setFullName(request.getFullName());
        student.setRole(request.getRole());
        student.setCreatedDate(new Date());
        student.setUpdatedDate(new  Date());
        studentRepository.save(student);
        return ResponseEntity.ok("Student registered successfully");
    }
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok(studentRepository.findAll());
    }

    public   ResponseEntity<List<Student>> getAllStudentByMetricNumber(String metricNumber){
        return ResponseEntity.ok(studentRepository.findAllByMetricNumber(metricNumber));
    }

    public ResponseEntity<String> deleteStudent(String metricNumber) {
        Optional<Student> studentOptional = studentRepository.findByMetricNumber(metricNumber);
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Student not found");
        }
    }

    public  ResponseEntity <Optional<Student>> getStudentByMetricNumber(String metricNumber){
        return ResponseEntity.ok(studentRepository.findByMetricNumber(metricNumber));
    }

    public ResponseEntity<String> updateStudent(StudentRequest request) {
        Optional<Student> studentOptional = studentRepository.findByMetricNumber(String.valueOf(request.getMetricNumber()));
        if (studentOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Student already exists");
        }
        Student student = studentOptional.get();
        student.setCollege(request.getCollege());
        student.setDepartment(request.getDepartment());
        student.setEmail(request.getEmail());
        student.setMetricNumber(String.valueOf(request.getMetricNumber()));
        student.setFullName(request.getFullName());
        student.setRole(request.getRole());
        student.setCreatedDate(new Date());
        student.setUpdatedDate(new  Date());
        studentRepository.save(student);
        return ResponseEntity.ok("Student updtaed successfully");
    }
    }

