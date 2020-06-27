package mk1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class zhuce extends JFrame {
	public zhuce() {
		setSize(600,500);
		setResizable(false);
		JLabel a=new JLabel("用户名"); 
		JLabel b=new JLabel("密    码");
		JLabel D1=new JLabel("再次确认密码");
		JTextField c=new JTextField(15);
		JPasswordField d=new JPasswordField(15);
//		JPasswordField D=new JPasswordField(15);
		d.setEchoChar('.');
//		D.setEchoChar('.');
		JButton e=new JButton("确定");
		JButton f=new JButton("重置");
		JButton g=new JButton("返回");
		setVisible(true);
		Container mk=getContentPane();
		mk.add(a);
		mk.add(b);
		mk.add(c);
		mk.add(d);
		mk.add(e);
		mk.add(f);
		mk.add(g);
//		mk.add(D);
		setBounds(300,250,300,250);
		mk.setLayout(null);
		a.setBounds(10,40,50,18);
		b.setBounds(10,80,50,18);
		c.setBounds(60,40,200,18);
		d.setBounds(60,80,200,18);
		e.setBounds(110,120,60,30);
		f.setBounds(30,120,60,30);
		g.setBounds(190,120,60,30);
		g.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new denglu();
				
			}
			
		});
	}

}