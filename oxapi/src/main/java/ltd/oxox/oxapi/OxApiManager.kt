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

    //var baseUrl = "http://192.168.1.2:3001/"
    var baseUrl = "http://www.oxox.ltd:3001/"
    private val retrofit: Retrofit
    var auth = ""
    class Api(retrofit: Retrofit){
        var admin: AdminApi? = null
        var question: QuestionApi? = null
        var user: UserApi? = null
        var exam: ExamApi? = null
        var account : AccountApi
        init {
            admin  = retrofit.create(AdminApi::class.java)
            account = retrofit.create(AccountApi::class.java)
            question = retrofit.create(QuestionApi::class.java)
            user = retrofit.create(UserApi::class.java)
            exam = retrofit.create(ExamApi::class.java)
        }
    }
    val api:Api

    init {
        val client = OkHttpClient.Builder()
            //统一添加token
            .addInterceptor(Interceptor { chain ->
                val original: Request = chain.request()
                // Request customization: add request headers
                val requestBuilder: Request.Builder = original.newBuilder()
                    .addHeader("auth", auth)
                val request: Request = requestBuilder.build()
                val response = chain.proceed(request)

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
        api = Api(retrofit);
    }
}