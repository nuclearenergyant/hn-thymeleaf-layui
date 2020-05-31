package com.aaa.util;


import com.aaa.entity.LayUiTree;
import com.aaa.entity.Menu;
import com.aaa.entity.MenuTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeUtils02
{
    /**
     * 根据父节点的ID获取所有子节点
     * 
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public static List<MenuTree> getChildPerms(List<Menu> list, int parentId)
    {
        List<MenuTree> returnList = new ArrayList<MenuTree>();
        for (Menu menu : list) {
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if(menu.getParentId()==parentId){
                //将menu对象转换成tree对象
                MenuTree tree = fromMenuToTree(menu);
                //开始递归，把所有菜单和当前菜单放入
                recursionFn(list, tree);
                returnList.add(tree);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     * 
     * @param list
     * @param t
     */
    private static void recursionFn(List<Menu> list, MenuTree t)
    {
        // 得到t的子节点列表
        List<MenuTree> childList = getChildList(list, t);
        t.setChildren(childList);
        for (MenuTree tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                // 判断是否有子节点
                Iterator<MenuTree> it = childList.iterator();
                while (it.hasNext())
                {
                    MenuTree n =  it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private static List<MenuTree> getChildList(List<Menu> list, MenuTree t)
    {

        List<MenuTree> tlist = new ArrayList<MenuTree>();
        Iterator<Menu> it = list.iterator();
        while (it.hasNext())
        {
            Menu menu = (Menu) it.next();
            if (menu.getParentId() == t.getMenuId())
            {
                MenuTree tree = fromMenuToTree(menu);
                tlist.add(tree);
            }
        }
        return tlist;
    }


/**
     * 判断是否有子节点
     */

    private static boolean hasChild(List<Menu> list, MenuTree t)
    {
        int size = getChildList(list, t).size();
        if(size>0){
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * 将menu对象转换成tree对象
     * @param menu
     * @return
     */
    private static MenuTree fromMenuToTree(Menu menu){
        //构造tree对象
        MenuTree tree= new MenuTree();
        tree.setMenuId(menu.getMenuId());
        tree.setMenuName(menu.getMenuName());
        tree.setParentId(menu.getParentId());
        tree.setOrderNum(menu.getOrderNum());
        tree.setUrl(menu.getUrl());
        tree.setMenuType(menu.getMenuType());
        tree.setVisible(menu.getVisible());
        tree.setPerms(menu.getPerms());
        tree.setIcon(menu.getIcon());
        tree.setCreateBy(menu.getCreateBy());
        tree.setCreateTime(menu.getCreateTime());
        tree.setUpdateBy(menu.getUpdateBy());
        tree.setUpdateTime(menu.getUpdateTime());
//        tree.setId(menu.getMenuId());
//        tree.setTitle(menu.getMenuName());
//        tree.setChecked(false);
//        tree.setUrl(menu.getUrl());
        return tree;
    }

}
