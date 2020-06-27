package mk1;
import java.awt.*;//导入awt包
import javax.swing.*;//导入swing包
import java.awt.event.ActionListener;//导入awt包中的监听器事件包
import java.awt.event.ActionEvent;//导入awt包中的ActionEvent事件包

import NetWork.Client;
import NetWork.Test;
import View.MainMenu;


public class denglu extends JFrame {
	 
	    
	public denglu() {
		setSize(600,500);//设计窗体的大小
		JFrame fr = new JFrame("欢迎使用");
		JLabel a=new JLabel("用户名"); //实例化JLabel对象
		JLabel b=new JLabel("密    码");
		JTextField c=new JTextField(15);//实例化用户名文本框
		JPasswordField d=new JPasswordField(15);//实例化密码框
		d.setEchoChar('*');//将输入密码框中的密码以*显示出来
		JButton e=new JButton("确定");
		JButton f=new JButton("重置");
		JButton g=new JButton("注册");
		setVisible(true);//使窗体可视化
		Container mk=getContentPane();//获取一个容器
//		将用户名、密码的Jlabel和用户名JTextField文本框、密码JPasswordField密码框以及确定JButton、重置JButton、注册JButton添加到container容器里面                         //

		mk.add(a);
		mk.add(b);
		mk.add(c);
		mk.add(d);
		mk.add(e);
		mk.add(f);
		mk.add(g);
		setBounds(300,300,300,290);//设置窗体的长宽各为300、300  让其显示在左上方的300、300处
		mk.setLayout(null);
//		a、b、c、d、e、f、g显示在container容器中的位置坐标
		a.setBounds(10,40,50,18);
		b.setBounds(10,80,50,18);
		c.setBounds(60,40,200,18);
		d.setBounds(60,80,200,18);
		e.setBounds(110,180,60,30);
		f.setBounds(30,180,60,30);
		g.setBounds(190,180,60,30);

		f.addActionListener(new ActionListener() {//对重置按钮添加监听事件

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				c.setText("");//对用户名文本框进行重置
				d.setText("");//对密码文本框进行重置
			}

		});
		e.addActionListener(new ActionListener() {//对确定按钮添加监听事件

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				if(c.getText().trim().equals("admin")&&new String(d.getPassword()).equals("admin")) {//equals函数进行用户名和密码的匹配
					JOptionPane.showMessageDialog(null,"登录成功");

					//new NewFrame();//进入到NewFrame这个窗体中
					Client.QueryStudent();
			        new MainMenu();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "登录失败");
				}
			}
				
		});
		g.addActionListener(new ActionListener(){//对注册按钮添加监听事件
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new zhuce();//进入都到zhuce窗体中
			}
			
		});
		
	}
		public static void main(String[] args) {
			new denglu();
			
		}
		
	}



