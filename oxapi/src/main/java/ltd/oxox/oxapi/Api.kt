package ltd.oxox.oxapi
import retrofit2.http.*
import java.io.File

import ltd.oxox.oxapi.data.*
interface AccountApi{  
   @POST("/account/check_code")
   @FormUrlEncoded
   suspend fun checkCode(@Field("account") account: String, @Field("code") code: String):HttpData<Object>
  
   @GET("/account/my")
   suspend fun getUserInfo():HttpData<UserInfo>
  
   @POST("/account/login")
   @FormUrlEncoded
   suspend fun login(@Field("account") account: String, @Field("password") password: String):HttpData<UserData>
  
   @PUT("/account/my")
   suspend fun putUserInfo(@Field("mail") mail: String, @Field("head_path") head_path: String, @Field("language") language: String):HttpData<UserInfo>
  
   @POST("/account/register")
   @FormUrlEncoded
   suspend fun register(@Field("account") account: String, @Field("password") password: String, @Field("user_name") user_name: String, @Field("true_name") true_name: String, @Field("code") code: String):HttpData<Object>
  
   @PUT("/account/reset_password")
   suspend fun resetPassword(@Field("mail") mail: String, @Field("time") time: String, @Field("sign") sign: String, @Field("password") password: String):HttpData<Object>
  
   @POST("/account/reset_password_by_mail")
   @FormUrlEncoded
   suspend fun resetPasswordByMail(@Field("mail") mail: String, @Field("reset_code") reset_code: String):HttpData<Object>
  
   @POST("/account/send_verify_code")
   @FormUrlEncoded
   suspend fun sendVerifyCode(@Field("account") account: String):HttpData<Object>
} 
interface AdminApi{  
   @DELETE("/admin/privileges/{id}")
   suspend fun deletePrivileges(@Path("id") id:String):HttpData<Object>
  
   @DELETE("/admin/roles/{id}")
   suspend fun deleteRoles(@Path("id") id:String):HttpData<Object>
  
   @GET("/admin/privileges")
   suspend fun getPrivilege():HttpData<Object>
  
   @GET("/admin/roles/{id}")
   suspend fun getRole(@Path("id") id:String):HttpData<Object>
  
   @GET("/admin/roles")
   suspend fun getRoles():HttpData<Object>
  
   @POST("/admin/privileges")
   @FormUrlEncoded
   suspend fun postPrivilege(@Field("name") name: String):HttpData<Object>
  
   @POST("/admin/roles")
   @FormUrlEncoded
   suspend fun postRole(@Field("name") name: String):HttpData<Object>
  
   @PUT("/admin/privileges/{id}")
   suspend fun putPrivileges(@Path("id") id:String, @Field("name") name: String?):HttpData<Object>
  
   @PUT("/admin/roles")
   suspend fun putRoles(@Field("name") name: String?, @Field("privs") privs: List<Int>?):HttpData<Object>
} 
interface ArticleApi{  
   @DELETE("/articles/{id}")
   suspend fun deleteArticle(@Path("id") id:String):HttpData<Object>
  
   @GET("/articles/{id}")
   suspend fun getArticle(@Path("id") id:String):HttpData<Object>
  
   @GET("/articles/")
   suspend fun getArticles(@Query("title") title: String?, @Query("content") content: String?, @Query("tags") tags: String?):HttpData<Object>
  
   @PUT("/articles/")
   suspend fun putArticle(@Field("id") id: Int, @Field("title") title: String, @Field("content") content: String, @Field("tags") tags: String):HttpData<Object>
  
   @POST("/articles/")
   @FormUrlEncoded
   suspend fun uploadArticle(@Field("title") title: String, @Field("content") content: String, @Field("tags") tags: String):HttpData<Object>
} 
interface BotApi{  
   @GET("/bot/help/{type}")
   suspend fun botHelp(@Path("type") type:String):HttpData<Object>
  
   @GET("/bot/bots/{id}")
   suspend fun getBot(@Path("id") id:String):HttpData<Object>
  
   @GET("/bot/bots")
   suspend fun getBotList():HttpData<Object>
  
   @GET("/bot/groups/{id}")
   suspend fun getGroup(@Path("id") id:String):HttpData<Object>
  
