package demo20171224;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.util.SystemOutLogger;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.type.AviatorBoolean;

public class AssertDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Object> env=new HashMap<String, Object>();
		env.put("a", 2);
		Boolean result2=(Boolean) AviatorEvaluator.execute("a>1",env);
		System.out.println(result2);
		
		//
		long result=(Long) AviatorEvaluator.execute("1+2+3+4");
		System.out.println(result);

	}

}
