package com.school.repository;

import com.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByMetricNumber(String MetricNumber);
    Optional<Student> findByEmail(String email);
    List<Student> findAllByMetricNumberAndEmail(String MetricNumber, String email);
    List<Student> findAllByMetricNumber(String metricNumber);
}



