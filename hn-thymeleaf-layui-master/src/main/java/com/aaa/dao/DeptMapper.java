package com.aaa.dao;

import com.aaa.entity.Dept;
import com.aaa.entity.Depttest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<Dept> selectAllDept();

    List<Depttest> selectAllDept02();

    int delUserByID( @Param("ids") List<String> ids);

    /*搜索栏搜索*/
    List<Dept> mysearch(String dept_name,String status);
}