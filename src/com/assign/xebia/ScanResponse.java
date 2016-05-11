package com.assign.xebia;

public class ScanResponse extends Response {

	private float price;

	public ScanResponse(float battery, String message, Status status, float price) {
		super(battery, message, status);
		this.price = price;
	}

	public ScanResponse(float battery, String message, Status status) {
		this(battery, message, status, 0);
	}

	@Override
	public String toString() {
		switch (status) {
		case SCANFAILURE:
			return status.toString();
		case OK:
			return "Price for tag is  : " + price;
		default:
			return "";
		}
	}
}
