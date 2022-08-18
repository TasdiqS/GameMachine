package com.project.springboot.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ModelClass {

	@Id
	private long id;

	private long startTime;

	private boolean  status;

	private double gameTime;

	public double getGameTime() {
		return gameTime;
	}

	public void setGameTime(double gameTime) {
		this.gameTime = gameTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime() {
		Date date = new Date();
		startTime = date.getTime();
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ModelClass(long id, long startTime, boolean status, double gameTime) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.status = status;
		this.gameTime = gameTime;
	}

	public ModelClass() {
		super();
		// TODO Auto-generated constructor stub
	}

}
