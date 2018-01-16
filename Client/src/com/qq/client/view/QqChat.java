/*
 * 好友聊天界面
 */
package com.qq.client.view;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class QqChat extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqChat qqchat = new QqChat("1");

	}
	
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	
	
	public QqChat(String friend)
	{
		jta = new JTextArea();
		jtf = new JTextField(15);
		jb = new JButton("发送");
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta,"Center");
		this.add(jp,"South");
		this.setTitle("你正在和"+friend+" ");
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setSize(300,200);
		this.setVisible(true);
		
	}

}
