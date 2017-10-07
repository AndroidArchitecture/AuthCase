package com.matsyuk.authcase.di.app;

import com.matsyuk.authcase.data.auth.AuthHolder;
import com.matsyuk.authcase.data.auth_network.AuthApi;
import com.matsyuk.authcase.data.auth_network.MainAuthenticator;
import com.matsyuk.authcase.data.auth_network.MainInterceptor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * @author e.matsyuk
 */
@Module
public class AuthNetworkModule {

    @Provides
    @Singleton
    public Interceptor provideInterceptor(AuthHolder authHolder) {
        return new MainInterceptor(authHolder);
    }

    @Provides
    @Singleton
    public Authenticator provideAuthenticator(AuthHolder authHolder) {
        return new MainAuthenticator(authHolder);
    }

    @Provides
    @Singleton
    @Named("auth")
    public OkHttpClient provideOkHttpClient(Interceptor interceptor, Authenticator authenticator) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .authenticator(authenticator)
                .build();
    }

    @Provides
    @Singleton
    @Named("auth")
    public Retrofit provideRetrofit(@Named("auth") OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("some_url")
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public AuthApi provideAuthApi(@Named("auth") Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }

}
