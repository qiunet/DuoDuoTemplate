package com.game.server.test.robot;

import org.qiunet.test.robot.AbstractRobot;
import org.qiunet.test.robot.init.DefaultRobotInfo;
import org.qiunet.test.testcase.ITestCase;

import java.util.List;

public class Robot extends AbstractRobot<DefaultRobotInfo> {
	public boolean needRegister;

	public Robot(List<Class<? extends ITestCase>> testCases, DefaultRobotInfo info) {
		super(testCases, info);
	}
}
