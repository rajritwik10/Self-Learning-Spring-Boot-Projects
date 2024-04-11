package com.Sts.FirstJob.Job.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sts.FirstJob.Job.job;

import jakarta.persistence.Id;

@Repository
public interface jobRepository extends JpaRepository<job,Long>{
	
}
