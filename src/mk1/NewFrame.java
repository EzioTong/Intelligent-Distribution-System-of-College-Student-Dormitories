package mk1;

import Basic.Allocate;
import NetWork.Client;
import View.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFrame extends JFrame {

	public NewFrame() {
		setSize(600,500);//设计窗体的大小
		JFrame fr = new JFrame("请输入多人间分配人数");
		JLabel a=new JLabel("人数"); //实例化JLabel对象
		JTextField c=new JTextField(15);//实例化用户名文本框

		JButton e=new JButton("确定");
		JButton f=new JButton("重置");
		JButton g=new JButton("退出");
		setVisible(true);//使窗体可视化
		Container mk=getContentPane();//获取一个容器
//		将用户名、密码的Jlabel和用户名JTextField文本框、密码JPasswordField密码框以及确定JButton、重置JButton、注册JButton添加到container容器里面                         //

		mk.add(a);

		mk.add(c);
		mk.add(e);
		mk.add(f);
		mk.add(g);
		setBounds(300,300,300,290);//设置窗体的长宽各为300、300  让其显示在左上方的300、300处
		mk.setLayout(null);
//		a、b、c、d、e、f、g显示在container容器中的位置坐标
		a.setBounds(10,40,50,18);

		c.setBounds(60,40,200,18);

		e.setBounds(110,180,60,30);
		f.setBounds(30,180,60,30);
		g.setBounds(190,180,60,30);

		f.addActionListener(new ActionListener() {//对重置按钮添加监听事件

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				c.setText("");//对用户名文本框进行重置

			}

		});
		e.addActionListener(new ActionListener() {//对确定按钮添加监听事件

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String s = c.getText().trim();
				try{
					int num = Integer.parseInt(s);
					if (num<=0){
						num = 4;
					}
					Allocate.num = num;
				}catch (Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"输入有误！！");
					dispose();
					return;
				}



				JOptionPane.showMessageDialog(null,"设置成功");
				dispose();

				/*if(c.getText().trim().equals("admin")&&new String(d.getPassword()).equals("admin")) {//equals函数进行用户名和密码的匹配
					JOptionPane.showMessageDialog(null,"登录成功");

					//new NewFrame();//进入到NewFrame这个窗体中
					Client.QueryStudent();
					new MainMenu();
				}else {
					JOptionPane.showMessageDialog(null, "登录失败");
				}*/
			}

		});
		g.addActionListener(new ActionListener(){//对注册按钮添加监听事件
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}

		});

	}
	public static void main(String[] args) {
		new NewFrame();

	}
}
