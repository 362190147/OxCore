package ltd.oxox.oxapi

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/***
 * @author chenjunwei
 */
object OxApiManager {
    val accountApi: AccountApi
    //var baseUrl = "http://192.168.1.2:3001/"
    var baseUrl = "http://www.oxox.ltd:3001/"
    private val retrofit: Retrofit
    var auth = ""
    object Api{
        var admin: AdminApi? = null
        var question: QuestionApi? = null
        var user: UserApi? = null
        var exam: ExamApi? = null
    }

    init {
        val client = OkHttpClient.Builder()
            //统一添加token
            .addInterceptor(Interceptor { chain ->
                val original: Request = chain.request()
                // Request customization: add request headers
                val requestBuilder: Request.Builder = original.newBuilder()
                    .addHeader("auth", auth)
                val request: Request = requestBuilder.build()
                val response =chain.proceed(request)
                if(response.code() == 200){

                }

                response
            })
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory()
            .build()
        Api.admin = retrofit.create(AdminApi::class.java)
        accountApi = retrofit.create(AccountApi::class.java)
        Api.question = retrofit.create(QuestionApi::class.java)
        Api.user = retrofit.create(UserApi::class.java)
        Api.exam = retrofit.create(ExamApi::class.java)
    }
}