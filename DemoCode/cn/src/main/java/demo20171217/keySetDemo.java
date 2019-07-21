package demo20171217;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class keySetDemo {
/*map集合的两种取出方式：
 * 1.keySet：将map中的所有的键存入到Set集合中，因为Set集合具备迭代器，所以可以以迭代方式
 * 取出所有的键，在根据get，获取每一个键对应的值
 * Map集合的取出原理：将map集合转换成set集合，再通过迭代器取出
 * 2.entrySet：将map集合中的映射关系存到set集合中，
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "weiliangxinag");
		map.put("age", "18");
		map.put("sex", "boy");
		//先获取map集合所有键的set集合，keyset
		Set<String> keyset=map.keySet();
		//有了set集合就可以获取迭代器了
		Iterator<String> iterator=keyset.iterator();
		while (iterator.hasNext()) {
			String key =iterator.next();
			System.out.println(key+":"+map.get(key));
}

	}

}
