package com.assign.xebia;

/**
 * 
 * @author Rahul Shukla < shukla2009@gmail.com >
 *
 */
public class Robot {

	private float battery = 100;
	private float walkPerFullCharge;
	private float maxload;

	public Robot() {
		this(5, 10);
	}

	public Robot(float walkPerFullCharge, float maxload) {
		this.walkPerFullCharge = walkPerFullCharge;
		this.maxload = maxload;

	}

	public void charge() {
		battery = 100;
	}

	public Response walk(float distance, float weight) {

		if (distance < 0 || weight < 0) {
			throw new IllegalArgumentException("distance and weight should be greater then 0");
		}
		if (weight > maxload) {
			return new Response(battery, "", Status.OVERWEIGHT);
		}

		float batteryConsPerKm = battery / walkPerFullCharge;
		float batteryReqPerKm = batteryConsPerKm + (2 * weight * batteryConsPerKm) / 100;

		return startWalking(distance, batteryReqPerKm);
	}

	private Response startWalking(float distance, float batteryConsPerKm) {
		float batReq = distance * batteryConsPerKm;
		if (batReq > battery) {
			return new Response(battery, "", Status.OVERCAPACITY);
		} else if (batReq > 85) {
			battery = battery - batReq;
			return new Response(battery, "", Status.LOWBATTERY);
		}
		battery = battery - batReq;
		return new Response(battery, "", Status.OK);
	}

	public Response walk(float distance) {
		return walk(distance, 0);
	}

	public Response scan(boolean blurTag) {
		if (blurTag) {
			return new ScanResponse(battery, "", Status.SCANFAILURE);
		}
		return new ScanResponse(battery, "", Status.OK, 10f);

	}

}
