package com.Sts.FirstJob.Job.Services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.Sts.FirstJob.Job.job;
import com.Sts.FirstJob.Job.Exception.JobUnavailableException;

public interface JobService {
	
	public job AddJob(job naukari);

	public void update(job naukari,long Id)throws JobUnavailableException;
	
	public job getById(long Id)throws JobUnavailableException;
	
	public List<job> AllJobs();
	
	public boolean deleteJob(long Id) throws JobUnavailableException;
}
