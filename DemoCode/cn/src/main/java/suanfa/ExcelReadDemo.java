package suanfa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static Object[] ReadExcel(String filepath,String filename,String sheetname) throws IOException{
		//String path=System.getProperty("user.dir")+File.separator+"data"+File.separator;
		File file=new File(filepath+File.separator+filename);
		try {
			//创建FileInputStream对象用于读取Excel对象
			FileInputStream inputStream=new FileInputStream(file);
			//声明workbook对象
			Workbook workbook=new XSSFWorkbook(inputStream);
			//声明sheet对象
			org.apache.poi.ss.usermodel.Sheet sheet=workbook.getSheet(sheetname);
			//计算行数
			int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
			//创建对象存储Excel读取的数据
			List<Object[]> records= new ArrayList<Object[]>();
			//使用两个for循环遍历Excel的所有文件
			for(int i=1;i<rowCount+1;i++) {
			//获取行对象
				Row row=sheet.getRow(i);
			//定义一个数组，用来存储Excel数据文件每行中的数据
				String fields[] =new String[row.getLastCellNum()];
			for(int j=0;j<row.getFirstCellNum();j++) {
				fields[j]=row.getCell(j).getStringCellValue();
			}
			records.add(fields);	
			}
			//将存储的list数据转换成一个object数组
			Object[][] results= new Object[records.size()][];
			for(int i=0;i<records.size();i++) {
				results[i]=records.get(i);
			}
			return results;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		
		
	}

}
