package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.javaboy.vhr.model.HrRole;

@Mapper
public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);
}