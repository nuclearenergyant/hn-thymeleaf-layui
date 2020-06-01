package com.aaa.controller;

import com.aaa.biz.DeptBiz;
import com.aaa.biz.impl.DeptBizImpl;
import com.aaa.entity.Dept;
import com.aaa.entity.DeptTree;
import com.aaa.entity.Depttest;
import com.aaa.entity.LayUiTable;
import com.aaa.util.MyConstants;
import com.alibaba.fastjson.JSON;
import javafx.scene.DepthTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptBizImpl deptBizImpl;

    @RequestMapping("/toShowDept")
    public String  toShowDept(){

        return "dept/showDept";
    }
    @RequestMapping("/toShowsearchDept")
    public String  toShowsearchDept(){
        return "dept/showDept";
    }


    @RequestMapping("/searchDept")
    @ResponseBody
    public Object searchDept(String deptName,String status){
        //开始查询
        List<Dept> deptList = deptBizImpl.search(deptName,status);
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setCount(deptList.size());
        layUiTable.setData(deptList);
        return layUiTable;
    }

    @RequestMapping("/showDept")
    @ResponseBody
    public LayUiTable showDept() {
        //开始查询
        List<Dept> deptList = deptBizImpl.selectAllDept();
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setData(deptList);
        return layUiTable;
    }

    @RequestMapping("/showDept02")
    @ResponseBody
    public  DeptTree showDept02() {
        //开始查询
        List<Dept> deptList = deptBizImpl.selectAllDept();
        DeptTree layUiTable = new DeptTree();

        //新建list
        List<Dept> newlist=new ArrayList<Dept>();
        layUiTable.setTitle("选择用户所属部门");
        for (int i=0;deptList.size()>i;i++){
            Dept dept=new Dept();
            dept= deptList.get(i);
            dept.setTitle(deptList.get(i).getDeptName());
            newlist.add(dept);
        }
        layUiTable.setChildren(newlist);
        return layUiTable;
    }

    @RequestMapping("/saveDept")
    @ResponseBody
    public Object saveUser(Dept tbl_dept){
        int i=deptBizImpl.insertSelective(tbl_dept);
        Map map=new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.saveSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.saveFailMsg);
        }
        return map;

    }
    @RequestMapping("/editDept")
    @ResponseBody
    public Object editUser(Dept tbl_dept){
        int i = deptBizImpl.updateByPrimaryKeySelective(tbl_dept);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.editSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.editFailMsg);
        }
        return map;
    }


    @RequestMapping("/delDept")
    @ResponseBody
    public Object delUser( @RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<String> list= (List<String>) JSON.parse(ids);
        int i = deptBizImpl.delUserByID(list);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",MyConstants.successCode);
            map.put("message",MyConstants.delSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.delFailMsg);
        }
        return map;
    }

   /* @RequestMapping("/searchDept")
    @ResponseBody
    public Object searchDept(String deptName,String status){
        //开始查询
        List<Dept> deptList = deptBizImpl.search(deptName,status);
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setData(deptList);
        System.out.println(layUiTable);
        return layUiTable;
    }*/
}
