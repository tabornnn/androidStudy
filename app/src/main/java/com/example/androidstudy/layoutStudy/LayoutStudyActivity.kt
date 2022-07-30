package com.example.androidstudy.layoutStudy

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.androidstudy.R
import com.example.androidstudy.fragmentStudy.DynamicFragment

class LayoutStudyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_top)

        if (savedInstanceState == null) {
            /**
             * 「トップへ」ボタン押下時の処理
             */
            Log.d("takashii","LayoutStudyActivity.onCreate")
            val toTopButton: Button = findViewById(R.id.toWelcomeButonLayout)
            toTopButton.setOnClickListener { v ->
                finish()
            }

            /**
             * constraintLayoutを生成する処理
             */
            val fragmentManager: FragmentManager = supportFragmentManager
            val dynamicFragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            // インスタンスに対して張り付け方を指定する
            dynamicFragmentTransaction.replace(R.id.constraintFragment, ConstraintFragment())
            dynamicFragmentTransaction.commit()
        }
    }
}