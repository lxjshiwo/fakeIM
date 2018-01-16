/*
 * qq服务器监听等待某个客户端连接
 */
package com.qq.server.model;

import java.net.*;
import java.io.*;
import java.util.*;

import com.qq.common.Message;
import com.qq.common.User;


public class MyQqServer {

	public MyQqServer()
	{
		try 
		{
			System.out.println("on call");
			//在9999端口上等待
			ServerSocket ss =new ServerSocket(9999);
			
			//阻塞
			while(true)
			{
				Socket s = ss.accept();
			
			//等待客户端发来信息
			
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User u =(User)ois.readObject();
			
				Message m = new Message();
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				if(u.getPasswd().equals("123456"))
				{
					//返回一个成功登陆的信息包
					m.setMesType("1");
					oos.writeObject(m);
				}
				else
				{
					m.setMesType("2");
					oos.writeObject(m);
					//关闭连接
					s.close();
				}
			

				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{}
	}

}
