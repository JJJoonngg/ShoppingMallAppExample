package com.jjjoonngg.parayo.signup

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.jjjoonngg.parayo.api.ParayoApi
import com.jjjoonngg.parayo.api.request.SignUpRequest
import com.jjjoonngg.parayo.api.response.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.codephobia.ankomvvm.lifecycle.BaseViewModel
import org.jetbrains.anko.error

class SignUpViewModel(app: Application) : BaseViewModel(app) {

    val email = MutableLiveData("")
    val name = MutableLiveData("")
    val password = MutableLiveData("")

    suspend fun signUp() {
        val request = SignUpRequest(email.value, password.value, name.value)
        if (isNotValidSignUp(request))
            return

        try {
            val response = requestSignUp(request)
            onSignUpResponse(response)
        } catch (exception: Exception) {
            error("SignUp Error", exception)
            toast("알 수 없는 오류가 발생했습니다.")
        }
    }

    private fun isNotValidSignUp(signUpRequest: SignUpRequest) =
        when {
            signUpRequest.isNotValidEmail() -> {
                toast("이메일 형식이 정확하지 않습니다.")
                true
            }
            signUpRequest.isNotValidPassword() -> {
                toast("비밀번호는 8자 이상 20자 이하로 입력해주세요.")
                true
            }
            signUpRequest.isNotValidName() -> {
                toast("이름은 2자 이상 20자 이하로 입력해주세요.")
                true
            }
            else -> false
        }

    private suspend fun requestSignUp(request: SignUpRequest) =
        withContext(Dispatchers.IO) {
            ParayoApi.instance.signUp(request)
        }

    private fun onSignUpResponse(response: ApiResponse<Void>) {
        if (response.success) {
            toast("회원 가입이 되었습니다. 로그인 후 이용해주세요.")
            finishActivity()
        } else {
            toast(response.message ?: "알 수 없는 오류가 발생했습니다.")
        }
    }
}