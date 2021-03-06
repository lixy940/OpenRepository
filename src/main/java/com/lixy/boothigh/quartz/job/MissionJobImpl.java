package com.lixy.boothigh.quartz.job;


import com.lixy.boothigh.service.TaskService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时导入任务
 *
 * @param
 * @return
 */
@Component
@DisallowConcurrentExecution
public class MissionJobImpl implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(MissionJobImpl.class);
    @Autowired
    private TaskService taskService;
    @Override
    public void execute(JobExecutionContext context) {
        try {
            JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
            if (jobDataMap.get("dataId") != null) {
                Integer dataId = Integer.valueOf(String.valueOf(jobDataMap.get("dataId")));
                taskService.syncData(dataId);
            }
        } catch (Exception e) {
            LOGGER.error("定时任务导入执行失败", e);
        }
    }
}
