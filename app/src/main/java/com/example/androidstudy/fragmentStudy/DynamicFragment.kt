package com.example.androidstudy.fragmentStudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidstudy.R

class DynamicFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //LayoutInfrater にFragmentのレイアウトをinflate(挿入)
        val view : View = inflater.inflate(
            R.layout.fragment_dynamic,
            container, false
        )
        val textView : TextView = view.findViewById(R.id.dynamic_fragment)
        textView.setText("dynamicに生成したfragment")
        return view
    }
}