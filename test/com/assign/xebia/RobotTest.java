package com.assign.xebia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RobotTest {
	private Robot robot;

	@Before
	public void setup() {
		robot = new Robot();
	}

	@Test
	public void testWalkFloatFloat() {

		robot.charge();
		Response res = robot.walk(2, 3);
		assertEquals(res.battery, 57.6f, 0f);
		assertEquals(res.status, Status.OK);

		robot.charge();
		res = robot.walk(0, 12);
		assertEquals(res.status, Status.OVERWEIGHT);

		robot.charge();
		res = robot.walk(5, 5);
		assertEquals(res.status, Status.OVERCAPACITY);
	}

	@Test
	public void testWalkFloat() {
		robot.charge();
		Response res = robot.walk(3.5f);
		assertEquals(res.battery, 30, 0f);
		assertEquals(res.status, Status.OK);
	}

	@Test
	public void testScan() {

		Response res = robot.scan(true);
		assertEquals(res.status, Status.SCANFAILURE);

		res = robot.scan(false);
		assertEquals(res.status, Status.OK);
	}

}
