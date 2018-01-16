package com.qq.client.model;

import com.qq.common.*;


public class QqClientUser {
	
	//验证用户是否合法
	public boolean checkUser(User u)
	{
		return new QqClientConServer().sendLoginInfoToServer(u);
	} 
}
