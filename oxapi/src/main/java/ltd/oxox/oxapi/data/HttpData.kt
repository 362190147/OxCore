package ltd.oxox.oxapi.data

import java.io.IOException

/**
 *
 */
class HttpData<T>(var code: Int, var msg: String, data: T? ) {
    var data:T?
        get() { if (code!=0){
                throw IOException(msg)
            }
            return field
        }
    init {
        this.data=data
    }

}