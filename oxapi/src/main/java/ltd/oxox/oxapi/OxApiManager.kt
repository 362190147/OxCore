package top.yumesekai.yumeapi

import ltd.oxox.oxapi.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

/***
 * @author chenjunwei
 */
object OxApiManager {
    val accountApi: AccountApi
    //var baseUrl = "http://192.168.1.2:3001/"
    var baseUrl = "http://www.oxox.ltd:3001/"
    private val retrofit: Retrofit
    var auth = ""
    val admin: AdminApi
    val questionApi: QuestionApi
    val userApi: UserApi
    val examApi: ExamApi

    init {
        val client = OkHttpClient.Builder()
            //统一添加token
            .addInterceptor(Interceptor { chain ->
                val original: Request = chain.request()
                // Request customization: add request headers
                val requestBuilder: Request.Builder = original.newBuilder()
                    .addHeader("auth", auth)
                val request: Request = requestBuilder.build()
                chain.proceed(request)
            })
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory()
            .build()
        admin = retrofit.create(AdminApi::class.java)
        accountApi = retrofit.create(AccountApi::class.java)
        questionApi = retrofit.create(QuestionApi::class.java)
        userApi = retrofit.create(UserApi::class.java)
        examApi = retrofit.create(ExamApi::class.java)
    }
}