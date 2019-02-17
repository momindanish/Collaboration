package com.niit.dao;

import java.util.List;

import com.niit.model.Job;

public interface JobDao 
{
	boolean addJob(Job job);
	List<Job> getAllJobs();
}
