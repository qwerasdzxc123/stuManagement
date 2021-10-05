package com.wj.stuManagement.service;

import com.wj.stuManagement.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: WangJin
 * @description
 * @date: 2021/10/5 20:02
 */
@SpringBootTest
public class serviceTest {
    @Autowired
    private StudentService studentService;

    //查询
    @Test
    public void find(){
        List<Student> lists = studentService.findAll();
        for (Student list : lists) {
            System.out.println(list);
        }
    }

    //删除
    @Test
    public void deleteById() {
        boolean delete = studentService.deleteById(3);
        System.out.println(delete);
    }
//    //修改
    @Test
    public void update() {
        Student student = new Student();
        student.setId(4);
        student.setName("王劲");
        boolean update = studentService.update(student);
        System.out.println(update);
    }
//    //新增
    @Test
   public void add(){
        Student student = new Student();
        student.setName("哇干净");
        student.setAddress("黄石");
        student.setAge(18);
        boolean add = studentService.add(student);
        System.out.println(add);
    }
}
