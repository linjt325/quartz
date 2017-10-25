package com.lin.quartz.service;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JobService {
	String savePath = "D:\\test";
//	String savePath = "D:\\WorkSpace\\WorkSpace-application\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\water-schedule\\Schedule\\simufactory\\data";

	public void test(String type) throws InterruptedException {
		System.out.println("测试开始" + type);
		Thread.sleep(3000);
		System.out.println("测试结束:" + type);
	}

	public void method1() throws InterruptedException {
		File files = new File(savePath);
		System.out.println(files);
		File[] file1 = files.listFiles(new FileFilter() {

			@Override
			public boolean accept( File file) {
				if (file.isDirectory() && file.getName().startsWith("20")) {
					return true;
				}
				return false;
			}
		});
		Collections.sort(Arrays.asList(file1), new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				return Integer.valueOf(o1.getName()).compareTo(Integer.valueOf(o2.getName()));
			}
		});
		for(int i=0;i<file1.length-1;i++){
			deepDelete(file1[i]);
//			System.out.println(file1[i].delete());
			
		}
		System.out.println(file1);
		System.out.println(1);
		System.out.println("测试结束:1");
	}

	public void method2() throws InterruptedException {
		System.out.println(2);
		System.out.println("测试结束:2");
	}

	public void method3() throws InterruptedException {
		System.out.println(3);
		// Thread.sleep(3000);
		System.out.println("测试结束:3");
	}

	/**
	 * 尝试删除 dir 及其下的所有文件 
	 * @param dir
	 * @return
	 */
	public boolean deepDelete(File dir){
		
		if(dir.isDirectory()){
			File[] files =dir.listFiles();
			for(File file : files){
				boolean isSuccess=deepDelete(file);
//				if(!isSuccess){
//					return false; //一个删除失败 ,删除结束 返回false
//				}
			}
		}
		return dir.delete();
		
	}
}
