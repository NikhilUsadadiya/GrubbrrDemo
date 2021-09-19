package com.dev.mvvmsampleapp.data.network

import com.dev.mvvmsampleapp.data.network.responses.AuthResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


interface MyApi {

    @FormUrlEncoded
    @POST ("BranchLogin")
    @Headers("Version:1.0")
    suspend fun userLogin (
        @Field ("Username") email: String,
        @Field ("password") password: String,
        @Field ("AppVersion") appVersion: String,
        @Field ("DeviceType") deviceType: String,
        @Field ("DeviceID") deviceid: String,
        @Field ("ModuleID") moduleid: String,
        @Field ("FCMID") fcmid: String
    ) : Response<AuthResponse>


    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : MyApi {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build()
          /*  val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()*/

            return Retrofit.Builder()
                .baseUrl("https://staging.grubbrr.com/api/")
//                .baseUrl("https://api.simplifiedcoding.in/course-apis/recyclerview/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(MyApi::class.java)
        }
    }


}