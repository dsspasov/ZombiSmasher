package com.game.model.user;

public class UserHighScoreStat {

	private int position;
	private String name;
	private int highScore;
	
	public UserHighScoreStat(int position, String name, int highScore) {
		super();
		this.position = position;
		this.name = name;
		this.highScore = highScore;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
}
