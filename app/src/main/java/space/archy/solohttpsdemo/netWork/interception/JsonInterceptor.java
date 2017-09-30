package space.archy.solohttpsdemo.netWork.interception;


import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @Author Archy Wang
 * @Date 2017/8/11
 * @Description
 */

public class JsonInterceptor implements Interceptor {

    private final String RESPONSE_CODE = "code";
    private final String RESPONSE_MESSAGE = "message";
    private final String RESPONSE_DATA = "data";
    private final int RESPONSE_CODE_SUCCESS = 200;

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        MediaType mediaType = response.body().contentType();
        ResponseBody body = response.body();
        if (body != null) {
            String content = body.string();
            try {
                JSONObject responseJson = new JSONObject(content);
                if(responseJson.has(RESPONSE_CODE)){
                    if(responseJson.getInt(RESPONSE_CODE)==RESPONSE_CODE_SUCCESS){
                        if (responseJson.has(RESPONSE_DATA)){
                            Object data = responseJson.get(RESPONSE_DATA);
                            ResponseBody responseBody = ResponseBody.create(mediaType, data.toString());
                            return response.newBuilder().body(responseBody).build();
                        }else {
                            throw new JSONException("Rsponse body does not has Response Data ");
                        }

                    }else {
                        if (responseJson.has(RESPONSE_MESSAGE)){
                            throw new JSONException("Response Error message:"+RESPONSE_MESSAGE);
                        }else {
                            throw new JSONException("Response does not have Response Message");
                        }
                    }
                }else {
                    throw new JSONException("Response does not have Response Code");
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else {
            throw  new IOException("ResponseBody is Empty from the service");
        }


        return null;
    }
}
