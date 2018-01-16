package com.game.model.zombi;

import java.util.List;

import com.game.model.ability.Ability;

public class MasterZombi extends Zombi {

	private static final String NAME = "Master Zombi";
	private static final int HEALTH = 10;
	private static final int SPEED = 2;
	
	public MasterZombi(List<Ability> specialAbility, int count) {
		super(NAME, HEALTH, SPEED, specialAbility, count);
	}

}
