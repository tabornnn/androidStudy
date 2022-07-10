package com.example.androidstudy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class Fragment01 : Fragment() {

    private var cnt = 0
    companion object {
        fun newInstance(count: Int): Fragment? {
            // Fragemnt01 インスタンス生成
            val fragment01 = Fragment01()
            // Bundle にパラメータを設定
            val args = Bundle()
            args.putInt("Counter", count)
            fragment01.arguments = args
            return fragment01
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //LayoutInfrater にFragmentのレイアウトをinflate(挿入)
        val view : View = inflater.inflate(
            R.layout.fragment_01,
            container, false
        )
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments
        if (args != null) {
            var count = args.getInt("Counter")
            val str = "Fragment01: $count"
            cnt = count + 1
            val textView = view.findViewById<TextView>(R.id.textview_01)
            textView.text = str
        }
        val button01: Button = view.findViewById(R.id.push_01)
        button01.setOnClickListener { v ->
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            // BackStackを設定
            fragmentTransaction.addToBackStack(null)
            Fragment02.newInstance(cnt)?.let {
                fragmentTransaction.replace(
                    R.id.fromTo_fragments_container,
                    it
                )
            }
            fragmentTransaction.commit()
        }

        // BackStackで１つ戻す
        val pop01: Button = view.findViewById(R.id.pop_01)
        pop01.setOnClickListener { v ->
            val fragmentManager: FragmentManager = parentFragmentManager
            fragmentManager.popBackStack()
        }
    }
}