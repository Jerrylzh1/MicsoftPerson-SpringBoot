package org.javaboy.vhr.service.ServiceImpl;

import org.javaboy.vhr.mapper.PositionMapper;
import org.javaboy.vhr.model.Position;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/13 19:03
 */

@Service
public class PositionServiceImpl  implements IPositionService {

    @Autowired
    PositionMapper positionMapper;

    /**
     * 获取所有的人员信息
     * @return
     */
    @Override
    public List<Position> getAllPosition() {
        return positionMapper.getAllPosition();
    }

    @Override
    public RespBean addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        int i = positionMapper.insert(position);
        if (i>0){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 对人员进行更新操作
     * @param position
     * @return
     */
    @Override
    public RespBean updatePosition(Position position) {
        position.setCreateDate(new Date());
        if (positionMapper.updateByPrimaryKeySelective(position)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 删除人员操作
     * @param id
     * @return
     */
    @Override
    public RespBean deletePosition(Integer id) {
        if (positionMapper.deleteByPrimaryKey(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    /**
     * 批量删除数据
     * @param ids
     * @return
     */
    @Override
    public RespBean deleteBatchPosition(Integer[] ids) {
        if (positionMapper.deleteBatchPosition(ids)>0){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
