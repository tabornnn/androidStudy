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
            /**
             * fragmentをdynamic生成する処理
             */
            // FragmentManagerのインスタンス生成
            val fragmentManager: FragmentManager = supportFragmentManager
            // FragmentTransactionのインスタンスを取得
            val dynamicFragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            // インスタンスに対して張り付け方を指定する
            dynamicFragmentTransaction.replace(R.id.dynamic_container, DynamicFragment())
            dynamicFragmentTransaction.commit()

            /**
             * ボタン押下によって、fragmentに遷移する処理
             */
            button.setOnClickListener { v ->
                // FragmentTransactionのインスタンスを取得
                val switchFragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

                // BackStackを設定
                switchFragmentTransaction.addToBackStack(null)

                // パラメータを設定
                SwitchFragment.newInstance("Fragment")?.let {
                    switchFragmentTransaction.replace(
                        R.id.switch_container,
                        it
                    )
                }
                switchFragmentTransaction.commit()
            }
            /**
             * fragment間で遷移させるための処理
             */
            val fromToFragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            // counterをパラメータとして設定
            var count: Int = 0
            Fragment01.newInstance(count)
                ?.let {
                    fromToFragmentTransaction.replace(R.id.fromTo_fragments_container, it) }
            // 張り付けを実行
            fromToFragmentTransaction.commit()
        }
    }

    // アプリのメニューを表示させる
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

}