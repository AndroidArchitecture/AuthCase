package com.matsyuk.authcase.di.main;

import android.support.annotation.NonNull;

import com.matsyuk.authcase.data.auth.AuthHolder;
import com.matsyuk.authcase.data.network.MainInterceptor;
import com.matsyuk.authcase.data.network.SomeApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * @author e.matsyuk
 */
@Module
public class NetworkModule {

    @Provides
    @NonNull
    @Singleton
    public Interceptor provideInterceptor(AuthHolder authHolder) {
        return new MainInterceptor(authHolder);
    }

    @Provides
    @NonNull
    @Singleton
    public OkHttpClient provideOkHttpClient(Interceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    @NonNull
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("some_url")
                .client(okHttpClient)
                .build();
    }

    @Provides
    @NonNull
    @Singleton
    public SomeApi provideAccountService(@NonNull Retrofit retrofit) {
        return retrofit.create(SomeApi.class);
    }

}
