package com.matsyuk.authcase.data.common_network;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * @author e.matsyuk
 */
public interface CommonApi {

    @GET("/api/get/token")
    Observable<String> updateToken(@Body RequestTokenModel requestTokenModel);

}
