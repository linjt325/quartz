package com.lin.quartz.schedule;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.lin.quartz.service.JobService;

public class Job implements org.quartz.Job{
	@Autowired
	JobService jobService;
	
	public void executeWithTargetMethod(List<String> methods) throws InterruptedException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		System.out.println(methods);
		for(String method:methods)
			jobService.getClass().getMethod(method).invoke(jobService);
		}
	public void executeWithTargetMethod(String xx,Job job) throws InterruptedException{
		System.out.println("指定方法执行!"+xx+job.toString());
		Thread.sleep(3000);
		System.out.println("====方法结束=====");
	}

	public void executeWithTargetMethod(String xx,String yyy) throws InterruptedException{
//		System.out.println(this.toString());
		jobService.test("111");
//		System.out.println("指定方法执行!"+xx+yyy);
//		Thread.sleep(3000);
//		System.out.println("====方法结束=====");
	}
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
//		System.out.println(this.toString());
		jobService=(JobService) context.getJobDetail().getJobDataMap().get("service");
		try {
			jobService.test("222");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println("实现Job接口执行!");
	}

	public static void executeWithStaticMethod(){
		System.out.println("执行指定静态方法");
	}
}
