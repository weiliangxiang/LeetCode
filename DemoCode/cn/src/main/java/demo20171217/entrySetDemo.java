package demo20171217;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class entrySetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "weiliangxiang");
		map.put("age", "23");
		map.put("sex", "boy");
		//将map的映射关系取出，并存入set集合中
		Set<Map.Entry<String, String>> entrySet=map.entrySet();
		//这个关系就是Map.Entry类型，那么关系Map.Entry获取到后，就可以获取到关系中的键值
		Iterator<Map.Entry<String, String>> it =entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> me=it.next();
			System.out.println(me.getKey()+":"+me.getValue());
		}

	}

}
