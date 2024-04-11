package com.Sts.FirstJob.Company.Service;

import java.util.List;

import com.Sts.FirstJob.Company.Company;
import com.Sts.FirstJob.Company.Exception.CompanyException;

public interface CompanyService{

	public Company RegisterCompany(Company company);

	public void  update(Company company, long id)throws CompanyException;

	public Company getById(long id)throws CompanyException;

	public List<Company> getAllCompany();
	

	
}
