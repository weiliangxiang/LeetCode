package demo20171217;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import com.alibaba.fastjson.JSON;
public class HttpUtils {
	//配置文件
	private static PoolingHttpClientConnectionManager connMgr;
	private static RequestConfig requestConfig;
	private static final int MAX_TIMEOUT = 7000;
	static {
		// 设置连接池
		connMgr = new PoolingHttpClientConnectionManager();
		// 设置连接池大小
		connMgr.setMaxTotal(100);
		connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

		RequestConfig.Builder configBuilder = RequestConfig.custom();
		// 设置连接超时
		configBuilder.setConnectTimeout(MAX_TIMEOUT);
		// 设置读取超时
		configBuilder.setSocketTimeout(MAX_TIMEOUT);
		// 设置从连接池获取连接实例的超时
		configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
		// 在提交请求之前 测试连接是否可用
		// configBuilder.setStaleConnectionCheckEnabled(true);
		requestConfig = configBuilder.build();
	}
	//主函数入口
	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		Map<String, Object> params=new HashMap<String,Object>();
		params.put("method", "loginMobile");
		params.put("loginname", "abc");
		params.put("loginpass", "abc");
		String reString=doGet("http://59.110.139.20:8080/goods/UserServlet", params);
		System.out.println(reString);
	}



	public static String doGet(String url, Map<String, Object> params) throws ClientProtocolException, IOException {
		String apiurl = url;
		StringBuffer param = new StringBuffer();
		int i = 0;
		for (String key : params.keySet()) {
			if (i == 0) {
				param.append("?");
			} else {
				param.append("&");
			}
			param.append(key).append("=").append(params.get(key));
			i++;

		}
		apiurl += param;
		String result = null;
		// 建立连接池
		CloseableHttpClient getclient =HttpClients.createDefault();
		// get请求
		HttpGet httpGet = new HttpGet(apiurl);
		// 获取get请求的Response
		HttpResponse getRespone = getclient.execute(httpGet);
		// 获取response的状态
		int getstatus = getRespone.getStatusLine().getStatusCode();
		//System.out.println("Respone的状态码为" + getstatus);
		// 建立response实体
		HttpEntity entity = getRespone.getEntity();
//		System.out.println("获取entity的值" + entity);
//		System.out.println(entity.getContent());
		// 对实体进行判断
		if (null != entity) {
			InputStream inputStream = entity.getContent();
//			System.out.println("实体的inputStream=" + inputStream);
			result = IOUtils.toString(inputStream, "UTF-8");
			

		}
		return result;

	}

}
