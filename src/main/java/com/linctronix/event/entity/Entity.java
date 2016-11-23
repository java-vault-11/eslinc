package com.linctronix.event.entity;

import com.linctronix.event.actor.Actor;

public class Entity {

	private int window_offset;
	private int window_duration;
	private String name_to_bind;
	private String name_to_match;
	
	public void config(String wind_of_config, String wind_du_config) {
		// translate wind_of_config, wind_du_config to window_offset and window_duration
		setWindowOffset(3 * 60 * 1000000);
		setWindowDuration(2 * 60 * 1000000);
	}

	public int getWindowOffset() {
		return window_offset;
	}

	public void setWindowOffset(int window_offset) {
		this.window_offset = window_offset;
	}

	public int getWindowDuration() {
		return window_duration;
	}

	public void setWindowDuration(int window_duration) {
		this.window_duration = window_duration;
	}
	
	public String getNameToBind() {
		return name_to_bind;
	}

	public void setNameToBind(String name_to_bind) {
		this.name_to_bind = name_to_bind;
	}

	public String getNameToMatch() {
		return name_to_match;
	}

	public void setNameToMatch(String name_to_match) {
		this.name_to_match = name_to_match;
	}

	public void upAsActor(Entity parent, Binding binding) {
		Actor actor = Actor.getActor(this, parent, binding);
		parent.getNotified(actor.run());
	}

	private void getNotified(Boolean run) {
		// TODO Auto-generated method stub
		
	}

	public Actor getNextEntity(Entity parent, Binding binding) {
		return null;
	}
}
