package com.example.androidstudy.fragmentStudy

import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.androidstudy.R

class FragmentStudyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_top)

        if (savedInstanceState == null) {

            /**
             * 「トップへ」ボタン押下時の処理
             */
            val toTopButton: Button = findViewById(R.id.toWelcomeButon)
            toTopButton.setOnClickListener { v ->
                finish()
            }
            /**
             * fragmentをdynamic生成する処理
             */
            val fragmentManager: FragmentManager = supportFragmentManager
            val dynamicFragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            // インスタンスに対して張り付け方を指定する
            dynamicFragmentTransaction.replace(R.id.dynamic_container, DynamicFragment())
            dynamicFragmentTransaction.commit()

            /**
             * ボタン押下によって、fragmentに遷移する処理
             */
            val switchButton: Button = findViewById(R.id.switch_button)
            switchButton.setOnClickListener { v ->
                val switchFragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                // BackStackを設定
                switchFragmentTransaction.addToBackStack(null)
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

}