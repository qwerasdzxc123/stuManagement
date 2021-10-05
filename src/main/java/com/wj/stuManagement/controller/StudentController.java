package com.wj.stuManagement.controller;


import com.wj.stuManagement.entity.Student;
import com.wj.stuManagement.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WangJin
 * @since 2021-10-05
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/Display")
    public ModelAndView Display(){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = studentService.findAll();
        modelAndView.addObject("students",studentList);
        modelAndView.setViewName("Display");
        return modelAndView;
    }

//    @RequestMapping("/del")
//    public ModelAndView del(HttpServletRequest request){
//        int id = Integer.parseInt(request.getParameter("id"));
//        studentService.deleteById(id);
//        return new ModelAndView("redirect:/student/Display");
//    }

    @RequestMapping("/del")
    public ModelAndView del(@Param("id") Integer id){
        studentService.deleteById(id);
        return new ModelAndView("redirect:/student/Display");
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.update();
        return new ModelAndView("redirect:/student/Display");
    }

    @RequestMapping("/addPage")
    public ModelAndView add(Model model){
        model.addAttribute("student",new Student());
        return new ModelAndView("add","stumodel",model);
    }
    @PostMapping("/add")
    public ModelAndView add(Student student){
        studentService.add(student);
        return new ModelAndView("redirect:/student/Display");
    }

    @RequestMapping("/sendid")
    public ModelAndView sendid(Model model,@Param("id") Integer id){

        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return new ModelAndView("Edit","stuEditmodel",model);
    }

    @PostMapping("/update")
    public ModelAndView update(Student student){
        studentService.update(student);
        return new ModelAndView("redirect:/student/Display");
    }
}

