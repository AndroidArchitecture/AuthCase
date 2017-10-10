package com.matsyuk.authcase.di.app;

import com.matsyuk.authcase.data.common_network.CommonApi;

import java.util.concurrent.Executors;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * @author e.matsyuk
 */
@Module
public class CommonNetworkModule {

    @Provides
    @Singleton
    @Named("common")
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    @Singleton
    @Named("common")
    public Retrofit provideRetrofit(@Named("common") OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("some_url")
                .client(okHttpClient)
                .callbackExecutor(Executors.newFixedThreadPool(3))
                .build();
    }

    @Provides
    @Singleton
    public CommonApi provideCommonApi(@Named("common") Retrofit retrofit) {
        return retrofit.create(CommonApi.class);
    }

}
