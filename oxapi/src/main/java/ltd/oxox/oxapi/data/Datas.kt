package ltd.oxox.oxapi.data
    data class Exam(var id: Int,var name: String)
data class Question(var name: String,var num: Int,var question: String,var a: String,var b: String,var c: String,var d: String,var answer: String,var answer_key: String)
data class UserData(var id: Int,var logincode: String)
