package com.example.androidstudy.fragmentStudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.androidstudy.R


class Fragment02 : Fragment() {

    private var cnt = 0
    companion object {
        fun newInstance(count: Int): Fragment? {
            // Fragemnt02 インスタンス生成
            val fragment02 = Fragment02()
            // Bundle にパラメータを設定
            val args = Bundle()
            args.putInt("Counter", count)
            fragment02.arguments = args
            return fragment02
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //LayoutInfrater にFragmentのレイアウトをinflate(挿入)
        val view : View = inflater.inflate(
            R.layout.fragment_fromto02,
            container, false
        )
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments
        if (args != null) {
            var count = args.getInt("Counter")
            val str = "Fragment02: $count"
            cnt = count + 1
            val textView = view.findViewById<TextView>(R.id.textview_02)
            textView.text = str
        }
        val button02: Button = view.findViewById(R.id.push_02)
        button02.setOnClickListener { v ->
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            // BackStackを設定
            fragmentTransaction.addToBackStack(null)
            Fragment01.newInstance(cnt)?.let {
                fragmentTransaction.replace(
                    R.id.fromTo_fragments_container,
                    it
                )
            }
            fragmentTransaction.commit()
        }

        // BackStackで１つ戻す
        val pop02: Button = view.findViewById(R.id.pop_02)
        pop02.setOnClickListener { v ->
            val fragmentManager: FragmentManager = parentFragmentManager
            fragmentManager.popBackStack()
        }
    }
}