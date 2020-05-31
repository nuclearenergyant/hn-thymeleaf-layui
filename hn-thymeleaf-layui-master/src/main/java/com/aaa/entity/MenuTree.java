package com.aaa.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: weige
 * \* Date: 2020/6/1
 * \* Time: 0:13
 * \* Description: www.diandian.在线
 * \* 功能说明：定义菜单栏的树形菜单
 * \
 */
@Data
public class MenuTree {
    private Integer menuId;

    private String menuName;

    private Integer parentId;

    private Integer orderNum;

    private String url;

    private String menuType;

    private String visible;

    private String perms;

    private String icon;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String remark;

    private List<MenuTree> children;
}