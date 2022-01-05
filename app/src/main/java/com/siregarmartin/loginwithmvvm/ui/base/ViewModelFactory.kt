package com.siregarmartin.loginwithmvvm.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.siregarmartin.loginwithmvvm.data.repository.AuthRepository
import com.siregarmartin.loginwithmvvm.data.repository.BaseRepository
import com.siregarmartin.loginwithmvvm.data.repository.UserRepository
import com.siregarmartin.loginwithmvvm.ui.auth.AuthViewModel
import com.siregarmartin.loginwithmvvm.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) ->
                AuthViewModel(repository as AuthRepository) as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) ->
                HomeViewModel(repository as UserRepository) as T
            else -> throw  IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}