package com.example.androidstudy

import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    /**
     * bindingについての基礎知識
     * https://codeforfun.jp/android-studio-how-to-use-view-binding-with-kotlin/
     * actiity_main.xml → ActivityMain + Binding → ActivityMainBinding
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.switch_button)

        if (savedInstanceState == null) {
            // FragmentManagerのインスタンス生成
            val fragmentManager: FragmentManager = supportFragmentManager
            // FragmentTransactionのインスタンスを取得
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            // インスタンスに対して張り付け方を指定する
            fragmentTransaction.replace(R.id.dynamic_container, DynamicFragment())
            // 張り付けを実行
            fragmentTransaction.commit()

            button.setOnClickListener { v ->
                val fragmentManager = supportFragmentManager
                val fragmentTransaction =
                    fragmentManager.beginTransaction()

                // BackStackを設定
                fragmentTransaction.addToBackStack(null)

                // パラメータを設定
                SwitchFragment.newInstance("Fragment")?.let {
                    fragmentTransaction.replace(
                        R.id.switch_container,
                        it
                    )
                }
                fragmentTransaction.commit()
            }
        }
    }

    // アプリのメニューを表示させる
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

}