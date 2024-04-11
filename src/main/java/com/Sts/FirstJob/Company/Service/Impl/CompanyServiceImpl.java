package com.Sts.FirstJob.Company.Service.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Sts.FirstJob.Company.Company;
import com.Sts.FirstJob.Company.Exception.CompanyException;
import com.Sts.FirstJob.Company.Repository.CompanyRepository;
import com.Sts.FirstJob.Company.Service.CompanyService;
@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired
	private CompanyRepository companyrepository;
	
	public CompanyServiceImpl(CompanyRepository companyrepository) {
		this.companyrepository = companyrepository;
	}

	public Company getById(@PathVariable long id) throws CompanyException{
		Company office=companyrepository.findById(id).orElseThrow(()->new CompanyException());
		return office;
	}

	public ArrayList<Company> getAllCompany() {
		ArrayList<Company>AllCompany=new ArrayList<>(companyrepository.findAll());
		return AllCompany;
	}

	public void update(@RequestBody Company company, @PathVariable long Id) throws CompanyException {
		Company office=companyrepository.findById(Id).orElseThrow(()->new CompanyException("NotFound"));
		if(office!=null) {
			office.setName(company.getName());
			office.setDescription(company.getDescription());	
		}
		companyrepository.save(office);
		
	}
	@Override
	public Company RegisterCompany(@RequestBody Company offer) {
		Company office=companyrepository.save(offer);
		return office;
	}

}
