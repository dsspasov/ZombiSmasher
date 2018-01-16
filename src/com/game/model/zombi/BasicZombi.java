package com.game.model.zombi;

import java.util.List;

import com.game.model.ability.Ability;

public class BasicZombi extends Zombi {

	private static final String NAME = "Basic Zombi";
	private static final int HEALTH = 1;
	private static final int SPEED = 1;
	
	public BasicZombi(List<Ability> specialAbility, int count) {
		super(NAME, HEALTH, SPEED, specialAbility, count);
	}

}
