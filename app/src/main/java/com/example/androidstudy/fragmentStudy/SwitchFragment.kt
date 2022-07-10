package com.example.androidstudy.fragmentStudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidstudy.R

class SwitchFragment : Fragment() {
    companion object {
        fun newInstance(str: String?): Fragment? {
            // Fragemnt01 インスタンス生成
            val fragment = SwitchFragment()
            // Bundle にパラメータを設定
            val barg = Bundle()
            barg.putString("Message", str)
            fragment.setArguments(barg)
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //LayoutInfrater にFragmentのレイアウトをinflate(挿入)
        val view : View = inflater.inflate(
            R.layout.fragment_switch,
            container, false
        )
        return view
    }
}