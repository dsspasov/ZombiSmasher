package com.game.model.user;

import java.util.HashMap;
import java.util.Map;

public class Score{
	private Map<Integer, Integer> scores = new HashMap<Integer, Integer>();
	private int total = 0;
	private int userId;
	
	public void addScore(UserScore score){
		Integer oldResult = this.scores.put(score.getLevel(), score.getPoints());
		this.userId = score.getId();
		if(oldResult != null)
			total -= oldResult;
		total += score.getPoints();
	}
	
	
	public int getTotal() {
		return total;
	}
	
	public int getUserId(){
		return this.userId;
	}
}
