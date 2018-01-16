package com.game.model.zombi;

import java.util.List;

import com.game.model.ability.Ability;

public class DogZombi extends Zombi {
	
	private static final String NAME = "Dog Zombi";
	private static final int HEALTH = 1;
	private static final int SPEED = 3;
	
	public DogZombi(List<Ability> specialAbility, int count) {
		super(NAME, HEALTH, SPEED, specialAbility, count);
	}
}
