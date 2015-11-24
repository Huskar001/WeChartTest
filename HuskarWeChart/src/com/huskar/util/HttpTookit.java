package com.huskar.util;



import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Map;

import org.apache.commons.httpclient.HttpClient; 
import org.apache.commons.httpclient.HttpMethod; 
import org.apache.commons.httpclient.HttpStatus; 
import org.apache.commons.httpclient.URIException; 
import org.apache.commons.httpclient.methods.GetMethod; 
import org.apache.commons.httpclient.methods.PostMethod; 
import org.apache.commons.httpclient.params.HttpMethodParams; 
import org.apache.commons.httpclient.util.URIUtil; 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject; 



/** 
* HTTP工具箱 
* 
* @author diaowei
*/ 
public final class HttpTookit { 
		private static Log log = LogFactory.getLog(HttpTookit.class);
        /** 
         * 执行一个HTTP GET请求，返回请求响应的HTML 
         * 
         * @param url                 请求的URL地址 
         * @param queryString 请求的查询参数,可以为null 
         * @param charset         字符集 
         * @param pretty            是否美化 
         * @return 返回请求响应的HTML 
         */ 
        public static String doGet(String url, String queryString, String charset, boolean pretty) { 
                StringBuffer response = new StringBuffer(); 
                HttpClient client = new HttpClient(); 
                HttpMethod method = new GetMethod(url); 
                try { 
                        if (queryString!=null){ 
                        	if(queryString!=""){
                                //对get请求参数做了http请求默认编码，好像没有任何问题，汉字编码后，就成为%式样的字符串 
                                method.setQueryString(URIUtil.encodeQuery(queryString));
                                }
                        }
                        client.executeMethod(method); 
                        if (method.getStatusCode() == HttpStatus.SC_OK) { 
                                BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset)); 
                                String line; 
                                while ((line = reader.readLine()) != null) { 
                                        if (pretty) 
                                                response.append(line).append(System.getProperty("line.separator")); 
                                        else 
                                                response.append(line); 
                                } 
                                reader.close(); 
                        } 
                } catch (URIException e) { 
                        log.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e); 
                } catch (IOException e) { 
                        log.error("执行HTTP Get请求" + url + "时，发生异常！", e); 
                } finally { 
                        method.releaseConnection(); 
                } 
                return response.toString(); 
        } 

        /** 
         * 执行一个HTTP POST请求，返回请求响应的HTML 
         * 
         * @param url         请求的URL地址 
         * @param params    请求的查询参数,可以为null 
         * @param charset 字符集 
         * @param pretty    是否美化 
         * @return 返回请求响应的HTML 
         */ 
        public static String doPost(String url, Map<String, String> params, String charset, boolean pretty) { 
                StringBuffer response = new StringBuffer(); 
                HttpClient client = new HttpClient(); 
                HttpMethod method = new PostMethod(url); 
                //设置Http Post数据 
                if (params != null) { 
                        HttpMethodParams p = new HttpMethodParams(); 
                        for (Map.Entry<String, String> entry : params.entrySet()) { 
                                p.setParameter(entry.getKey(), entry.getValue()); 
                        } 
                        method.setParams(p); 
                } 
                try { 
                        client.executeMethod(method); 
                        if (method.getStatusCode() == HttpStatus.SC_OK) { 
                                BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset)); 
                                String line; 
                                while ((line = reader.readLine()) != null) { 
                                        if (pretty) 
                                                response.append(line).append(System.getProperty("line.separator")); 
                                        else 
                                                response.append(line); 
                                } 
                                reader.close(); 
                        } 
                } catch (IOException e) { 
                        log.error("执行HTTP Post请求" + url + "时，发生异常！", e); 
                } finally { 
                        method.releaseConnection(); 
                } 
                return response.toString(); 
        } 

//        public static void main(String[] args) {
//                //String y = doGet("http://huskar.cn-hangzhou.aliapp.com/haha", null, "GBK", true); 
//                String y = doGet("http://cloud.bmob.cn/8c7926c0799e9754/surl?=CBuHzT", null, "GBK", true);
//                System.out.println(y); 
//                JSONObject jo;
//				try {
//					jo = new JSONObject(y);
//					JSONArray ja = jo.getJSONArray("results");
//					String type = ja.getJSONObject(0).getString("type");
//					String content =  ja.getJSONObject(0).getString("content");
//					System.out.println("type="+type);
//					System.out.println("content="+content);
//				} catch (JSONException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//        } 
}