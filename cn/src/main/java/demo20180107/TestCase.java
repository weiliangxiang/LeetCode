package demo20180107;

import java.test;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.github.crab2died.ExcelUtils;
import com.googlecode.aviator.AviatorEvaluator;
import com.jayway.jsonpath.JsonPath;

public class TestCase {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ScheduledExecutorService se = Executors.newScheduledThreadPool(5);
//		se.schedule(new Runnable() {
//
//			@Override
//			public void run() {
//				test1();
//			}
//		}, 3, TimeUnit.SECONDS);
//	}

	public static void test1() {
		String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "apitest.xlsx";
		try {
			List<ExcelElement> elementlist = ExcelUtils.getInstance().readExcel2Objects(path, ExcelElement.class);
			for (ExcelElement key : elementlist) {
				PatternUtils.matcher(key);
				String result = null;
				if (key.getRun().equalsIgnoreCase("是")) {
					if ("get".equalsIgnoreCase(key.getType())) {
						result = HttpUtils.doGet(key.getUrl(), MapUtils.coverStringToMap(key.getHeader(), "&"));
						//System.out.println(key.getHeader());
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
						key.setResult("测试通过");
					} else {
						key.setResult("测试失败");
					}
					System.out.println(result);
				}
				//写结果
//				String path_result = System.getProperty("user.dir") + File.separator + "data" + File.separator+"result_"+DateUtil.getCurrentTime()+".xlsx";
//				ExcelUtils.getInstance().exportObjects2Excel(elementlist, ExcelElement.class, path_result);
//				EmailUtils.sendEmailsWithAttachments(path_result+"测试报告001", "Contenx", path_result);
//				System.out.println("发送成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public static void test2() {
		ScheduledExecutorService se = Executors.newScheduledThreadPool(5);
		se.schedule(new Runnable() {

			@Override
			public void run() {
				test1();
			}
		}, 3, TimeUnit.SECONDS);
	}

}
