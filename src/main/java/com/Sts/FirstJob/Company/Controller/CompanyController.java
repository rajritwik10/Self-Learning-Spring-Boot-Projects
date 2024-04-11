package com.Sts.FirstJob.Company.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Sts.FirstJob.Company.Company;
import com.Sts.FirstJob.Company.Exception.CompanyException;
import com.Sts.FirstJob.Company.Service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	@Autowired
	private CompanyService companyservice;

	public CompanyController(CompanyService companyservice) {
		this.companyservice = companyservice;
	}
	@PostMapping()
	public ResponseEntity<Company>RegisterCompany(@RequestBody Company company){
		Company office=companyservice.RegisterCompany(company);
		return new ResponseEntity<>(office,HttpStatus.CREATED);
	}
	@PutMapping("/{Id}")
	public String updateCompany(@RequestBody Company office,@PathVariable long Id) throws CompanyException{
		companyservice.update(office,Id);
		return "[Company Updated]";
	}
	@GetMapping("/{Id}")
	public ResponseEntity<Company>getById(@PathVariable long Id) throws CompanyException{
		Company office=companyservice.getById(Id);
		return ResponseEntity.ok(office);
	}
	@GetMapping("/list")
	public ResponseEntity<List<Company>>CompanyList(){
		List<Company> Companies=companyservice.getAllCompany();
		return ResponseEntity.ok(Companies);
	}
}
