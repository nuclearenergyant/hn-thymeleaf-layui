package com.aaa.dao;

import com.aaa.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAllRole();

    List<Role> selectRoleInfo(@Param("roleName")String roleName, @Param("roleKey")String roleKey, @Param("status")String status);

    int delRoleByID( @Param("ids") List<String> ids);

    Role selectRoleByRolename(String username);
}