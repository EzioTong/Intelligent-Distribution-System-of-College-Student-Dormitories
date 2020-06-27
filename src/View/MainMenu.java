package View;

	import javax.swing.*;

import Model.Student;
//import dormAllo.JScrollPane;
//import dormAllo.JTable;
//import dormAllo.Object;
import mk1.NewFrame;

	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.WindowAdapter;
	import java.awt.event.WindowEvent;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
	import java.util.Map;

	/*
	 * 登陆成功后主界面
	 */
	public class MainMenu extends JFrame implements ActionListener {
	    private JFrame mainmenu,outTable;

	    private JMenu menuFile1, menuFile2, menuFile3;
	    private JMenuBar menuBar1;
	    private JMenuItem addStudentInfo, queryStudentInfo, modifyPassword, Exit,setNum;
	    private JMenuItem importExcel, outputExcel;
	    private JMenuItem aboutSystem, help;

	    private JTable table;
	    private JButton next;

	    public MainMenu() {
	        mainmenu();
	    }

	    public void mainmenu() {
	    	
	    	Map<String,Double>report0=new HashMap<String,Double>();
	    	Map<String,Double>report1=new HashMap<String,Double>();
	    	for(int i=0;i<Student.student.size();i++) {
	    		if(Student.student.get(i).getSex()==true) {
	    		report0.put(Student.student.get(i).getId(), Student.student.get(i).getScore());
	    		}else {
	    			report1.put(Student.student.get(i).getId(), Student.student.get(i).getScore());
	    		}
	    	}
	    	

	        mainmenu = new JFrame("admin," + "欢迎使用宿舍管理分配系统");
	        mainmenu.setSize(1265, 856);
	        mainmenu.setLayout(new BorderLayout());//布局
	        menuBar1 = new JMenuBar();//菜单栏
	        Font font = new Font("楷体", Font.BOLD, 16);
	        
	        //====================>基本操作
	        menuFile1 = new JMenu("基本操作(B)");
	        menuFile1.setFont(font);
	        //menuFile1.setIcon(new ImageIcon("src/com/company/images/icons/base1.png"));//改
	        menuFile1.setMnemonic('B');//设置热键（这个要打开菜单才有用）
	        //menuFile.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.ALT_MASK));

	        add(menuFile1);

	        addStudentInfo=new JMenuItem("加权(A)",KeyEvent.VK_A);
	        addStudentInfo.setMnemonic('A');
	        addStudentInfo.setAccelerator(KeyStroke.getKeyStroke('A', Event.CTRL_MASK));//设置快捷键 ctrl+h（直接）
	        menuFile1.add(addStudentInfo);

			setNum = new JMenuItem("设置多人间(S)",KeyEvent.VK_S);
			setNum.setMnemonic('S');
			setNum.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));
			menuFile1.add(setNum);

	        queryStudentInfo = new JMenuItem("查询(Q)",KeyEvent.VK_Q);
	        queryStudentInfo.setMnemonic('Q');
	        queryStudentInfo.setAccelerator(KeyStroke.getKeyStroke('Q', Event.CTRL_MASK));
	        menuFile1.add(queryStudentInfo);

	        modifyPassword = new JMenuItem("密码修改(P)",KeyEvent.VK_P);
	        modifyPassword.setMnemonic('P');
	        modifyPassword.setAccelerator(KeyStroke.getKeyStroke('M', Event.CTRL_MASK));
	        menuFile1.add(modifyPassword);

	        Exit = new JMenuItem("退出(E)",KeyEvent.VK_E);
	        Exit.setMnemonic('E');
	        Exit.setAccelerator(KeyStroke.getKeyStroke('E', Event.CTRL_MASK));
	        menuFile1.add(Exit);





	        menuBar1.add(menuFile1);

	        
	        //====================>导入导出
	        menuFile2 = new JMenu("导入导出(F)");
	        menuFile2.setFont(font);
	        menuFile2.setMnemonic('F');
	        //menuFile.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.ALT_MASK));
	        importExcel = new JMenuItem("导入到excel(I)",KeyEvent.VK_I);
	        importExcel.setMnemonic('I');
	        importExcel.setAccelerator(KeyStroke.getKeyStroke('I', Event.CTRL_MASK));
	        menuFile2.add(importExcel);


	        outputExcel = new JMenuItem("导出到excel(O)",KeyEvent.VK_O);
	        outputExcel.setMnemonic('O');
	        outputExcel.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
	        menuFile2.add(outputExcel);

	        menuBar1.add(menuFile2);

	        //====================>关于
	        menuFile3 = new JMenu("关于(a)");
	        menuFile3.setFont(font);
	        //menuFile3.setIcon(new ImageIcon("src/com/company/images/icons/base3.png"));
	        menuFile3.setMnemonic('a');
	        //menuFile.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.ALT_MASK));
	        aboutSystem = new JMenuItem("关于系统(T)",KeyEvent.VK_T);
	        aboutSystem.setMnemonic('T');
	        aboutSystem.setAccelerator(KeyStroke.getKeyStroke('T', Event.CTRL_MASK));
	        menuFile3.add(aboutSystem);

	        help = new JMenuItem("帮助(H)",KeyEvent.VK_H );
	        help.setMnemonic('H');
	        help.setAccelerator(KeyStroke.getKeyStroke('H', Event.CTRL_MASK));
	        menuFile3.add(help);
	       
	        menuBar1.add(menuFile3);
	        String[] list = {"姓名","学号","性别","出生日期","学习评价","性格评价","作息评价","家庭评价"};
	        Object arr[][] = Initlable();

	        table = new JTable(arr, list);
	        table.setEnabled(false);
	        table.setFont(font);

	        mainmenu.add(new JScrollPane(table), BorderLayout.CENTER);
	        
	        
	        //==================>响应
	      
	        addStudentInfo.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	                    System.out.println("=======>用户选择了‘加权’菜单项,开始给所有人员信息加权处理");
