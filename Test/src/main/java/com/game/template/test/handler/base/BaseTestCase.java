package com.game.template.test.handler.base;

import com.game.template.test.robot.Robot;
import com.game.template.test.server.ServerType;
import com.google.protobuf.GeneratedMessageV3;
import org.qiunet.test.server.IServer;
import org.qiunet.test.testcase.LongConn.LongConnProtobufTestCase;

/***
 *
 * @author qiunet
 * 2020-04-25 18:52
 **/
public abstract class BaseTestCase<Request extends GeneratedMessageV3> extends LongConnProtobufTestCase<Request, Robot> {
	@Override
	protected IServer getServer() {
		return ServerType.WS_ONLINE;
	}


}
