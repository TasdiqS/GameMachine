package com.project.springboot.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.model.ModelClass;
import com.project.springboot.repository.RepositoryInter;

@Service
public class ServiceImpl implements ServiceInterface{

	@Autowired
	RepositoryInter repo;
	
	@Autowired
	ModelClass model;
	
	public void play() {
		
	}
	
	@Override
	public String play(long id, long gameTime) {
		model.setId(id);
		model.setStartTime();
		model.setStatus(true);
		model.setGameTime(gameTime);
		
		repo.save(model);
		return "saved";
	}
	
	@Override
	public String checkStatus() {

		Date date = new Date();
		
		Optional<ModelClass> entry = repo.findById((long) 1);
	 	
	 	double fl = entry.get().getGameTime();
	 	
	 	fl = fl * 60*60*1000;
	 	
	 	long ll = (long) fl;
//	 	System.out.println(ll);
		
		long diff = date.getTime() - entry.get().getStartTime();
		long timeLeft = ll-diff;
		if(timeLeft>=0) {
	 	String ttt =  String.format("%02d:%02d:%02d", 
			    TimeUnit.MILLISECONDS.toHours(timeLeft),
			    TimeUnit.MILLISECONDS.toMinutes(timeLeft) - 
			    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeLeft)),
			    TimeUnit.MILLISECONDS.toSeconds(timeLeft) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeLeft)));
	 	System.out.println(ttt);
	 	System.out.println((double)2.5);
	 	
		return ttt;
		}
		else {
			entry.get().setStatus(false);
			return "Time over . . . Enter more coins";
		}
	}
}
