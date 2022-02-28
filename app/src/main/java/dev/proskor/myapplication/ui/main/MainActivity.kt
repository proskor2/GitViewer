package dev.proskor.myapplication.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.proskor.myapplication.R
import dev.proskor.myapplication.models.GitRepository
import dev.proskor.myapplication.ui.authorization.AuthFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()

    }
}