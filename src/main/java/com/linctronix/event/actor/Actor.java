package com.linctronix.event.actor;

import com.linctronix.event.entity.Binding;
import com.linctronix.event.entity.Entity;

public abstract class Actor {

	public static Actor getActor(Entity entity, Entity parent, Binding binding) {
		String entityName = entity.getClass().getName();
		if (entityName == "Entity")
			return new EntityActor(entity, parent, binding);
		else if (entityName == "Sequence" || entityName == "Alternative")
			return entity.getNextEntity(parent, binding);
		return null;
	}

	abstract public Boolean run();
}
