package com.southwind.controller;

import com.southwind.entity.Student;
import com.southwind.service.DormitoryService;
import com.southwind.service.StudentServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServie studentServie;
    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        modelAndView.addObject("list", this.studentServie.list());
        modelAndView.addObject("dormitoryList", this.dormitoryService.availableList());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key,String value){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        modelAndView.addObject("list", this.studentServie.search(key, value));
        modelAndView.addObject("dormitoryList", this.dormitoryService.availableList());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Student student){
        this.studentServie.save(student);
        return "redirect:/student/list";
    }

    @PostMapping("/update")
    public String update(Student student){
        this.studentServie.update(student);
        return "redirect:/student/list";
    }

    @PostMapping("/delete")
    public String delete(Student student){
        this.studentServie.delete(student);
        return "redirect:/student/list";
    }

    @PostMapping("/findByDormitoryId")
    @ResponseBody
    public List<Student> findByDormitoryId(Integer dormitoryId){
        return this.studentServie.findByDormitoryId(dormitoryId);
    }
}
