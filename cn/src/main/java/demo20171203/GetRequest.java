package demo20171203;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
//以url的方式传入
public class GetRequest {
public static void main(String[] args) {
	/*
	 * */
	  //建立请求池
	  CloseableHttpClient httpClient=HttpClients.createDefault();
	  //创建某个请求
	  HttpGet get=new HttpGet("https://www.baidu.com/");
	  HttpEntity entity=null;
	try {
		//调用第一步创建好的实例
		CloseableHttpResponse response=httpClient.execute(get);
		//处理实例中的返回
		entity=response.getEntity();
		StatusLine statusLine= response.getStatusLine();
		int code=statusLine.getStatusCode();
		System.out.println(code);
		String result=EntityUtils.toString(entity);
		//System.out.println(result);
		
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			//请求实体释放
			EntityUtils.consume(entity);
			//释放连接池
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
  

}