//	                    AddWeight addWeight = new AddWeight();
//	                    AddStudentInfo addStudentInfo=new AddStudentInfo();
//	                    List<Map.Entry<String, Double>> report = addWeight.getReport();//
//	                    TxtUtil.writeFile(report);
	        	}
	        });///？


	        queryStudentInfo.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        System.out.println("=======>用户选择了‘查询’菜单项");
	            mainmenu.dispose();//销毁图形界面，对数据不产生影响
	            new MainMenu();
	        	}
	        });

	        modifyPassword.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	            System.out.println("=======>用户选择了‘修改密码’菜单项");
	            ModifyPasswordInfo modifyPasswordInfo = new ModifyPasswordInfo();
	        	}
	        });



	        setNum.addActionListener(e->{
				System.out.println("=======>用户选择了‘设置多人间’菜单项");
				new NewFrame();
			});

	        Exit.addActionListener(e -> {
			System.out.println("=======>用户选择了‘退出’菜单项");
			System.exit(1);
			});

	        importExcel.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	            System.out.println("=======>用户选择了‘导入到excel’菜单项");
                
             
	     }
	        });

	        outputExcel.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	            System.out.println("=======>用户选择了‘导出到excel’菜单项");
	            ImportExcel importExcel0 = new ImportExcel();
	            ImportExcel importExcel1=new ImportExcel();
	            importExcel0.Input(report0);
	            importExcel1.Input(report1);
	           
	            for(int i=0;i<Student.student.size();i++) {
	            	if(importExcel0.getMap().containsKey(Student.student.get(i).getId())){
	            	
	            		Student.student.get(i).setNum("W"+importExcel0.getMap().get(Student.student.get(i).getId()));
	            		//System.out.println(Student.student.get(i).getId()+Student.student.get(i).getNum());
	            		}
	            	if(importExcel1.getMap().containsKey(Student.student.get(i).getId())){
		            	
	            		Student.student.get(i).setNum("M"+importExcel1.getMap().get(Student.student.get(i).getId()));
	            		//System.out.println(Student.student.get(i).getId()+" "+Student.student.get(i).getNum());
	            		}
	            	
	            	
	            } //student.num的输入
                OutputExcel outputExcel = new OutputExcel();
                outputExcel.writeExcel();
                //=================>表格
                outTable=new JFrame("宿舍分配结果");
                outTable.setLayout(new BorderLayout());
                table=new JTable();
    		    String[] list = {"学生姓名","学生学号","学生性别","宿舍号","其他情况说明"};
                String[][] arr=Initlable2();
     	        table = new JTable(arr,list);//创建表格
    		    table.setEnabled(false);//不可点击
    		    table.setFont(font);
                outTable.add(new JScrollPane(table), BorderLayout.CENTER);//表格置于界面中间
                outTable.pack();
                outTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                outTable.setVisible(true);
	        	}
	        });

	        aboutSystem.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	            System.out.println("=======>用户选择了‘关于系统’菜单项");
               AboutSystem aboutSystem = new AboutSystem();
	        	}
	        });
	        help.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	            System.out.println("=======>用户选择了‘帮助’菜单项");
	            Helps help = new Helps();
	        	}
	        });


	        mainmenu.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	                System.exit(1);
	            }
	        });//界面关闭

	        //=============>
	        mainmenu.setJMenuBar(menuBar1);
	        mainmenu.setVisible(true);
	        mainmenu.setLocation(250, 50);
	        addStudentInfo.addActionListener(this);
	        queryStudentInfo.addActionListener(this);
	        modifyPassword.addActionListener(this);
	        Exit.addActionListener(this);
	        importExcel.addActionListener(this);
	        //importTxt.addActionListener(this);
	        outputExcel.addActionListener(this);
	        //outputTxt.addActionListener(this);
	        aboutSystem.addActionListener(this);
	        help.addActionListener(this);

	        
        
	    }



	    private String[][] Initlable() {
	            String[][] arr = null;
	            int j = 0;
	        try {
	            
	           arr = new String[Student.student.size()][8];

	            for(Student stu:Student.student) {
	                String name = stu.getName();
	                String sex;
	                if(stu.getSex()==false) {
	                	 sex="男";
	                }else {
	                	 sex="女";
	                }
	                
	                String id = stu.getId();
	                String num=stu.getNum();
	                arr[j][0] = name;
	                arr[j][1] = id;
	                arr[j][2] = sex;
	                
	                arr[j][3] =stu.getAge();
	                arr[j][4] =String.valueOf(stu.getStudy());
	                arr[j][5] =String.valueOf(stu.getRest());
	                arr[j][6] =String.valueOf(stu.getCharacter());
	                arr[j][7] =String.valueOf(stu.getFamily());
                j++; 
                

	            }
	        } catch (Exception e) {
       }


        return arr;
 }
	    
	    
	    
	    private String[][] Initlable2() {
            String[][] arr = null;
            int j = 0;
        try {
            
           arr = new String[Student.student.size()][5];

            for(Student stu:Student.student) {
                String name = stu.getName();
                String sex;
                if(stu.getSex()==false) {
                	 sex="男";
                }else {
                	 sex="女";
                }
                
                String id = stu.getId();
                String num=stu.getNum();
                arr[j][0] = name;
                arr[j][1] = id;
                arr[j][2] = sex;
                arr[j][3] = num;
                arr[j][4] ="暂无";
            j++; 
            

            }
        } catch (Exception e) {
   }


    return arr;
}
	   
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new MainMenu();
//		 Student s[];
//		 HashMap<String,Double> map1 = new HashMap<>();
//		 HashMap<String,Double> map2 = new HashMap<>();
//		 
//		 s=new Student[100];
//	}
//		
	
	
}


