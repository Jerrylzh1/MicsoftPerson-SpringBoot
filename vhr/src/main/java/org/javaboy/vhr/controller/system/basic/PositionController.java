package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.model.Position;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/13 19:01
 */

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    IPositionService positionService;

    @GetMapping
    public List<Position> getAllPosition(){
        List<Position> positionList=new ArrayList<>();
        positionList=positionService.getAllPosition();
        return positionList;
    }

    @PostMapping
    public RespBean addPosition(@RequestBody Position position){
        return positionService.addPosition(position);
    }

    @PutMapping
    public RespBean updatePosition(@RequestBody Position position){
        return positionService.updatePosition(position);
    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable  Integer id){
        return positionService.deletePosition(id);
    }

    @DeleteMapping("/")
    public RespBean deleteBatchPosition(Integer[] ids){
        return positionService.deleteBatchPosition(ids);
    }

}
