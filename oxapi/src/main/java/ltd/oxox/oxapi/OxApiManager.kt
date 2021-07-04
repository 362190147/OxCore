package top.yumesekai.yumeapi

import ltd.oxox.oxapi.AdminApi
import ltd.oxox.oxapi.QuestionApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

/***
 * @author chenjunwei
 */
class OxApiManager private constructor(){
    private val retrofit:Retrofit

    val admin: AdminApi
    val questionApi:QuestionApi
    init {
        val client = OkHttpClient.Builder()
                .addInterceptor(Interceptor {
                    return@Interceptor it.proceed(it.request())
                })
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                 .addConverterFactory(GsonConverterFactory.create())
                 //.addCallAdapterFactory()
                .build()
        admin = retrofit.create(AdminApi::class.java)
        questionApi= retrofit.create(QuestionApi::class.java)
    }


    companion object{
        var baseUrl = "http://www.oxox.ltd:3001/"
        val Instance by lazy { OxApiManager() }
        class Builder{
            fun build(): OxApiManager {
                return OxApiManager()
            }
        }
    }
}