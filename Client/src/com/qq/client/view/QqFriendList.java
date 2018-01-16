/*
 * 我的好友列表(陌生人、黑名单)
 */
package com.qq.client.view;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class QqFriendList extends JFrame implements ActionListener,MouseListener {
	
	//处理第一张卡片 
	JPanel jp_friend1,jp_friend2,jp_friend3;
	JButton jp_friend_jb1,jp_friend_jb2,jp_friend_jb3;
	JScrollPane jsp1;
	
	
	//处理第二张卡片(陌生人)
	JPanel jp_stranger1,jp_stranger2,jp_stranger3;
	JButton jp_stranger_jb1,jp_stranger_jb2,jp_stranger_jb3;
	JScrollPane jsp_stranger;
	
	
	
	//将整个JFrame设定为CardLayout布局
	CardLayout cl;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqFriendList qqfriendlist = new QqFriendList();

	}
	
	
	public QqFriendList()
	{
		//处理第一张卡片,显示好友列表
		jp_friend1 = new JPanel(new BorderLayout());
		//假定有50个好友
		JLabel[] jbls = new JLabel[50];
		jp_friend2 = new JPanel(new GridLayout(50,1,4,4));
		
		for(int i = 0;i<jbls.length-1;i++)
		{
			jbls[i] = new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jbls[i].addMouseListener(this);
			jp_friend2.add(jbls[i]);


		}	

		jp_friend3 = new JPanel(new GridLayout(2,1));
		
		jp_friend_jb1 = new JButton("我的好友");
		jp_friend_jb2 = new JButton("陌生人");
		jp_friend_jb2.addActionListener(this);
		jp_friend_jb3 = new JButton("黑名单");
		//将两个按钮加入到jp_friend3中
		jp_friend3.add(jp_friend_jb2);
		jp_friend3.add(jp_friend_jb3);
		
		
		jsp1 = new JScrollPane(jp_friend2);
		
		//对jp_friend1进行初始化
		jp_friend1.add(jp_friend_jb1,"North");
		jp_friend1.add(jsp1,"Center");
		jp_friend1.add(jp_friend3,"South");
		
		
		
		
		//处理第二张卡片
		jp_stranger1 = new JPanel(new BorderLayout());
		//假定有20个陌生人
		JLabel[] jbl_strangers = new JLabel[20];
		jp_stranger2 = new JPanel(new GridLayout(20,1,4,4));
		
		for(int i = 0;i<jbl_strangers.length;i++)
		{
			jbl_strangers[i] = new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jp_stranger2.add(jbl_strangers[i]);

		}	
		
		
		jp_stranger3 = new JPanel(new GridLayout(2,1));
		
		jp_stranger_jb1 = new JButton("我的好友");
		jp_stranger_jb1.addActionListener(this);
		jp_stranger_jb2 = new JButton("陌生人");
		jp_stranger_jb3 = new JButton("黑名单");
		//将两个按钮加入到jp_friend3中
		jp_stranger3.add(jp_stranger_jb1);
		jp_stranger3.add(jp_stranger_jb2);
		
		
		jsp_stranger = new JScrollPane(jp_stranger2);
		
		//对jp_friend1进行初始化
		jp_stranger1.add(jp_stranger3,"North");
		jp_stranger1.add(jsp_stranger,"Center");
		jp_stranger1.add(jp_stranger_jb3,"South");
	
		cl = new CardLayout();
		this.setLayout(cl);
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.add(jp_friend1,"1");
		this.add(jp_stranger1,"2");
		this.setSize(150,400);
		this.setVisible(true);
		
	}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//如果点击陌生人按键,显示第二张卡片 
		if(arg0.getSource() == jp_friend_jb2)
		{
			
			cl.show(this.getContentPane(),"2");
		}
		else if(arg0.getSource() == jp_stranger_jb1)
		{
			cl.show(this.getContentPane(),"1");
		}
		
	}


	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//相应用户击，获得好友编号
		if(arg0.getClickCount() == 2)
		{
			//得到该好友编号
			String friendNo = ((JLabel)arg0.getSource()).getText();
			new QqChat(friendNo);
		}
		
	}


	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl =(JLabel)(arg0.getSource());
		jl.setForeground(Color.red);
		
	}


	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl =(JLabel)(arg0.getSource());
		jl.setForeground(Color.black);
		
	}


	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
