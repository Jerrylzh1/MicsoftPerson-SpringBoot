package org.javaboy.vhr.service.ServiceImpl;

import org.javaboy.vhr.mapper.JobLevelMapper;
import org.javaboy.vhr.model.JobLevel;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.IJobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/14 20:46
 */
@Service
public class JobLevelServiceImpl implements IJobLevelService {

    @Autowired
    JobLevelMapper JobLevelMapper;

    @Override
    public List<String> findLevel() {
        return JobLevelMapper.findLevel();
    }

    @Override
    public List<JobLevel> findAll() {
        return JobLevelMapper.findAll();
    }

    @Override
    public RespBean addJobLevel(JobLevel job) {
        job.setEnabled(true);
        job.setCreateDate(new Date());
        int i=JobLevelMapper.insert(job);
        if (i>0){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RespBean updateLevelById(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        int i=JobLevelMapper.updateByPrimaryKeySelective(jobLevel);
        if (i>0){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RespBean deleteLevelById(Integer id) {
        int i=JobLevelMapper.deleteByPrimaryKey(id);
        if (i>0){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RespBean deleteBatchJob(Integer[] ids) {
        int i=JobLevelMapper.deleteBatchJob(ids);
        if (i==ids.length){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }
}
