package mk1;
import java.awt.*;//����awt��
import javax.swing.*;//����swing��
import java.awt.event.ActionListener;//����awt���еļ������¼���
import java.awt.event.ActionEvent;//����awt���е�ActionEvent�¼���

import NetWork.Client;
import NetWork.Test;
import View.MainMenu;


public class denglu extends JFrame {
	 
	    
	public denglu() {
		setSize(600,500);//��ƴ���Ĵ�С
		JFrame fr = new JFrame("��ӭʹ��");
		JLabel a=new JLabel("�û���"); //ʵ����JLabel����
		JLabel b=new JLabel("��    ��");
		JTextField c=new JTextField(15);//ʵ�����û����ı���
		JPasswordField d=new JPasswordField(15);//ʵ���������
		d.setEchoChar('*');//������������е�������*��ʾ����
		JButton e=new JButton("ȷ��");
		JButton f=new JButton("����");
		JButton g=new JButton("ע��");
		setVisible(true);//ʹ������ӻ�
		Container mk=getContentPane();//��ȡһ������
//		���û����������Jlabel���û���JTextField�ı�������JPasswordField������Լ�ȷ��JButton������JButton��ע��JButton��ӵ�container��������                         //

		mk.add(a);
		mk.add(b);
		mk.add(c);
		mk.add(d);
		mk.add(e);
		mk.add(f);
		mk.add(g);
		setBounds(300,300,300,290);//���ô���ĳ����Ϊ300��300  ������ʾ�����Ϸ���300��300��
		mk.setLayout(null);
//		a��b��c��d��e��f��g��ʾ��container�����е�λ������
		a.setBounds(10,40,50,18);
		b.setBounds(10,80,50,18);
		c.setBounds(60,40,200,18);
		d.setBounds(60,80,200,18);
		e.setBounds(110,180,60,30);
		f.setBounds(30,180,60,30);
		g.setBounds(190,180,60,30);

		f.addActionListener(new ActionListener() {//�����ð�ť��Ӽ����¼�

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				c.setText("");//���û����ı����������
				d.setText("");//�������ı����������
			}

		});
		e.addActionListener(new ActionListener() {//��ȷ����ť��Ӽ����¼�

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				if(c.getText().trim().equals("admin")&&new String(d.getPassword()).equals("admin")) {//equals���������û����������ƥ��
					JOptionPane.showMessageDialog(null,"��¼�ɹ�");

					//new NewFrame();//���뵽NewFrame���������
					Client.QueryStudent();
			        new MainMenu();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "��¼ʧ��");
				}
			}
				
		});
		g.addActionListener(new ActionListener(){//��ע�ᰴť��Ӽ����¼�
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new zhuce();//���붼��zhuce������
			}
			
		});
		
	}
		public static void main(String[] args) {
			new denglu();
			
		}
		
	}



