//package com.example.cash_manager
//
//import androidx.lifecycle.ViewModel
//import com.example.cash_manager.login.SignInState
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.update
//
//class SignInViewModel: ViewModel() {
//    private val _state = MutableStateFlow(SignInState())
//
//    val state = _state.asStateFlow()
//
//    fun onSignResult(result: SignInResult) {
//        _state.update {it.copy(
//            isSignInSuccessful = result.data != null,
//            signInError = result.errorMessage
//        ) }
//    }
//    fun resetState(){
//        _state.update { SignInState() }
//    }
//}