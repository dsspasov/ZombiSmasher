package com.game.model.zombi;

import java.util.List;

import com.game.model.ability.Ability;

public class MotherZombi extends Zombi{

	private static final String NAME = "Mother Zombi";
	private static final int HEALTH = 5;
	private static final int SPEED = 2;
	
	public MotherZombi(List<Ability> specialAbility, int count) {
		super(NAME, HEALTH, SPEED, specialAbility, count);
	}
}
