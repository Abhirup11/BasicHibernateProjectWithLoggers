package com.hibernate.demo.Application.entity.embedable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Certificate {

	private int cid;
	private String courseName;

}
