package com.wj.stuManagement.service;

import com.wj.stuManagement.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WangJin
 * @since 2021-10-05
 */
public interface StudentService extends IService<Student> {
    //查询
    List<Student> findAll();
    //根据id查找
    Student findById(Integer id);
    //删除
    boolean deleteById(Integer id);
    //修改
    boolean update(Student student);
    //新增
    boolean add(Student student);
}
