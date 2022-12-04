package com.example.spring_boot_session.api;

import com.example.spring_boot_session.entities.Student;
import com.example.spring_boot_session.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class StudentApi {

    private final StudentService studentService;

    @GetMapping("/")
    public String getAllStudent(Model model) {
        model.addAttribute("allStudent", studentService.getAll());
        return "index";
    }

    @GetMapping("/new")
    public String newStudent(Model model) {
        model.addAttribute("newStudent", new Student());
        return "save";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("newStudent") Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/update")
    private String upStudent(@RequestParam("id") Long id, Model model) {
        model.addAttribute("updateStudent", studentService.getById(id));
        return "update";
    }

    @PostMapping("/update")
    private String dateStudent(@ModelAttribute("updateStudent") Student student) {
        studentService.update(student);
        return "redirect:/";
    }

    @RequestMapping("/delete")
    private String deleteCompany(@RequestParam("id") Long id) {
        studentService.delete(studentService.getById(id));
        return "redirect:/";
    }
}
