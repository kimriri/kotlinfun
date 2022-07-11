package com.programmers.kotlinfun

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import com.programmers.kotlinfun.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class Coroutine : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)


        CoroutineScope(Dispatchers.Default).async {

            val deferred = async {
                delay(5000)
                2500
            }
            val deferred2 = async {
                delay(500)
                100
            }
            Log.d("CoroutineScope"
                ,"${deferred.await() + deferred2.await()}")
        }

        suspend fun subRoutine() {
            for (i in 0..10) {
                Log.d("subRoutine", "$i")
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            subRoutine()
        }
    }



}