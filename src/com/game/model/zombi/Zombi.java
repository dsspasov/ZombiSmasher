package com.game.model.zombi;

import java.util.List;

import com.game.model.ability.Ability;

public abstract class Zombi {
	
	protected String name;
	protected int health;
	protected int speed;
	protected List<Ability> specialAbility;
	protected int count;

	public Zombi(String name, int health, int speed, List<Ability> specialAbility, int count) {
		this.name = name;
		this.health = health;
		this.speed = speed;
		this.specialAbility = specialAbility;
		this.count = count;
	}
	
}
