package dev.proskor.myapplication.ui.authorization

import android.widget.Toast
import androidx.lifecycle.ViewModel
import dev.proskor.myapplication.ui.main.MainActivity

class AuthViewModel : ViewModel() {
    fun hello(){
        Toast.makeText(MainActivity().applicationContext, "Hello", Toast.LENGTH_LONG).show()
    }
}