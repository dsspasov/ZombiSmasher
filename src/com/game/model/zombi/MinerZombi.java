package com.game.model.zombi;

import java.util.List;

import com.game.model.ability.Ability;

public class MinerZombi extends Zombi{

	private static final String NAME = "Miner Zombi";
	private static final int HEALTH = 10;
	private static final int SPEED = 2;
	
	public MinerZombi(List<Ability> specialAbility, int count) {
		super(NAME, HEALTH, SPEED, specialAbility, count);
	}

}
