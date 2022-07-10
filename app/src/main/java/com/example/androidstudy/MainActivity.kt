package com.example.androidstudy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidstudy.fragmentStudy.FragmentStudyActivity


class MainActivity : AppCompatActivity() {

    /**
     * bindingについての基礎知識
     * https://codeforfun.jp/android-studio-how-to-use-view-binding-with-kotlin/
     * actiity_main.xml → ActivityMain + Binding → ActivityMainBinding
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentButton: Button = findViewById(R.id.fragmentButton)
        fragmentButton.setOnClickListener { v ->
            val intent = Intent(application, FragmentStudyActivity::class.java)
            startActivity(intent)
        }
    }

}