package com.wj.stuManagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wj.stuManagement.entity.Student;
import com.wj.stuManagement.mapper.StudentMapper;
import com.wj.stuManagement.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WangJin
 * @since 2021-10-05
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {

        List<Student> students = studentMapper.selectList(null);
        return students;
    }

    @Override
    public Student findById(Integer id) {
        Student student = studentMapper.selectById(id);
        return student;
    }


    @Override
    public boolean deleteById(Integer id) {
        int rows = studentMapper.deleteById(id);
        return true;
    }

    @Override
    public boolean update(Student student) {
        int rows = studentMapper.updateById(student);
        if (rows>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Student student) {
        int rows = studentMapper.insert(student);
        if (rows>0){
            return true;
        }
        return false;
    }
}
