package com.example.changyi_core.net;

import com.example.changyi_core.app.ChangYi;
import com.example.changyi_core.app.ConfigType;

import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RestCreator {

    private static final class ParamsHolder{
        public static  final WeakHashMap<String,Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap getParams(){
        return  ParamsHolder.PARAMS;
    }
    public static RestService getRestService(){
        return RestServiceHolder.REST_SERVICES;
    }

    private static final class RetrofitHolder{
        private static final String BASE_URL = (String) ChangYi.getConfiguration(ConfigType.API_HOST);
        private static  final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private  static final class OkHttpHolder{
        private static final int TIME_OUT =60;
        private  static final ArrayList<Interceptor> INTERCEPTORS = ChangYi.getConfiguration(ConfigType.INTERCEPTOR);
        private static final OkHttpClient.Builder BUILDER = new OkHttpClient.Builder();
        private static  OkHttpClient.Builder addInterceptor(){
            if(INTERCEPTORS != null && !INTERCEPTORS.isEmpty()){
                for (Interceptor interceptor:INTERCEPTORS
                     ) {
                    BUILDER.addInterceptor(interceptor);
                }
            }
            return BUILDER;
        }

        private static final OkHttpClient OK_HTTP_CLIENT = addInterceptor()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    private static final class RestServiceHolder{
        private static final RestService REST_SERVICES = RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }

}
