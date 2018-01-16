/*
 * 客户端连接服务器的后台
 */
package com.qq.client.model;

import java.util.*;
import java.net.*;
import java.io.*;
import com.qq.common.*;

public class QqClientConServer {
	
//	public QqClientConServer()
//	{
//		try {
//			Socket s = new Socket("127.0.0.1",9999);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		finally
//		{
//			
//		}
//	}
	
	
	//发送第一次请求
	public boolean sendLoginInfoToServer(Object o)
	{
		boolean b = false;
		try {
			Socket s = new Socket("127.0.0.1",9999);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			
			Message ms = (Message)ois.readObject();
			if(ms.getMesType().equals("1"))
			{
				b = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			
		}
		return b;
	}
	
	public void sendInfoToServer(Object o)	
	{
		try {
			Socket s = new Socket("127.0.0.1",9999);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			
		}

		
	}

}
