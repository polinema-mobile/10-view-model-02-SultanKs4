package id.putraprima.mvvmlogin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.putraprima.mvvmlogin.models.User

class LoginViewModel : ViewModel() {
    var user: User = User()
    private var userDummy: User = User()
    private var loggedIn: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private var userMutable = MutableLiveData<User>()
    private var emailError: MutableLiveData<String> = MutableLiveData<String>()
    private var passwordError: MutableLiveData<String> = MutableLiveData<String>()
    val loggedLiveData: LiveData<Boolean>
        get() = loggedIn
    val userLiveData: LiveData<User>
        get() = userMutable
    val emailErrorLiveData: LiveData<String>
        get() = emailError
    val passwordErrorLiveData: LiveData<String>
        get() = passwordError

    init {
        loggedIn.value = false
        userMutable.value = User()
        userDummy.email = "sultan@gmail.com"
        userDummy.password = "loremipsum"
    }

    fun loginCheck() {
        if (user.email.isEmpty()) {
            emailError.value = "Email tidak boleh kosong"
        }
        if (user.password.isEmpty()) {
            passwordError.value = "Password tidak boleh kosong"
        }
        if (user.email.isNotEmpty() || user.password.isNotEmpty()) {
            if (user.email.equals(userDummy.email) and user.password.equals(userDummy.password)) {
                userMutable.value = user
                loggedIn.value = true
            } else {
                emailError.value = "Email tidak cocok"
                passwordError.value = "Password tidak cocok"
            }
        }
    }
}