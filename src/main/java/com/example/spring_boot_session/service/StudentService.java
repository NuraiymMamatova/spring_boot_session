package com.example.spring_boot_session.service;

import com.example.spring_boot_session.entities.Student;
import com.example.spring_boot_session.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void update(Student student) {
        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        studentRepository.save(student1);
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
