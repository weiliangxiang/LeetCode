package demo20171217;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.MimeMultipart;

import org.apache.commons.collections4.Get;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.poi.util.SystemOutLogger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpUtilsFan {
	private static CloseableHttpClient httpclient;
	static {
		PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
		manager.setMaxTotal(200); // 连接池最大并发连接数
		manager.setDefaultMaxPerRoute(200);// 单路由最大并发数,路由是对maxTotal的细分
		httpclient = HttpClients.custom().setConnectionManager(manager).build();
	}
	/*
	 * ConnectionRequestTimeout httpclient使用连接池来管理连接，这个时间就是从连接池获取连接的超时时间，可以想象下数据库连接池
	 * ConnectTimeout 建立连接最大时间 SocketTimeout 数据传输过程中数据包之间间隔的最大时间 HttpHost 代理
	 */
	private static RequestConfig config = RequestConfig.copy(RequestConfig.DEFAULT).setSocketTimeout(10000)
			.setConnectTimeout(5000).setConnectionRequestTimeout(100).build();
	// .setProxy(new HttpHost("127.0.0.1", 8888, "http")).build();
	
	

	public  String doGet(String url,Map<String, String> parms,Map<String, String> header) throws IOException {
		String result=null;
		HttpEntity geEntity=null;
		/**/
		//创建一个Get请求方法
		HttpGet httpGet=new HttpGet(url);
		httpGet.getConfig();
		//添加请求头
		//httpGet.setHeader("key","values");
		//执行Get方法
		try {
			HttpResponse getResponse =httpclient.execute(httpGet);
			//获取响应实体
			geEntity=getResponse.getEntity();
			//打印响应实体内容
			 result= EntityUtils.toString(geEntity);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			EntityUtils.consume(geEntity);
			httpclient.close();
		}
		
		return result;
		
	}
	//重载，没有header的get请求
	public  String doGet(String url,Map<String, String> parms) {
		String result=null;
		try {
			 result= doGet(url, parms, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//重载，只有个url请求
	public  String doGet(String url) {
		String result=null;
		try {
			 result= doGet(url, null, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static String doPost(String url,Map<String, String>params,Map<String, String> header) throws ClientProtocolException, IOException {
		String postresult;
		//创建post请求
		HttpPost httpPost=new HttpPost(url);
		//添加header
		httpPost.addHeader("key","vales");
		//添加params
		List<NameValuePair> param = new ArrayList<NameValuePair>();
		for(Map.Entry<String, String> entry:params.entrySet()) {
			param.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
		}
		UrlEncodedFormEntity post_post_entity=new UrlEncodedFormEntity(param);
		httpPost.setEntity(post_post_entity);
		//
		CloseableHttpResponse postResponse=httpclient.execute(httpPost);
		
		//获取响应实体
		HttpEntity post_response_entity=postResponse.getEntity();
		System.out.println(postResponse.getStatusLine().getStatusCode());
		//将响应实体转换成String类型并打印
		postresult=EntityUtils.toString(post_response_entity);
		return postresult;
		
	}
	public static String doPost(String url,Map<String, String>params) {
		String result=null;
		try {
			result= doPost(url, params, null);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static String doPostJson(String url,String JsonParam,Map<String, String> header) throws ClientProtocolException, IOException {
		String postresult;
		//创建post请求
		HttpPost httpPost=new HttpPost(url);
		//添加params
		StringEntity JsonEntity=new StringEntity(JsonParam);
		JsonEntity.setContentEncoding("UTF-8");
		JsonEntity.setContentType("application/json");
		httpPost.setEntity(JsonEntity);
		//
		CloseableHttpResponse postResponse=httpclient.execute(httpPost);
		//获取响应实体
		HttpEntity post_response_entity=postResponse.getEntity();
		System.out.println(postResponse.getStatusLine().getStatusCode());
		//将响应实体转换成String类型并打印
		postresult=EntityUtils.toString(post_response_entity);
		return postresult;
		
	}	public static String doupload(String url,Map<String, String> params,Map<String, String> header,File file) throws ClientProtocolException, IOException {
		String postresult;
		//创建post请求
		HttpPost httpPost=new HttpPost(url);
		//添加params
		//StringEntity JsonEntity=new StringEntity(JsonParam);
		MultipartEntityBuilder mEntityBuilder= MultipartEntityBuilder.create();
		mEntityBuilder.addBinaryBody("file", file);
		httpPost.setEntity(mEntityBuilder.build());
		//
		CloseableHttpResponse postResponse=httpclient.execute(httpPost);
		//获取响应实体
		HttpEntity post_response_entity=postResponse.getEntity();
		System.out.println(postResponse.getStatusLine().getStatusCode());
		//将响应实体转换成String类型并打印
		postresult=EntityUtils.toString(post_response_entity);
		return postresult;
		
	}
	

	


	public static void main(String[] args) throws ClientProtocolException, IOException {
		/*调用get方法*/
//		String string = doGet("http://59.110.139.20:8080/goods/UserServlet?method=loginMobile&loginname=abc&loginpass=abc",null,null);
//		System.out.println(string);
		/*调用post方法表单*/
//		Map<String, String> param=new HashMap<String, String>();
//		param.put("method","loginMobile");
//		param.put("loginname","abc");
//		param.put("loginpass","abc");
//		String string =doPost("http://59.110.139.20:8080/goods/UserServlet?", param, null);
//		System.out.println(string);
		/*调用Jsonpost方法*/
//		String url="http://123.58.251.183:8080/goods/json2";
//		//添加参数
//		Map<String, String> mapjson=new HashMap<String, String>();
//		mapjson.put("count","2");
//		String JsonParam=JSON.toJSONString(mapjson);
//		//添加header
//		Map<String, String> header=new HashMap<String, String>();
//		header.put("token","61b3590090982a0185dda9d3bd793b46");
//		String resultJosn=doPostJson(url, JsonParam, header);
//		System.out.println(resultJosn);
		//--------------------------调用postfile方法-------------------------
		String path=System.getProperty("user.dir")+File.separator+"data"+File.separator;
		File file=new File(path+"api.txt");
		String string=doupload("http://59.110.139.20:8080/FileSever/upload.do", null, null, file);
		System.out.println(string);
	}

}
