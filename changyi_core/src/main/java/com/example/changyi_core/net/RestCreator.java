package com.example.changyi_core.net;

import com.example.changyi_core.app.ChangYi;
import com.example.changyi_core.app.ConfigType;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

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
        private static final String BASE_URL = (String) ChangYi.getConfigurations().get(ConfigType.API_HOST.name());
        private static  final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private  static final class OkHttpHolder{
        private static final int TIME_OUT =60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    private static final class RestServiceHolder{
        private static final RestService REST_SERVICES = RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }

}
