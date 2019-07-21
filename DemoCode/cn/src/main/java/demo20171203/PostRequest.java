package demo20171203;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class PostRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.创建一个连接池
		CloseableHttpClient client=HttpClients.createDefault();
		//2.创建一个post请求
		HttpPost post=new HttpPost("http://123.58.251.183:8080/goods/UserServlet");
		//7.拼接post请求参数
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("method","loginMobile"));
		list.add(new BasicNameValuePair("loginname", "abc"));
		list.add(new BasicNameValuePair("loginpass", "abc"));
		
		try {
			//3.创建post请求参数
			HttpEntity postEntity=new UrlEncodedFormEntity(list);
			//将参数拼接到post请求中
			post.setEntity(postEntity);
			//post.setHeader("", "");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//
		HttpEntity entity=null;
		//创建响应
		try {
			//4.执行post请求
			CloseableHttpResponse response=client.execute(post);
			//5.获取实体类
			 entity=response.getEntity();
			 //System.out.println(entity);
			//6.解析实体类
			System.out.println(EntityUtils.toString(entity,"utf-8"));
			//获取响应状态
			//StatusLine statusLine=response.getStatusLine();
			//根据响应状态获取状态码
			//System.out.println(statusLine.getStatusCode());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				EntityUtils.consume(entity);
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

}
