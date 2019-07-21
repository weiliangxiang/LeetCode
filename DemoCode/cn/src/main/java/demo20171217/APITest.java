package demo20171217;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class APITest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path=System.getProperty("user.dir")+File.separator+"data"+File.separator;
		File file=new File(path+"api.txt");
		List<String> lines=FileUtils.readLines(file,"utf-8");
		int count=0;
		for (String line : lines) {
			if (count++>0) {
				String[] strings=line.split(";");
				for (String keys : strings) {
					//System.out.println(key);
					String[] key=keys.split("&");
					for (String string : key) {
						//System.out.println(string);
						String[] k_v=string.split("=");
						for (String string2 : k_v) {
							System.out.println(string2);
						}
//						Map<String, String> map=new HashMap<String, String>();
//						map.put(key[0], key[1]);
//						Set<Map.Entry<String, String>> ms= map.entrySet();
//						Iterator<Map.Entry<String, String>> iterator=ms.iterator();
//						while (iterator.hasNext()) {
//							Map.Entry<String, String> kv=iterator.next();
//							System.out.println(kv.getKey());
//							System.out.println(kv.getKey());
//						}
						
					}
				}
			}
			
		}
		


		
	}

}
