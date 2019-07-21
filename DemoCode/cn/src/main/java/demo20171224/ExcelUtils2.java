package demo20171224;
import java.io.File;
import java.util.List;

import com.github.crab2died.ExcelUtils;
public class ExcelUtils2 {
	public static void main(String[] args) throws Exception {
    	String path=System.getProperty("user.dir")+File.separator+"data"+File.separator+"testExcel.xls";
		List<TestCase> list = ExcelUtils.getInstance().readExcel2Objects(path,TestCase.class);
		for (TestCase testCase : list) {
			System.out.println(testCase);
		}
		
		
	}
	//List<TestCase> list=ExcelUtils.getInstance().readExcel2Objects(path, TestCase.class);

	
}
