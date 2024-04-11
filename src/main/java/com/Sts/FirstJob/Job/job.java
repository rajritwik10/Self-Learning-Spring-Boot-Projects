package com.Sts.FirstJob.Job;

import java.util.List;

import com.Sts.FirstJob.Company.Company;

import jakarta.persistence.*;

import lombok.*;
@Entity
@Table (name="Job_Tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class job {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String title;
	private String description;
	private String minSalary;
	private String maxSalary;
	private String location;
	
	
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
}
