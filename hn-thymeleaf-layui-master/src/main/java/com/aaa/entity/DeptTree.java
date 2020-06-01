package com.aaa.entity;

import lombok.Data;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: weige
 * \* Date: 2020/6/1
 * \* Time: 13:29
 * \* Description: www.diandian.在线
 * \* 功能说明：
 * \
 */
@Data
public class DeptTree {
    private String title;
    private List<Dept> children;
}