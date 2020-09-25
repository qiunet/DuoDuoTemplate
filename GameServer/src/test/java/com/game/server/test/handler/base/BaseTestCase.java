package com.game.server.test.handler.base;

import com.game.server.test.robot.Robot;
import com.game.server.test.server.ServerType;
import org.qiunet.flash.handler.context.request.data.pb.IpbRequestData;
import org.qiunet.test.testcase.LongConn.LongConnProtobufTestCase;

/***
 *
 * @author qiunet
 * 2020-04-25 18:52
 **/
public abstract class BaseTestCase<Request extends IpbRequestData> extends LongConnProtobufTestCase<Request, Robot> {
	@Override
	protected ServerType getServer() {
		return ServerType.WS_ONLINE;
	}


}
