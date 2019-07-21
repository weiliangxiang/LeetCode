package demo20171224;

import java.io.File;
import java.util.List;

import com.github.crab2died.ExcelUtils;

public class ReadElement {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String path=System.getProperty("user.dir")+File.separator+"data"+File.separator+"ElementMap.xls";
		//String path=System.getProperty("user.dir")+File.separator+"data"+File.separator+"testExcel.xls";
		List<ElementMap> elementMaps= ExcelUtils.getInstance().readExcel2Objects(path, ElementMap.class);
		for (ElementMap elementMap : elementMaps) {
			System.out.println(elementMap);
		}

	}

}
