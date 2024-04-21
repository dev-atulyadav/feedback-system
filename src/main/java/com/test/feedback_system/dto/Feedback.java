package com.test.feedback_system.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String feedback;

	@OneToOne
	private Teacher teacher;
	@OneToOne
	private Student student;

	public Feedback(String feedback, Teacher teacher, Student student) {
		super();
		this.feedback = feedback;
		this.teacher = teacher;
		this.student = student;
	}

}
