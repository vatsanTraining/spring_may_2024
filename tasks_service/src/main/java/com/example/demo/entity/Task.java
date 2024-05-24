package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sbd_tasks")
public class Task {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "task")
	private String task;
	
	@Column(name = "assigned_to")
	private String assingedTo;
	
	@Column(name = "completion_date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate completionDate;
	
	public Task() {
		super();
	}

	public Task(int id, String task, String assingedTo, LocalDate completionDate) {
		super();
		this.id = id;
		this.task = task;
		this.assingedTo = assingedTo;
		this.completionDate = completionDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getAssingedTo() {
		return assingedTo;
	}

	public void setAssingedTo(String assingedTo) {
		this.assingedTo = assingedTo;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", task=" + task + ", assingedTo=" + assingedTo + ", completionDate=" + completionDate
				+ "]";
	}
	
	
	
	
}
