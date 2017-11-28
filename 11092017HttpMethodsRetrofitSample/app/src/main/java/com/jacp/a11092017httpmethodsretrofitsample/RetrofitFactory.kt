package com.jacp.a11092017httpmethodsretrofitsample

import com.jacp.a11092017httpmethodsretrofitsample.entities.Comment
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.Result


/**
 * Created by Aptivist-U002 on 11/9/2017.
 */
object RetrofitFactory {
    private val baseUrl = "http://10.0.2.2:3000/"

    interface CommentService {

        @GET("/comments")
        fun retrieveAllComments(): Single<List<Comment>>

        @GET("/comments/{id}")
        fun retrieveOneComment(@Path("id") commentId: Int): Single<Comment>

        @POST("/comments")
        fun createComment(@Body() comment: Comment): Single<Result<Comment>>

        @PUT("/comments/{commentId}")
        fun updateComment(@Path("commentId") commentId : Int, @Body() comment: Comment): Single<Comment>

        @DELETE("/comments/{commentId}")
        fun deleteComment(@Path("commentId") commentId: Int): Single<Comment>
    }

    fun createService() : CommentService{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(CommentService::class.java)
    }

}