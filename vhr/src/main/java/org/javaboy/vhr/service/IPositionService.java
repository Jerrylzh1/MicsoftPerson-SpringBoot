package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Position;
import org.javaboy.vhr.model.RespBean;

import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/13 19:02
 */
public interface IPositionService {
    List<Position> getAllPosition();

    RespBean addPosition(Position position);

    RespBean updatePosition(Position position);

    RespBean deletePosition(Integer id);

    RespBean deleteBatchPosition(Integer[] ids);
}
