package com.example.cash_manager.SigningUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cash_manager.Tools.Resource
import com.example.cash_manager.data.AuthRepository
import com.example.cash_manager.login.SignInState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel(){
    val _signUpState = Channel<SignInState> ()
    val signUpState = _signUpState.receiveAsFlow()

    fun registerUser(email:String, password:String) = viewModelScope.launch {
        repository.loginUser(email, password).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _signUpState.send(SignInState(isSuccess = "Sign In succesful"))
                }

                is Resource.Loading -> {
                    _signUpState.send(SignInState(isLoading = true))

                }

                is Resource.Error -> {
                    _signUpState.send(SignInState(isError = result.message))

                }
            }
        }
        }
    }
