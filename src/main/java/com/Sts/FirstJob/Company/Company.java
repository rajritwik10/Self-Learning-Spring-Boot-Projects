package com.Sts.FirstJob.Company;

import java.util.List;

import com.Sts.FirstJob.Job.job;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private String description;
	@JsonIgnore
	@OneToMany
	(mappedBy="company",cascade=CascadeType.ALL)
	private List<job>jobs;
}
