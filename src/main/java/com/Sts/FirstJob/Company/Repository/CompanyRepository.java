package com.Sts.FirstJob.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sts.FirstJob.Company.Company;

import jakarta.persistence.Id;
@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{

	
}
