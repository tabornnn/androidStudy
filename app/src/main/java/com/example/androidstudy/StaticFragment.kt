package com.example.androidstudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class StaticFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //LayoutInfrater にFragmentのレイアウトをinflate(挿入)
        val view : View = inflater.inflate(
            R.layout.fragment_static,
            container, false
        )
        val textView : TextView = view.findViewById(R.id.static_fragment)
        textView.setText("staticに生成したfragment")
        return view
    }
}