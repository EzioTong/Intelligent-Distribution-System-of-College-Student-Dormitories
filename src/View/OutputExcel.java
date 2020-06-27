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
    //创建HSSFWorkbook对象
    /**
     *
     */

//    static Map<Student, String> student;
     List<Student> ls = Student.student;
    
//    public static void main(String args[]) throws IOException {
//        OutputExcel.writeExcel();
//    }
    
    

    public  void writeExcel(){
        //创建一个Excel(or new XSSFWorkbook())
        Workbook wb = new HSSFWorkbook();
        //创建表格
        Sheet sheet = wb.createSheet("s");

        //创建行
        Row row = sheet.createRow(0);
        //设置行高
        row.setHeightInPoints(30);
        //创建单元格
        Cell cell = row.createCell(0);
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 20);
        //设置单元格的值
        cell.setCellValue("学生姓名");
        cell = row.createCell(1);
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 20);
        cell.setCellValue("学生学号");
        cell = row.createCell(2);
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 20);
        cell.setCellValue("学生性别");
        cell = row.createCell(3);
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 20);
        cell.setCellValue("宿舍号");
        cell = row.createCell(4);
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 20);
        cell.setCellValue("其他情况说明");

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
           	 sex="男";
           }else {
           	 sex="女";
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
		fos = new FileOutputStream("D:/学生宿舍分配系统.xls");
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
//			//如果程序发生异常没有写入成功那么,会直接走catch,那么如果close()写在try中则不会被关闭,使用finally不管是否发生异常都会被关闭
//             wb.write(fos);
//		} catch (IOException e) {
//			throw new RuntimeException("文本写入失败! 异常信息:\n"+e.getMessage());
//		}finally{
//			try {
//				if(fos != null)//如果对象创建失败则不需要关闭
//					fos.close();
//			} catch (IOException e) {
//				throw new RuntimeException("资源释放失败! 异常信息:\n"+e.getMessage());
//			}
//		}
	}

   }




