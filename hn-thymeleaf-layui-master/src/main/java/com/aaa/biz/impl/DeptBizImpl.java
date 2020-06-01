package com.aaa.biz.impl;

import com.aaa.biz.DeptBiz;
import com.aaa.dao.DeptMapper;
import com.aaa.entity.Dept;
import com.aaa.entity.Depttest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 陈建
 * @Date: 2020/5/29 0029 16:49
 * @Version 1.0
 */
@Service
public class DeptBizImpl implements DeptBiz {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public int insertSelective(Dept record) {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        record.setCreateTime(date);
        return deptMapper.insertSelective(record);
    }

    /*通过搜索栏-搜索*/
    @Override
    public List<Dept> search(String dept_name,String status) {
        List<Dept> deptList=deptMapper.mysearch(dept_name,status);
        return deptList;
    }

    @Override
    public List<Dept>selectAllDept(){
        return deptMapper.selectAllDept();
    }

    @Override
    public List<Depttest>selectAllDept02(){
        return deptMapper.selectAllDept02();
    }
    @Override
    public  int updateByPrimaryKeySelective(Dept record) {
        record.setUpdateTime(new Date());
        return deptMapper.updateByPrimaryKeySelective(record);
    }
    @Override
    public int delUserByID(List<String> ids) {
        return deptMapper.delUserByID( ids) ;
    }
}
