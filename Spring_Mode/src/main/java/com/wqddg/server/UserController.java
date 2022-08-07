package com.wqddg.server;

/**
 * @Author: wqddg
 * @ClassName UserController
 * @DateTime: 2022/8/7 15:44
 * @remarks : #
 */
public class UserController {

	@Autowired(value = "userServer")
	private UserServer userServer;


	public UserServer getUserServer() {
		return userServer;
	}

	public void setUserServer(UserServer userServer) {
		this.userServer = userServer;
	}
}
