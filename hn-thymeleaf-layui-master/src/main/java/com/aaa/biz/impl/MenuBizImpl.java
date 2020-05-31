package com.aaa.biz.impl;

import com.aaa.biz.MenuBiz;
import com.aaa.dao.MenuMapper;
import com.aaa.entity.LayUiTree;
import com.aaa.entity.Menu;
import com.aaa.entity.MenuTree;
import com.aaa.util.TreeUtils;
import com.aaa.util.TreeUtils02;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 陈建
 * @Date: 2020/5/28 0028 11:38
 * @Version 1.0
 */
@Service
public class MenuBizImpl implements MenuBiz {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return 0;
    }

    @Override
    public int insert(Menu record) {
        return 0;
    }

    @Override
    public int insertSelective(Menu record) {
        return 0;
    }

    @Override
    public Menu selectByPrimaryKey(Integer menuId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }

    /**
     * 查询所有的菜单，并组装成tree格式的
     * @return
     */
    @Override
    public List<MenuTree> selectAllMenu() {
        //查询所有的菜单
        List<Menu> menus = menuMapper.selectAllMenu();
        //并组装成tree格式的,给table使用
        return TreeUtils02.getChildPerms(menus, 0);
    }

    @Override
    public List<LayUiTree> selectAllMenuByName(String loginName) {
        //查询所有的菜单
        List<Menu> menus = menuMapper.selectAllMenuByName(loginName);
        //并组装成tree格式的
        return TreeUtils.getChildPerms(menus, 0);
    }

    @Override
    public PageInfo<Menu> showMenuInfo(Integer page, Integer limit, Integer visible, String menuName) {
        return null;
    }

    @Override
    public void addMenu(Menu menu) {
        // TODO Auto-generated method stub
        menuMapper.insert(menu);

    }

    @Override
    public void deleteMenu(Integer menuID) {
        // TODO Auto-generated method stub
        menuMapper.deleteByPrimaryKey(menuID);

    }

    @Override
    public int delMenusByID(List<String> list) {
        // TODO Auto-generated method stub
        return menuMapper.delMenusByID(list);
    }

    @Override
    public void updateMenu(Menu menu) {
        // TODO Auto-generated method stub
        menuMapper.updateByPrimaryKey(menu);
    }
}
