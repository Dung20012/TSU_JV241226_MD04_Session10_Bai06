package com.data.session_10.controller;

import com.data.session_10.model.dto.StudentDTO;
import com.data.session_10.model.entity.Student;
import com.data.session_10.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "studentList";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
        return "studentForm";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        Student student = studentService.findById(id);
        if (student == null) {
            return "redirect:/students";
        }
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setStudentName(student.getStudentName());
        dto.setEmail(student.getEmail());
        dto.setAgeMark(student.getAgeMark());
        dto.setIssStudying(student.getIssStudying());
        model.addAttribute("studentDTO", dto);
        return "studentForm";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("studentDTO") StudentDTO dto,
                       BindingResult result) {
        if (result.hasErrors()) {
            return "studentForm";
        }

        Student student = new Student();
        student.setId(dto.getId());
        student.setStudentName(dto.getStudentName());
        student.setEmail(dto.getEmail());
        student.setAgeMark(dto.getAgeMark());
        student.setIssStudying(dto.getIssStudying());

        if (dto.getId() == null) {
            studentService.save(student);
        } else {
            studentService.update(student);
        }
        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
