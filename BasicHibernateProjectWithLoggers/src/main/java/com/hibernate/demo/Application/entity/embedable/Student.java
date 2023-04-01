package com.hibernate.demo.Application.entity.embedable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@Column(name = "ROLL_No")
	private int rollno;
	
	@Column(name = "NAME")
	private String name;
	
	private Certificate certi;
	

}
