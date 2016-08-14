package org.sunny.coolweather.util;

import android.util.Base64;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;


/**
 * Created by home on 2016/8/4.
 */
public class HttpUtil {
    private static String Tag = "HttpUtil";

//    private static final OkHttpClient mOkHttpClient = new OkHttpClient();

    /*public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.i(Tag,address);
                    Request request = new Request.Builder().url(address).build();
                    Response response = execute(request);
                    String responseUrl = "";
                    if (response.isSuccessful()) {
                        responseUrl = response.body().string();
                        Log.i(Tag,responseUrl);
                        if (listener != null) {
                            listener.onFinish(responseUrl);
                        }
                    } else {
                        throw new IOException("Unexpected code " + response);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    listener.onError(e);
                }
            }
        }).start();
    }*/

//    private static Response execute(Request request) throws IOException {
//        return mOkHttpClient.newCall(request).execute();
//    }


    /*
    * 从服务器端获取省县市的数据
    */
    public static void sendHttpRequest(final String address,
                                       final HttpCallbackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                HttpURLConnection connection = null;
                Log.i(Tag,address);
                try {
                    //创建一个url对象
                    URL url = new URL(address);
                    //通过url对象获取HTTPURLCONNCETION实例
                    connection = (HttpURLConnection) url.openConnection();
                    //设置http的请求所使用的方法为get方法
                    connection.setRequestMethod("GET");
                    //自由定制一些属性，比如设置连接超时，读取超时的毫秒数
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);



                    if(address.contains("html")){
                        connection.setRequestProperty("Accept-Encoding", "identity");
                        connection.setRequestProperty("Content-Type", "text/html; charset=utf-8");
                        connection.setRequestProperty("Accept-Encoding","gzip");
                    }

                    printHeader(connection);


                    //获得服务器返回的输入流
                    String returnStr;
                    InputStream in;
                    in = connection.getInputStream();
                    //将得到的输入流装换成String字符串
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    StringBuffer response = new StringBuffer();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Log.i("HTTPUtil",
                            "------------------>" + response.toString());
                    returnStr = response.toString();

                    if (listener != null) {
                        listener.onFinish(returnStr);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                    if (listener != null) {
                        listener.onError(e);
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private static void printHeader(HttpURLConnection connection) {
        Map header  = connection.getHeaderFields();
        Set set = header.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Log.i(Tag,iterator.next().toString());
        }
    }

    public static String decompress(InputStream in) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
        StringBuffer response = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        Log.i(Tag,"decompress : "+ response.toString());
        return "";  //还原为原始编码的字符串
    }



}
