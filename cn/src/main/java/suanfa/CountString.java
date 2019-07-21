package suanfa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;

public class CountString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="I like playing games every day day";
		String[] keys=string.split(" ");
		Map<String, Integer> map=new HashMap<String, Integer>();
		//String key;
		for (String key : keys) {

			if(!map.containsKey(key)) {
				map.put(key, 1);
			}else  {
				map.put(key, map.get(key)+1);
			}
			}
		//��map��ӳ���ϵȡ����������set������
		Set<Map.Entry<String, Integer>> entrySet=map.entrySet();
		//�����ϵ����Map.Entry���ͣ���ô��ϵMap.Entry��ȡ���󣬾Ϳ��Ի�ȡ����ϵ�еļ�ֵ
		Iterator<Map.Entry<String, Integer>> it =entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> me=it.next();
			System.out.println(me.getKey()+":"+me.getValue());
			
			
		}

	}

}
