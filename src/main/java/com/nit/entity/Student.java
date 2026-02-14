package com.nit.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="student_db")
public class Student implements Serializable {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "stud_id_seq", initialValue=100, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 30)
	@NonNull
	private String name;
	@Column(length = 30)
	@NonNull
	private String email;
	@Column(length = 30)
	@NonNull
	private String course;
	@NonNull
	private Double fees;
}
