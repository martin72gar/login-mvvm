package com.siregarmartin.loginwithmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.siregarmartin.loginwithmvvm.data.UserPreferences
import com.siregarmartin.loginwithmvvm.ui.auth.AuthActivity
import com.siregarmartin.loginwithmvvm.ui.home.HomeActivity
import com.siregarmartin.loginwithmvvm.ui.startNewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userPreferences = UserPreferences(this)

        userPreferences.authToken.asLiveData().observe(this, Observer {
            val activity = if (it == null) AuthActivity::class.java else HomeActivity::class.java
            startNewActivity(activity)
        })
    }
}