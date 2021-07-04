package ltd.oxox.oxcore

import kotlinx.coroutines.runBlocking
import org.junit.Test
import top.yumesekai.yumeapi.OxApiManager

class OxApiTest {

    @Test
    fun testLogin(){
        runBlocking{
            var  data = OxApiManager.Instance.questionApi.getExanName().data
            if (data!=null)
            {
                OxApiManager.Instance.questionApi.getQuestion(data[0].name,null).data?.forEach {
                    print(it.toString())
                }

            }
        }
    }
}