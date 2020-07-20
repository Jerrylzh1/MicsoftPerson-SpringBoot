package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.model.JobLevel;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.IJobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/14 20:43
 */
@RestController
@RequestMapping("/system/")
public class JobLevelController {

    @Autowired
    IJobLevelService jobLevelService;
    //获取在线的jobtitleLevel
    @GetMapping("basic/job/jobLevel")
    public List<String> findLevel() {
        return jobLevelService.findLevel();
    }

    //获取在线的jobtitleLevel
    @GetMapping("/basic/job")
    public List<JobLevel> findAll() {
        return jobLevelService.findAll();
    }

    //获取在线的jobtitleLevel
    @PostMapping("/basic/job")
    public RespBean addJobLevel(@RequestBody JobLevel job) {
        return jobLevelService.addJobLevel(job);
    }

    //更新在线的jobtitleLevel
    @PutMapping("/basic/job")
    public RespBean updateLevelById(@RequestBody JobLevel jobLevel) {
        return jobLevelService.updateLevelById(jobLevel);
    }

    //删除在线的jobtitleLevel
    @DeleteMapping("/basic/job/{id}")
    public RespBean deleteLevelById(@PathVariable Integer id) {
        return jobLevelService.deleteLevelById(id);
    }

    @DeleteMapping("/basic/job")
    public RespBean deleteBatchJob(Integer[] ids){
        return jobLevelService.deleteBatchJob(ids);
    }


}
