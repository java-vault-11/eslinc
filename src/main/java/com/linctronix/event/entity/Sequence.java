package com.linctronix.event.entity;

import java.util.List;

import com.linctronix.event.actor.Actor;

public class Sequence extends Entity {
	
	private List<Entity> elms;

	public List<Entity> getElms() {
		return elms;
	}

	public void setElms(List<Entity> elms) {
		this.elms = elms;
	}

	@Override
	public void config(String wind_of_config, String wind_du_config) {
		for (Entity e: getElms()) {
			e.config(wind_of_config, wind_du_config);
		}
	}

	@Override
	public Actor getNextEntity(Entity parent, Binding binding) {
		return null;
	}
}
