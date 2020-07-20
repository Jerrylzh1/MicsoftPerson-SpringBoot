package org.javaboy.vhr.service;

import org.javaboy.vhr.model.JobLevel;
import org.javaboy.vhr.model.RespBean;

import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/14 20:46
 */
public interface IJobLevelService {
    List<String> findLevel();

    List<JobLevel> findAll();

    RespBean addJobLevel(JobLevel job);

    RespBean updateLevelById(JobLevel jobLevel);

    RespBean deleteLevelById(Integer id);

    RespBean deleteBatchJob(Integer[] ids);
}
