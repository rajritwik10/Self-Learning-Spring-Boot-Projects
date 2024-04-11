package com.Sts.FirstJob.Job.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sts.FirstJob.Job.job;
import com.Sts.FirstJob.Job.Exception.JobUnavailableException;
import com.Sts.FirstJob.Job.Repository.jobRepository;
import com.Sts.FirstJob.Job.Services.JobService;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private jobRepository jobrepository;

	public JobServiceImpl(jobRepository jobrepository) {
		super();
		this.jobrepository = jobrepository;
	}

	@Override
	public job AddJob(job naukari) {
		job carrier = jobrepository.save(naukari);
		return carrier;
	}

	@Override
	public void update(job naukari,long Id) throws JobUnavailableException {

		job carrier = jobrepository.findById(Id).orElseThrow(() -> new JobUnavailableException("Job Not Present"));
		if (carrier != null) {
			carrier.setTitle(naukari.getTitle());
			carrier.setDescription(naukari.getDescription());
			carrier.setMinSalary(naukari.getMinSalary());
			carrier.setMaxSalary(naukari.getMaxSalary());
//			carrier.setId(null);
			jobrepository.save(carrier);
		} else {
			throw new JobUnavailableException("Job Not Found");
		}
	}

	@Override
	public job getById(long Id) throws JobUnavailableException {
		job carrier = jobrepository.findById(Id).orElseThrow(() -> new JobUnavailableException("Job Not Present"));
		return carrier;
	}

	@Override
	public List<job> AllJobs() {
		List<job> Jobs = jobrepository.findAll();
		return Jobs;
	}

	@Override
	public boolean deleteJob(long Id) throws JobUnavailableException {
		
		job offer=jobrepository.findById(Id)
				.orElseThrow(()->new JobUnavailableException());
		if(offer!=null) {
			jobrepository.deleteById(Id);
			return true;
		}
		return false;
	}

}
