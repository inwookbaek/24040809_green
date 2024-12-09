package com.lec.board.domain;

import java.time.LocalDate;

import groovy.transform.ToString;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Table(name = "tbl_todo_api")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tno;
	private String title;
	private LocalDate dueDate;
	private String writer;
	private boolean complete;
	
	public void changeComplete(boolean complete) {
		this.complete = complete;
	}
	
	public void changeDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public void changeTitle(String title) {
		this.title = title;
	}
	
}
