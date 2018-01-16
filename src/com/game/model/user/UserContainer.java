package com.game.model.user;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class UserContainer {

	private static UserContainer instance;
	private static Object monitor = new Object();
	
	private ConcurrentHashMap<String, User> users;
	private ConcurrentHashMap<Integer, Score> scores;
	private ConcurrentHashMap<Integer, String> idToUser;
	
	private UserContainer(){
		users = new ConcurrentHashMap<String, User>();
		scores = new ConcurrentHashMap<Integer, Score>();
		idToUser = new ConcurrentHashMap<Integer, String>();
	}
	
	public static UserContainer getInstance(){
		if(instance == null) {
			synchronized (monitor) {
				if(instance == null) {
					instance = new UserContainer();
				}
			}
		}
		return instance;
	}
	
	public ConcurrentHashMap<String, User> getUsers(){
		return this.users;
	}
	
	public boolean contains(String username) {
		return users.containsKey(username);
	}
	
	public User getUserByName(String username) {
		return users.get(username);
	}
	
	public void addUser(User user){
		users.put(user.getUsername(), user);
		scores.put(user.getId(), new Score());
		idToUser.put(user.getId(), user.getUsername());
	}

	public void addScore(UserScore score) {
		scores.get(score.getId()).addScore(score);
	}
	
	public List<UserHighScoreStat> getTopUsers(int limit) {
		Collection<Score> userScores = scores.values();

		//sort descending
		List<Score> sortedScores = userScores
				.stream()
				.sorted((s1, s2) -> - s1.getTotal() + s2.getTotal())
				.limit(limit)
				.collect(Collectors.toList());
		
		List<UserHighScoreStat> userStat = new LinkedList<>();
		int position = 1;
		for(Score score : sortedScores){
			UserHighScoreStat u = new UserHighScoreStat(position, idToUser.get(score.getUserId()), score.getTotal());
			userStat.add(u);
			position++;
		}
		
		return userStat;
	}
}
