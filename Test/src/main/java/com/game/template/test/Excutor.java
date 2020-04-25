package com.game.template.test;

import com.game.template.test.handler.login.TestLogin;
import com.game.template.test.robot.Robot;
import org.qiunet.test.executor.RobotExecutor;
import org.qiunet.test.executor.params.ExecutorParams;
import org.qiunet.test.response.annotation.support.ResponseScannerHandler;
import org.qiunet.test.robot.IRobot;
import org.qiunet.test.robot.init.DefaultRobotInfo;
import org.qiunet.test.robot.init.IRobotFactory;
import org.qiunet.test.testcase.ITestCase;
import org.qiunet.utils.classScanner.ClassScanner;
import org.qiunet.utils.classScanner.ScannerType;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/***
 *
 * @author qiunet
 * 2020-04-25 17:19
 **/
public class Excutor {
	public static void main(String[] args) throws Exception {
		ClassScanner.getInstance(ScannerType.TESTER).scanner("com.game.template");
		new RobotExecutor(
			ExecutorParams.custom()
				.setRobotFactory(new RobotFactory())
				.setInitializer(() -> {})
				.addTestCase(TestLogin.class)
				.build()
		).testing();
	}

	/***
	 * 机器人生成规则
	 * 可以通过返回固定机器人测试某个账号
	 */
	private static class RobotFactory implements IRobotFactory {
		private AtomicInteger incr = new AtomicInteger(100);

		@Override
		public IRobot createRobot(List<Class<? extends ITestCase>> testCaseList) {
//			String openId = ServerUidAndTokenBuilder.OPENID_PREFIX+incr.getAndIncrement();

			return new Robot(testCaseList, new DefaultRobotInfo("jian", "t1u228zL"));
//			return new Robot(testCaseList, new DefaultRobotInfo("luw2", "p2U3wzV0"));
		}
	}

}
