package View;

import Model.Student;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputExcel {
    //����HSSFWorkbook����
    /**
     *
     */

//    static Map<Student, String> student;
     List<Student> ls = Student.student;
    
//    public static void main(String args[]) throws IOException {
//        OutputExcel.writeExcel();
//    }
    
    

    public  void writeExcel(){
        //����һ��Excel(or new XSSFWorkbook())
        Workbook wb = new HSSFWorkbook();
        //�������
        Sheet sheet = wb.createSheet("s");

        //������
        Row row = sheet.createRow(0);
        //�����и�
        row.setHeightInPoints(30);
        //������Ԫ��
        Cell cell = row.createCell(0);
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 20);
        //���õ�Ԫ���ֵ
        cell.setCellValue("ѧ������");
        cell = row.createCell(1);
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 20);
        cell.setCellValue("ѧ��ѧ��");
        cell = row.createCell(2);
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 20);
        cell.setCellValue("ѧ���Ա�");
        cell = row.createCell(3);
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 20);
        cell.setCellValue("�����");
        cell = row.createCell(4);
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 20);
        cell.setCellValue("�������˵��");

        int creatrow = 1;

        for (Student stu : ls) {

            row = sheet.createRow(creatrow);
            cell = row.createCell(0);
            cell.setCellValue(stu.getName());
            cell = row.createCell(1);
            cell.setCellValue(stu.getId());
            cell = row.createCell(2);
            String sex;
            if(stu.getSex()==false) {
           	 sex="��";
           }else {
           	 sex="Ů";
           }
            cell.setCellValue(sex);
            cell = row.createCell(3);
            cell.setCellValue(stu.getNum());
            cell = row.createCell(4);
            cell.setCellValue("");
            creatrow++;
        }
        System.out.println("===");
        
      FileOutputStream fos;
	try {
		fos = new FileOutputStream("D:/ѧ���������ϵͳ.xls");
		wb.write(fos);
		
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();	
	}
		catch(IOException e) {
		
	}
//        wb.write(fos);
//        if (null != fos) {
//            fos.close();
//        }
//        try {
//			//����������쳣û��д��ɹ���ô,��ֱ����catch,��ô���close()д��try���򲻻ᱻ�ر�,ʹ��finally�����Ƿ����쳣���ᱻ�ر�
//             wb.write(fos);
//		} catch (IOException e) {
//			throw new RuntimeException("�ı�д��ʧ��! �쳣��Ϣ:\n"+e.getMessage());
//		}finally{
//			try {
//				if(fos != null)//������󴴽�ʧ������Ҫ�ر�
//					fos.close();
//			} catch (IOException e) {
//				throw new RuntimeException("��Դ�ͷ�ʧ��! �쳣��Ϣ:\n"+e.getMessage());
//			}
//		}
	}

   }




