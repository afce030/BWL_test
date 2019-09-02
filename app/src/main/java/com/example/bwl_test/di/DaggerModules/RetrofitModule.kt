package com.example.bwl_test.di.DaggerModules

import com.example.bwl_test.Model.Retrofit.WeatherWS
import com.example.bwl_test.Util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideGsonConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.connectTimeout(3, TimeUnit.SECONDS)
        okhttpClientBuilder.readTimeout(3, TimeUnit.SECONDS)
        return okhttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun providesRetrofitService(okHttpClient: OkHttpClient, gson: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gson)
            .build()
    }

    @Provides
    @Singleton
    fun providePosts(retrofit: Retrofit): WeatherWS{
        return retrofit.create(WeatherWS::class.java)
    }

}