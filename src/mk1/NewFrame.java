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
		setSize(600,500);//��ƴ���Ĵ�С
		JFrame fr = new JFrame("��������˼��������");
		JLabel a=new JLabel("����"); //ʵ����JLabel����
		JTextField c=new JTextField(15);//ʵ�����û����ı���

		JButton e=new JButton("ȷ��");
		JButton f=new JButton("����");
		JButton g=new JButton("�˳�");
		setVisible(true);//ʹ������ӻ�
		Container mk=getContentPane();//��ȡһ������
//		���û����������Jlabel���û���JTextField�ı�������JPasswordField������Լ�ȷ��JButton������JButton��ע��JButton��ӵ�container��������                         //

		mk.add(a);

		mk.add(c);
		mk.add(e);
		mk.add(f);
		mk.add(g);
		setBounds(300,300,300,290);//���ô���ĳ����Ϊ300��300  ������ʾ�����Ϸ���300��300��
		mk.setLayout(null);
//		a��b��c��d��e��f��g��ʾ��container�����е�λ������
		a.setBounds(10,40,50,18);

		c.setBounds(60,40,200,18);

		e.setBounds(110,180,60,30);
		f.setBounds(30,180,60,30);
		g.setBounds(190,180,60,30);

		f.addActionListener(new ActionListener() {//�����ð�ť��Ӽ����¼�

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				c.setText("");//���û����ı����������

			}

		});
		e.addActionListener(new ActionListener() {//��ȷ����ť��Ӽ����¼�

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
					JOptionPane.showMessageDialog(null,"�������󣡣�");
					dispose();
					return;
				}



				JOptionPane.showMessageDialog(null,"���óɹ�");
				dispose();

				/*if(c.getText().trim().equals("admin")&&new String(d.getPassword()).equals("admin")) {//equals���������û����������ƥ��
					JOptionPane.showMessageDialog(null,"��¼�ɹ�");

					//new NewFrame();//���뵽NewFrame���������
					Client.QueryStudent();
					new MainMenu();
				}else {
					JOptionPane.showMessageDialog(null, "��¼ʧ��");
				}*/
			}

		});
		g.addActionListener(new ActionListener(){//��ע�ᰴť��Ӽ����¼�
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
