package demo20180107;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.googlecode.aviator.AviatorEvaluator;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="E:\\Users\\Administrator\\Documents\\workspace-sts-3.9.1.RELEASE\\DemoCode\\cn\\data\\test.json.txt";
		File file=new File(path);
		try {
			String result=FileUtils.readFileToString(file, "utf-8");
			//System.out.println(result);
			Object bookid=JsonPath.read(result, "$.store.book.length()");
			System.out.println("一共有"+bookid+"书");
			//增加判断
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("data", bookid);
			Boolean boolean1=(Boolean)AviatorEvaluator.exec("data>2", bookid);
			System.out.println(boolean1);
			//增加判断颜色
			Object color=JsonPath.read(file, "$.store.bicycle.color");
			Map<String,Object> map2=new HashMap<String,Object>();
			map.put("data", color);
			Boolean boolean2=(Boolean)AviatorEvaluator.exec("data=='black'",color);
			System.out.println("颜色="+boolean2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
