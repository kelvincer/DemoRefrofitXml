package com.home.shimmerrecyclerdemo;

import com.home.shimmerrecyclerdemo.xmlparse.PlaceSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlacesApiService {

    @GET("textsearch/xml")
    Call<PlaceApiResponse> getTextResults(@Query("query") String query,           // required
                                             @Query("key") String key,
                                             @Query("pagetoken") String token);      // required

}
