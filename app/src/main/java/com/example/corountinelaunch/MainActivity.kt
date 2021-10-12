package com.example.corountinelaunch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.corountinelaunch.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myCoroutineScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.start.setOnClickListener { start_coroutines() }
    }

    fun start_coroutines() {
        Log.i("alain", "start_coroutines  ${Thread.currentThread().name}")
        binding.statusText.text = getString(R.string.starting)

        myCoroutineScope.launch(Dispatchers.IO) { task_coroutine1() }
        myCoroutineScope.launch(Dispatchers.IO) { task_coroutine2() }
        myCoroutineScope.launch(Dispatchers.IO) { task_coroutine3() }

        Log.i("alain", getString(R.string.all_started))
        binding.statusText.text = getString(R.string.all_started)
    }

    suspend fun task_coroutine1() {
        Log.i("alain", "coroutine1  ${Thread.currentThread().name}")
        delay(2000)
        withContext(Dispatchers.Main) {
            Log.i("alain", getString(R.string.finished_coroutine, " 1"))
            binding.statusText.text = getString(R.string.finished_coroutine, " 1")
        }
    }

    suspend fun task_coroutine2() {
        Log.i("alain", "coroutine2  ${Thread.currentThread().name}")
        delay(3000)
        withContext(Dispatchers.Main) {
            Log.i("alain", getString(R.string.finished_coroutine, " 2"))
            binding.statusText.text = getString(R.string.finished_coroutine, " 2")
        }
    }

    suspend fun task_coroutine3() {
        Log.i("alain", "coroutine3  ${Thread.currentThread().name}")
        delay(4000)
        withContext(Dispatchers.Main) {
            Log.i("alain", getString(R.string.finished_coroutine, " 3"))
            binding.statusText.text = getString(R.string.finished_coroutine, " 3")
        }
    }
}
