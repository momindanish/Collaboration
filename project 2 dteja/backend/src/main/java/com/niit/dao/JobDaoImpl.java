package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Job;

@Repository("JobDao")
@Transactional
public class JobDaoImpl  implements JobDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	public boolean addJob(Job job) 
	{
		System.out.println("add job1");
	Session session=sessionFactory.getCurrentSession();
	System.out.println("add job2");
	session.save(job);
	return true;
	}
	
	public List<Job> getAllJobs() 
	{
		Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Job");	
        List<Job> jobs=query.list();
        return jobs;
	}
}
