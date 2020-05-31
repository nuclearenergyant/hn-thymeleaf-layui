package com.aaa.biz;

import com.aaa.entity.Dept;
import com.aaa.entity.Role;

import java.util.List;

/**
 * @Author: 陈建
 * @Date: 2020/5/29 0029 16:36
 * @Version 1.0
 */
public interface DeptBiz {
   List<Dept> selectAllDept();
   int updateByPrimaryKeySelective(Dept record);
   int delUserByID(List<String> ids);

   int insertSelective(Dept record);

   List<Dept> search(String dept_name,String status);
}
