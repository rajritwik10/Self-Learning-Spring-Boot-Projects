package com.Sts.FirstJob.Job.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Sts.FirstJob.Job.job;
import com.Sts.FirstJob.Job.Exception.JobUnavailableException;
import com.Sts.FirstJob.Job.Services.JobService;

@RestController
@RequestMapping("/api")
public class JobController {
	@Autowired
	private JobService jobservice;
	
	
	public JobController(JobService jobservice) {
		this.jobservice = jobservice;
	}
	
	@PostMapping("/job")
	public ResponseEntity<job>AddJob(@RequestBody job naukari){
		job carrier=jobservice.AddJob(naukari);
		return new ResponseEntity<>(carrier,HttpStatus.CREATED);
		
	}
	@GetMapping("/job/{Id}")
	public ResponseEntity<job> getJobsById(@PathVariable long Id) throws JobUnavailableException{
		job carrier = jobservice.getById(Id);
		return ResponseEntity.ok(carrier);
	}
	
	@PutMapping("/job/{Id}")
	public String UpdateJob(@RequestBody job naukari,@PathVariable long Id){
		try {
			jobservice.update(naukari,Id);
		} catch (JobUnavailableException e) {
			e.printStackTrace();
		}
		return "[JobUpdated]";
	}
	@GetMapping("/Jobs")
	public ResponseEntity<List<job>>AllJobs(){
		List<job>AllJob=jobservice.AllJobs();
		return ResponseEntity.ok(AllJob);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<String>DeleteJob(@PathVariable long Id)throws JobUnavailableException{
		boolean deleted=jobservice.deleteJob(Id);
		if(deleted) {
			return new ResponseEntity<>("Job Deleted Successfully",HttpStatus.OK);

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
