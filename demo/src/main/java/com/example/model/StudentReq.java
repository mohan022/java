package com.example.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentReq {

	@NotNull(message = "sgcyugdsyucg")
	@Min(value = 1, message = "Invalid Age: Equals to zero or Less than zero")
	@Max(value = 100, message = "Invalid Age: Exceeds 100 years")
	private int id;
	@NotNull(message = "sgcyugdsyucg")
	private String name;
	@NotNull(message = "sgcyugdsyucg")
	private String school;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getSchool() {
//		return school;
//	}
//
//	public void setSchool(String school) {
//		this.school = school;
//	}

}
