package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Position;

import java.util.List;

@Mapper
public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position position);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getAllPosition();

    Integer deleteBatchPosition(@Param("list") Integer[] ids);
}