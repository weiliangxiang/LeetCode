package demo20171210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
/*<?xml version="1.0" encoding="UTF-8"?>
<Students>
	<boy>tom</boy>
	<student id="1">
		<name go="common1">lily</name>
		<age>20</age>
	</student>
	<student id="2">
		<name go="common2">lucy</name>
		<age>30</age>
	</student>
	<title>abc,cbc,bbc,bbs</title>
	<ball size="20">pingpang</ball>
</Students>
 * 
 * 
 * */
public class GetXml {
	public static void main(String[] args) throws ConfigurationException {
		// ReadXML();
		GetProperties();
	}

	public static void ReadXML() throws ConfigurationException {
		// 读取配置文件中的单个字段
		XMLConfiguration configuration = new XMLConfiguration("config.xml");

		String boy = (configuration.getString("boy"));
		show(boy);
		// 读取文件中的数组
		// !!!!注意获取数组的数据结构，是students.name,不是直接name，也不能students.student.name
		List<Object> namelist = configuration.getList("student.name");
		System.out.println(Arrays.toString(namelist.toArray()));

		// 单独的元素获取多个值 <title>abc,cbc,bbc,bbs</title>
		List<Object> titlelist = configuration.getList("title");
		show(Arrays.toString(titlelist.toArray()));

		// 对于标签元素的属性，可以通过 标签[@属性名]这样的方式来获取
		show(configuration.getString("student[@id]"));

		// 对于嵌套标签的话，想获得某一项的话可以通过 标签名(索引名)这样的方式来获取
		show(configuration.getString("student(1)[@id]"));

		// 对于标签里面的属性名称可以这么取
		show(configuration.getString("student(0).name[@go]"));

	}

	/*
	 * ip=127.0.0.1 port=8080 sd=111 
	 * application.name = Killer App
	 * application.version = 1.6.2 
	 * application.title = ${application.name}${application.version} 
	 * con=cn-com-org-uk-edu-jp-hk
	 * keys=cn,com,org,uk,edu,jp,hk
	 */
	public static void GetProperties() throws ConfigurationException {
		// new对象并获取文件名
		Configuration conf = new PropertiesConfiguration("config.properties");
		// 对于ip这类的直接取就行
		String ip = conf.getString("ip");
		show(ip);
		
		 //这种根据上面属性获取而来的属性也是直接获取
		String application=conf.getString("application.title");
		show(application);
		
		 //再举个Configuration的比较实用的方法吧,在读取配置文件的时候有可能这个键值对应的值为空，那么在下面这个方法中     
        //你就可以为它设置默认值。比如下面这个例子就会在config.properties这个文件中找id的值，如果文件中没有配置id，就会给id设置值为123     
        //这样就保证了java的包装类不会返回空值。虽然功能很简单，但是很方便很实用。
//		String id=conf.getString("id", "456");
//		show(id);
		String id=conf.getString("id", "defaultid");   
        System.out.println(id);  
        
      //如果在properties 文件中有如下属性keys=cn,com,org,uk,edu,jp,hk，这样的类似一个值含有多个元素值
         List<Object> keylist=conf.getList("keys");
         show(Arrays.toString(keylist.toArray()));
         
       //接下来这两步加上的原因是，默认分割符号是逗号，而在配置文件中con的值中含有多个短横线分隔符，所以要重新设置分隔符读出来喽  
         AbstractConfiguration.setDefaultListDelimiter('-');  
         Configuration config = new PropertiesConfiguration("config.properties");  
         List<Object> cons=config.getList("con");
   
        
       

	}
	

	public static void show(Object object) {

		System.out.println(object);

	}

}
