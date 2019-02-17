package com.niit.backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDao;
import com.niit.model.Job;

public class JobTestCase 
{
	private static JobDao JobDao;
	@BeforeClass
	public static void executeFirst()
	{
		System.out.println("testcase1");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();

		System.out.println("testcase2");
		context.scan("com.niit");
		System.out.println("testcase2-1");
		context.refresh();

		System.out.println("testcase3");
		JobDao =(JobDao)context.getBean("JobDao");

		System.out.println("testcase4");
	}
	
	@Test
	public void addJobTest()
	{
		Job Job=new Job();
		Job.setJobTitle("jobTitle");
		Job.setJobDescription("jobDescription");
		
		assertTrue("problem in adding the Job",JobDao.addJob(Job));
	}
	/*
	 * @Ignore
	 * 
	 * @Test public void listJobTest() { List<Job> listJobs=JobDao.getAllJobs();
	 * assertTrue("problem in Listing the categories",listJobs.size()>0);
	 * 
	 * for(Job Job:listJobs) { System.out.println("Job ID:"+Job.getJobid());
	 * System.out.println("Job Name:"+Job.getJobtitle());
	 * System.out.println("Job Desc:"+Job.getJobdescription()); } }
	 */
}
