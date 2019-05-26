package phil.homework.gitcrawler.model.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {
    val service = Retrofit.Builder()
        .client(OkHttpClient())
        .baseUrl(REPOSITORY_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}