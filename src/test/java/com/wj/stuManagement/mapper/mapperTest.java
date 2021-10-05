package com.wj.stuManagement.mapper;

import com.wj.stuManagement.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: WangJin
 * @description
 * @date: 2021/10/5 19:59
 */
@SpringBootTest
public class mapperTest {
    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void findAll() {
        List<Student> students = studentMapper.selectList(null);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void selectById(){
        List<Student> selectsno = studentMapper.selectsno(11);
        System.out.println(selectsno);
    }
}
