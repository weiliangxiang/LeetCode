package demo20180107;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.jayway.jsonpath.JsonPath;

public class SaveParamsUtils {
	
	private static Map<String, Object> saveMap = new HashMap<String, Object>();
	
	
	public static void saveMapbyJsonPath(String result,String save){
		Map<String,Object> map = MapUtils.coverStringToMap(save);
	if(map!=null){
	for (Entry<String, Object> entry : map.entrySet()) {
		System.out.println(entry.getKey() + " ---  "+entry.getValue().toString());
		String key = entry.getKey();
		if(key.endsWith("*")){
			String before= key.split("_")[0];
			List<Object> list=  JsonPath.read(result, entry.getValue().toString());
			for(int i=0;i<list.size();i++){
				//System.out.println("-----------"+before+"_"+(i+1) + "-------:----------"+ list.get(i));
				saveMap.put(before+"_"+(i+1),list.get(i));
			}
		}else{
			saveMap.put(entry.getKey(), JsonPath.read(result, entry.getValue().toString()));
			
		}
	  }
	}
}
	
//	public static void saveMapbyJsonPath(String json, String save){
//		Map<String,Object> map = MapUtils.covertStringToMp(save);
//		if(map!=null){
//		for (Entry<String, Object> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + " ---  "+entry.getValue().toString());
//			String key = entry.getKey();
//			saveMap.put(key, JsonPath.read(json, entry.getValue().toString()));
//		  }
//		}
//		System.out.println(saveMap);
//	}
	
	public static Object get(String key) {
		return saveMap.get(key);
		
	}

}