   @GET("/bot/groups")
   suspend fun getGroupList(@Query("id") id: Int):HttpData<Object>
  
   @PUT("/bot/bots/{id}/head_url")
   suspend fun setBotHead(@Path("id") id:String, @Field("imgurl") imgurl: String):HttpData<Object>
} 
interface DebugApi{  
   @GET("/debug")
   suspend fun debug():HttpData<Object>
  
   @PUT("/debug")
   suspend fun debugput(@Field("test") test: String):HttpData<Object>
} 
interface ExamApi{  
   @DELETE("/exams/{id}")
   suspend fun deleteExam(@Path("id") id:String):HttpData<List<Exam>>
  
   @GET("/exams/{id}")
   suspend fun getExam(@Path("id") id:String):HttpData<List<Exam>>
  
   @GET("/exams")
   suspend fun getExams():HttpData<List<Exam>>
  
   @POST("/exams")
   @FormUrlEncoded
   suspend fun postExam(@Field("name") name: String):HttpData<List<Exam>>
  
   @PUT("/exams/{id}")
   suspend fun putExam(@Path("id") id:String, @Field("name") name: String?):HttpData<List<Exam>>
} 
interface InstallApi{  
   @POST("/install/cheak_update")
   @FormUrlEncoded
   suspend fun cheakUpdate(@Field("name") name: String):HttpData<VersionInfo>
} 
interface QuestionApi{  
   @POST("/questions/")
   @FormUrlEncoded
   suspend fun allUploadQuesiton(@Field("questions") questions: List<Question>, @Field("name") name: String, @Field("examId") examId: Int, @Field("num") num: Int, @Field("question") question: String, @Field("a") a: String, @Field("b") b: String, @Field("c") c: String, @Field("d") d: String, @Field("answer") answer: String, @Field("answer_key") answer_key: String):HttpData<Object>
  
   @DELETE("/questions/{id}")
   suspend fun deleteQuestion(@Path("id") id:String):HttpData<Object>
  
   @GET("/questions")
   suspend fun getQuestions(@Query("examId") examId: Int, @Query("num") num: Int):HttpData<List<Question>>
  
   @POST("/questions")
   @FormUrlEncoded
   suspend fun postQuestion(@Field("name") name: String, @Field("examId") examId: Int, @Field("num") num: Int, @Field("question") question: String, @Field("a") a: String, @Field("b") b: String, @Field("c") c: String, @Field("d") d: String, @Field("answer") answer: String, @Field("answer_key") answer_key: String):HttpData<List<Question>>
  
   @PUT("/questions/{id}")
   suspend fun putQuestion(@Path("id") id:String, @Field("name") name: String, @Field("examId") examId: Int, @Field("num") num: Int, @Field("question") question: String, @Field("a") a: String, @Field("b") b: String, @Field("c") c: String, @Field("d") d: String, @Field("answer") answer: String, @Field("answer_key") answer_key: String):HttpData<List<Question>>
} 
interface TokenApi{  
   @GET("/token/qiniu/head")
   suspend fun uploadTokenHead(@Query("filename") filename: String):HttpData<QuniuToken>
} 
interface UploadApi{  
   @POST("/upload")
   @FormUrlEncoded
   suspend fun upload(@Field("img") img: File):HttpData<Object>
} 
interface UserApi{  
   @DELETE("/users/{id}")
   suspend fun deleteUser(@Path("id") id:String):HttpData<Object>
  
   @GET("/users/{id}")
   suspend fun getUser(@Path("id") id:String):HttpData<Object>
  
   @POST("/users")
   @FormUrlEncoded
   suspend fun postUser(@Field("id") id: Int):HttpData<Object>
  
   @PUT("/users/{id}")
   suspend fun putUser(@Path("id") id:String, @Field("account") account: String, @Field("qq") qq: Int, @Field("password") password: String, @Field("user_name") user_name: String, @Field("token") token: String, @Field("priv") priv: String, @Field("mail") mail: String, @Field("head_path") head_path: String, @Field("ip") ip: String, @Field("language") language: String, @Field("bot_love") bot_love: Object):HttpData<Object>
} 
