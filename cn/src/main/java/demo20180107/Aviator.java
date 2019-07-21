package demo20180107;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.io.FileUtils;
import com.googlecode.aviator.AviatorEvaluator;
import com.jayway.jsonpath.JsonPath;
public class Aviator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long result=(long)AviatorEvaluator.execute("1+2+3");
		//System.out.println(result);
		Map<String, Object> map=new HashedMap<String,Object>();
		map.put("data",1);
		Boolean result2=(Boolean) AviatorEvaluator.execute("data<=1",map);
		//System.out.println(result2);
		//读取json字符串
		String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "test.json.txt";
		File file=new File(path);
		String jsonstring=FileUtils.readFileToString(file, "utf-8");
		System.out.println(jsonstring);
		Object author=JsonPath.read(jsonstring, "$.store.book.length()");
		System.out.println(author);
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("shuzhi", author);
		Boolean check=(Boolean)AviatorEvaluator.exec("shuzhi<1", author);
		System.out.println(check);
	}

}
