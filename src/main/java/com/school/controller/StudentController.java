package com.school.controller;

import com.school.dto.StudentRequest;
import com.school.dto.Studentupdate;
import com.school.model.Student;
import com.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin("*")

public class StudentController {
private final StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> all(){
        return studentService.getAllStudent();
    }

    @GetMapping("/matric_no")
    public ResponseEntity<List<Student>> getLevel(@RequestParam("metricNumber")String metricNumber){
        return studentService.getAllStudentByMetricNumber(metricNumber);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody StudentRequest request) {
        return studentService.registerStudent(request);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam("metricNo")String metricNo) {
        return studentService.deleteStudent(metricNo);
    }

    @PutMapping("/update")
    public ResponseEntity <String> updateStudent(@RequestBody StudentRequest request) {
        return studentService.updateStudent(request);
        }
//
//    Optional<Student> existingStudent = studentService.updateStudent();
//        if (existingStudent.isPresent()) {
//            ResponseEntity <String> updateStudent = studentService.updateStudent(( ("metricNumber")));
//            return updateStudent ;
//        }
//        return ResponseEntity.notFound().build();
//    }
}

