package ltd.oxox.oxapi.data
    data class UserInfo(var id: String,var user_name: String,var account: String,var priv: String,var head_path: String,var mail: String)
data class UserData(var id: Int,var auth: String)
data class Exam(var id: Int,var name: String)
data class VersionInfo(var force: Boolean,var version: String,var version_num: Int,var url: String)
data class Question(var name: String,var num: Int,var question: String,var a: String,var b: String,var c: String,var d: String,var answer: String,var answer_key: String)
data class QuniuToken(var filename: String,var token: String)
