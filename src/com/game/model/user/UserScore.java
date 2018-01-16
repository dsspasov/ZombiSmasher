package com.game.model.user;

public class UserScore {

	private int id;
	private int level;
	private int points;
	
	public UserScore(int id, int level, int points) {
		super();
		this.id = id;
		this.level = level;
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
