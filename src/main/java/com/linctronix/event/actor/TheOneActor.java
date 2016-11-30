package com.linctronix.event.actor;

import com.linctronix.event.Message;

import akka.actor.UntypedActor;

public class TheOneActor extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Throwable {
		if (message instanceof Message
				&& filter((Message)message)
				&& ((Message)message).getPercentage() > 80)
			System.out.println(message);
		else
			unhandled(message);
	}
	
	private boolean filter(Message message) {
		return message.getTarget() == "rtls"
				&& message.getCategory() == "cpu";
	}
}
