package com.siregarmartin.loginwithmvvm.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.siregarmartin.loginwithmvvm.data.repository.AuthRepository
import com.siregarmartin.loginwithmvvm.data.repository.BaseRepository
import com.siregarmartin.loginwithmvvm.ui.auth.AuthViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) ->
                AuthViewModel(repository as AuthRepository) as T
            else -> throw  IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}