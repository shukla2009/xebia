package com.assign.xebia;

public class Response {

	protected final float battery;
	protected final String message;
	protected final Status status;

	public float getBattery() {
		return battery;
	}

	public String getMessage() {
		return message;
	}

	public Status getStatus() {
		return status;
	}

	public Response(float battery, String message, Status status) {
		this.battery = battery;
		this.message = message;
		this.status = status;
	}

	@Override
	public String toString() {
		String string = status.toString() + " with battery remaning " + battery + "%";
		if (message != null && !message.isEmpty()) {
			string = string + " with message " + message;
		}
		return string;
	}

}
