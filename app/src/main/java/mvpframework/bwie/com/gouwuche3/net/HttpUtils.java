package mvpframework.bwie.com.gouwuche3.net;

import android.util.Log;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 张梦乔创建于 2017/12/21.
 * 9:04
 */

public class HttpUtils {
    private static HttpUtils httpUtils;
    private final OkHttpClient client;
    private HttpUtils(){
        HttpLoggingInterceptor logging=new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client=new OkHttpClient.Builder().addInterceptor(new MyInterceptor()).build();
    }
    public static HttpUtils getHttpUtils(){
        if(httpUtils==null){
            synchronized (HttpUtils.class){
                if(httpUtils==null){
                    httpUtils=new HttpUtils();
                }
            }
        }
        return httpUtils;
    }
    /*
    * GET请求*/
    public void doGet(String url, Callback callback){
        Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * POST请求
     *
     * @param url
     * @param params
     * @param callback
     */
    public void doPost(String url, Map<String, String> params, Callback callback) {
        if (params == null) {
            throw new RuntimeException("参数为空了");
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        Log.e("OkHttpUtils", "请求地址：" + url + " 请求的参数：");
        FormBody formBody = builder.build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        client.newCall(request).enqueue(callback);

}
}
