package com.game.model.ability;

public abstract class Ability {

	private static int ID = 0;
	protected int id;
	protected String name;
	protected String desc;
	
	public Ability(int id, String name, String desc) {
		this.id = ++ID;
		this.name = name;
		this.desc = desc;
	}
}
