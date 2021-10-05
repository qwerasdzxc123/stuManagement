package com.wj.stuManagement.mapper;

import com.wj.stuManagement.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WangJin
 * @since 2021-10-05
 */
public interface StudentMapper extends BaseMapper<Student> {
    List<Student> selectsno(Integer id);
}
