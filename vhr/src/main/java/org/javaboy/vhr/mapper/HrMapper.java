package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.Role;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Mapper
public interface HrMapper {

    int insertSelective(Hr record);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(@Param("userName") String userName);

    List<Role> getHrRolesById(Integer id);
}