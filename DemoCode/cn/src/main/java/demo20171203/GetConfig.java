package demo20171203;

import java.util.Arrays;  
import java.util.List;  
  
import org.apache.commons.configuration.AbstractConfiguration;  
import org.apache.commons.configuration.Configuration;  
import org.apache.commons.configuration.ConfigurationException;  
import org.apache.commons.configuration.PropertiesConfiguration;  
  
public class GetConfig {  
      
    public static void main(String[] args) {  
        testReadProperties();  
    }  
      
    public static void testReadProperties(){  
        //注意路径默认指向的是classpath的根目录     
        Configuration config;  
        try {  
            config = new PropertiesConfiguration("config.properties");  
            //对于一般属性直接获取就行  
            String ip=config.getString("ip");     
            int port=config.getInt("port");     
              
            //这种根据上面属性获取而来的属性也是直接获取  
            String title=config.getString("application.title");     
            System.out.println(ip+"\n"+port+"\n"+title);     
              
            //再举个Configuration的比较实用的方法吧,在读取配置文件的时候有可能这个键值对应的值为空，那么在下面这个方法中     
            //你就可以为它设置默认值。比如下面这个例子就会在config.properties这个文件中找id的值，如果文件中没有配置id，就会给id设置值为123     
            //这样就保证了java的包装类不会返回空值。虽然功能很简单，但是很方便很实用。     
            String id=config.getString("id", "defaultid");   
            System.out.println(id);  
              
            //如果在properties 文件中有如下属性keys=cn,com,org,uk,edu,jp,hk，这样的类似一个值含有多个元素值     
            //那么下面两种方法都可以  
            String[] keys1=config.getStringArray("keys");   
            System.out.println(Arrays.toString(keys1));  
            List<Object> keys2=config.getList("keys");    
            System.out.println(Arrays.toString(keys2.toArray()));  
              
            //接下来这两步加上的原因是，默认分割符号是逗号，而在配置文件中con的值中含有多个短横线分隔符，所以要重新设置分隔符读出来喽  
            AbstractConfiguration.setDefaultListDelimiter('-');  
            config = new PropertiesConfiguration("config.properties");  
            List<Object> cons=config.getList("con");    
            System.out.println(Arrays.toString(cons.toArray()));  
            /** 
             *  
             *  依次输出结果如下 
             *  127.0.0.1 
             *  8080 
             *  Killer App 1.6.2 
             *  defaultid 
             *  [cn, com, org, uk, edu, jp, hk] 
             *  [cn, com, org, uk, edu, jp, hk] 
             *  [cn, com, org, uk, edu, jp, hk] 
             */  
        } catch (ConfigurationException e) {  
            e.printStackTrace();  
        }     
          
    }  
}  
