package demo20180107;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.crab2died.ExcelUtils;

public class TestngExe {
	 @DataProvider(name = "ExcelData")
	    public static Iterator<Object[]> parameterIntTestProvider() {
			String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "apitest.xlsx";
	    	List<Object[]> dataProvider = new ArrayList<Object[]>();
	    	try {
				List<ExcelElement> elementlist = ExcelUtils.getInstance().readExcel2Objects(path, ExcelElement.class);
				for (ExcelElement excelElement : elementlist) {
					if (excelElement.getRun().equalsIgnoreCase("是")) {
						dataProvider.add(new Object[] {excelElement});
					}
				}
	    	} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//	    	for(int i=0;i<10;i++){
//	    		TestBean bean = new TestBean();
//	    		bean.setName("testname");
//	    		bean.setMsg("--"+i);
//	    		dataProvider.add(new Object[] { bean});
//	    	}
	        return dataProvider.iterator();
	    }

	@Test(dataProvider = "ExcelData")
	public static void TestngDemo(ExcelElement key) throws HttpClientException {
		PatternUtils.matcher(key);
		String result = null;
		if (key.getRun().equalsIgnoreCase("是")) {
			if ("get".equalsIgnoreCase(key.getType())) {
				result = HttpUtils.doGet(key.getUrl(), MapUtils.coverStringToMap(key.getHeader(), "&"));
				// System.out.println(key.getHeader());
			} else if ("post".equalsIgnoreCase(key.getType())) {
				result = HttpUtils.doPost(key.getUrl(), MapUtils.coverStringToMap(key.getParams(), "&"),
						MapUtils.coverStringToMap(key.getHeader()));
			} else if ("postjson".equalsIgnoreCase(key.getType())) {
				result = HttpUtils.doPostJson(key.getUrl(), key.getParams(),
						MapUtils.coverStringToMap(key.getHeader()));
			}
			Boolean check = CheckPointUtils.checkbyJsonPath(result, key.getCheck());
			if (check) {
				SaveParamsUtils.saveMapbyJsonPath(result, key.getCorrection());
//				key.setResult("测试通过");
				
			} 
			Assert.assertTrue(false);
//			else {
//				key.setResult("测试失败");
//			}
			System.out.println(result);
			
		}
	}
	
}
