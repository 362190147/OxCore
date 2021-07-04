package ltd.oxox.oxapi
import retrofit2.http.*
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.io.File


import ltd.oxox.oxapi.data.*
interface AdminApi{  
   @POST("/admin/backup")
   @FormUrlEncoded
   suspend fun backup(@Field("logincode") logincode: String, @Field("id") id: Int):HttpData<Object>
  
   @POST("/admin/delete_user")
   @FormUrlEncoded
   suspend fun deleteUser(@Field("logincode") logincode: String, @Field("id") id: Int):HttpData<Object>
  
   @POST("/admin/get_user_by_id")
   @FormUrlEncoded
   suspend fun getUserById(@Field("logincode") logincode: String, @Field("id") id: Int):HttpData<Object>
  
   @POST("/admin/get_user_list")
   @FormUrlEncoded
   suspend fun getUserList(@Field("logincode") logincode: String):HttpData<Object>
  
   @POST("/admin/update_user")
   @FormUrlEncoded
   suspend fun updateUser(@Field("logincode") logincode: String, @Field("id") id: Int, @Field("account") account: String, @Field("priv") priv: String, @Field("head_path") head_path: String):HttpData<Object>
} 
interface BotApi{  
   @GET("/bot/help/{helptype}")
   suspend fun botHelp(@Query("logincode") logincode: String):HttpData<Object>
  
   @GET("/bot/getbot")
   suspend fun getBot(@Query("bot_id") bot_id: String, @Query("logincode") logincode: String):HttpData<Object>
  
   @GET("/bot/bot/getlist")
   suspend fun getBotList(@Query("logincode") logincode: String):HttpData<Object>
  
   @GET("/bot/group/get")
   suspend fun getGroup(@Query("logincode") logincode: String):HttpData<Object>
  
   @GET("/bot/group/getlist")
   suspend fun getGroupList(@Query("logincode") logincode: String):HttpData<Object>
  
   @POST("/bot/head/set")
   @FormUrlEncoded
   suspend fun setBotHead(@Field("bot_id") bot_id: Int, @Field("imgurl") imgurl: String, @Field("logincode") logincode: String):HttpData<Object>
} 
interface QuestionApi{  
   @POST("/question/allupload")
   @FormUrlEncoded
   suspend fun allUploadQuesiton(@Field("logincode") logincode: String, @Field("name") name: String, @Field("questions") questions: String):HttpData<Object>
  
   @POST("/question/delete")
   @FormUrlEncoded
   suspend fun deleteQuestion(@Field("logincode") logincode: String, @Field("name") name: String, @Field("num") num: Int):HttpData<Object>
  
   @GET("/question/testlist")
   suspend fun getExanName():HttpData<List<Exam>>
  
   @GET("/question/get")
   suspend fun getQuestion(@Query("name") name: String, @Query("num") num: Int?):HttpData<List<Question>>
  
   @POST("/question/newtest")
   @FormUrlEncoded
   suspend fun newExan(@Field("logincode") logincode: String, @Field("name") name: String):HttpData<Object>
  
   @POST("/question/upload")
   @FormUrlEncoded
   suspend fun questionUpload(@Field("logincode") logincode: String, @Field("name") name: String, @Field("num") num: Int, @Field("question") question: String, @Field("a") a: String, @Field("b") b: String, @Field("c") c: String, @Field("d") d: String, @Field("answer") answer: String, @Field("answer_key") answer_key: String):HttpData<Object>
} 
interface UploadApi{  
   @POST("/img")
   @FormUrlEncoded
   suspend fun upload(@Field("logincode") logincode: String, @Field("img") img: File):HttpData<Object>
  
   @POST("/upload/head_token")
   @FormUrlEncoded
   suspend fun uploadImage(@Field("name") name: String):HttpData<Object>
  
   @POST("/upload/qiniu")
   @FormUrlEncoded
   suspend fun upload_qiniu(@Field("name") name: String, @Field("image") image: File):HttpData<Object>
  
   @POST("/upload/token/head")
   @FormUrlEncoded
   suspend fun upload_token_head(@Field("name") name: String, @Field("image") image: File):HttpData<Object>
} 
interface UserApi{  
   @POST("/account/check_code")
   @FormUrlEncoded
   suspend fun checkCode(@Field("account") account: String, @Field("code") code: String):HttpData<Object>
  
   @POST("/account/get_user_id")
   @FormUrlEncoded
   suspend fun getUserId(@Field("logincode") logincode: String):HttpData<Object>
  
   @POST("/account/get_user_info")
   @FormUrlEncoded
   suspend fun getUserInfo(@Field("logincode") logincode: String):HttpData<Object>
  
   @POST("/account/login")
   @FormUrlEncoded
   suspend fun login(@Field("account") account: String, @Field("password") password: String):HttpData<UserData>
  
   @POST("/account/register")
   @FormUrlEncoded
   suspend fun register(@Field("account") account: String, @Field("password") password: String, @Field("user_name") user_name: String, @Field("true_name") true_name: String, @Field("code") code: String):HttpData<Object>
  
   @POST("/account/reset_password")
   @FormUrlEncoded
   suspend fun resetPassword(@Field("reset_code") reset_code: String):HttpData<Object>
  
   @POST("/account/send_verify_code")
   @FormUrlEncoded
   suspend fun sendVerifyCode(@Field("account") account: String):HttpData<Object>
} 
