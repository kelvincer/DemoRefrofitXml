package com.home.shimmerrecyclerdemo

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
import androidx.lifecycle.LiveData
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData
import com.home.shimmerrecyclerdemo.entities.Result


class DataRepository {

    val TAG = javaClass.simpleName
    var data: MutableLiveData<List<Result>> = MutableLiveData()

    fun getResults(): LiveData<List<Result>>? {


        val retrofit = Retrofit.Builder()
                .baseUrl(ConstantsHelper.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(PlacesApiService::class.java)

        val call = service.getTextResults("restaurantes lima", ConstantsHelper.GOOGLE_PLACE_API_KEY, Helper.TOKEN)

        call.enqueue(object : Callback<PlaceApiResponse> {
            override fun onResponse(call: Call<PlaceApiResponse>, response: Response<PlaceApiResponse>) {
                if (response.isSuccessful) {
                    val placeApiResponse = response.body()
                    Helper.TOKEN = placeApiResponse?.nextPageToken
                    data.value = placeApiResponse?.results
                    Log.d(TAG, "successful")
                }

                Log.d(TAG, response.raw().toString())
            }

            override fun onFailure(call: Call<PlaceApiResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return data
    }
}