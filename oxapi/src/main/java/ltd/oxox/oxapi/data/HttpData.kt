package ltd.oxox.oxapi.data

import java.io.IOException

/**
 *
 */
data class HttpData<T>(var code: Int, var msg: String, var data: T?)