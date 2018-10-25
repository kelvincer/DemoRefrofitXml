package com.home.shimmerrecyclerdemo.xmlparse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlacesApiService {

    @GET("textsearch/xml")
    Call<PlaceSearchResponse> getTextResults(@Query("query") String query,           // required
                                          @Query("key") String key,
                                          @Query("pagetoken") String token);      // required

}
