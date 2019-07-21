package demo20171217;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.io.JsonStringEncoder;

public class Json {

	public static void main(String[] args) {
		//-------------- 普通的map-------------
		//jsonTo();//使用Map.Entry<String, String>解析
		//jsonTo2();//使用keySet解析
		//jsonTo3();//使用for解析
		//--------------List<Map<String,String>>-------------
		//listJson();
		listJson2();

	}

	public static void jsonTo() {
		String JsonString = "{\"msg\":\"登录成功\",\"uid\":\"9CC972DFA2D4481F89841A46FD1B3E7B\",\"code\":\"1\"}";
		// 反序列化
		Map<String, String> map = (Map<String, String>) JSON.parse(JsonString);
		// 将map集合转换成Set集合进行迭代
		Set<Map.Entry<String, String>> entry = map.entrySet();
		Iterator<Map.Entry<String, String>> it = entry.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> me = it.next();
			System.out.println(me.getKey() + " " + me.getValue());
		}
	}
	public static void jsonTo2() {
		String JsonString2="{\"msg\":\"登录成功\",\"uid\":\"9CC972DFA2D4481F89841A46FD1B3E7B\",\"code\":\"1\"}";
		//反序列化
		Map<String, String> map2= (Map<String, String>)JSON.parse(JsonString2);
		Set<String> keySet= map2.keySet();
		Iterator<String> it2=keySet.iterator();
		while (it2.hasNext()) {
			String key =it2.next();
			System.out.println(key+" "+map2.get(key));
			
		}
	


}
	public static void jsonTo3() {
		String jsonString3="{\"msg\":\"登录成功\",\"uid\":\"9CC972DFA2D4481F89841A46FD1B3E7B\",\"code\":\"1\"}";
		Map<String, String> map3=(Map<String, String>)JSON.parse(jsonString3);
		for (String key : map3.keySet()) {
			System.out.println(key+" "+map3.get(key));
		}
		
	}
	public static void listJson() {
		String liString="[{\"param5\":\"value5\",\"param3\":\"value3\",\"param4\":\"value4\",\"param1\":\"value1\",\"param2\":\"value2\"},"
				+ "{\"p1\":\"v1\",\"p2\":\"v2\",\"p3\":\"v3\",\"p4\":\"v4\",\"p5\":\"v5\"}]";
		List<Map<String, String>> maplist=JSON.parseObject(liString, new TypeReference<List<Map<String,String>>>(){});
		for(Map<String, String> stringObjectMap:maplist) {
			for(String key:stringObjectMap.keySet()) {
				System.out.println(key+" "+stringObjectMap.get(key));
			}
		}
	}
	///解析已有的对象  
	public static void listJson2() {
	     String string = "[{\"age\":12,\"date\":1465475917155,\"name\":\"s1\"},{\"age\":12,\"date\":1465475917175,\"name\":\"s2\"},{\"age\":12,\"date\":1465475917175,\"name\":\"s3\"},{\"age\":12,\"date\":1465475917175,\"name\":\"s4\"},{\"age\":12,\"date\":1465475917175,\"name\":\"s5\"},{\"age\":12,\"date\":1465475917175,\"name\":\"s6\"}]";
	     List<Student> studentlist=JSON.parseArray(string,Student.class);
	     for(Student student:studentlist) {
	    	 System.out.println(student.getName());
	     }
	}

}
