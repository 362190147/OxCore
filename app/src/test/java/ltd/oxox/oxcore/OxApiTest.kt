package ltd.oxox.oxcore

import kotlinx.coroutines.runBlocking
import org.junit.Test
import ltd.oxox.oxapi.OxApiManager

class OxApiTest {

    @Test
    fun testLogin(){
        runBlocking{
            OxApiManager.accountApi.login("weige@qq.com","weige").data?.let {
                OxApiManager.auth = it.auth;
                print(OxApiManager.accountApi.getUserInfo().data.toString())
            }
        }
    }

    @Test
    fun testQuestion(){
        runBlocking{

            var  data = OxApiManager.examApi.getExams().data
            if (data!=null)
            {
                OxApiManager.questionApi.getQuestions(data[0].id,0).data?.forEach {
                    print(it.toString())
                }

            }
        }
    }
}