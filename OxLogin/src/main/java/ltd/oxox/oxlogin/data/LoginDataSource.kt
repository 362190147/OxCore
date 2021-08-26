package ltd.oxox.oxlogin.data

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ltd.oxox.oxlogin.data.model.LoggedInUser
import top.yumesekai.yumeapi.OxApiManager
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication

            OxApiManager.accountApi.login(username,password).let {
                if(it.code!=0 || it.data == null)
                    return Result.Error(IOException("Error logging in"+it.msg))
                val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), it.data!!.auth)
                return Result.Success(fakeUser)
            }

        } catch (e: Throwable) {
            Log.d("login",e.stackTraceToString())
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}