package com.example.androidstudy

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.androidstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /**
     * bindingについての基礎知識
     * https://codeforfun.jp/android-studio-how-to-use-view-binding-with-kotlin/
     * actiity_main.xml → ActivityMain + Binding → ActivityMainBinding
     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // 破棄からのActivity復元を試みている
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // アプリのメニューを表示させる
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

}