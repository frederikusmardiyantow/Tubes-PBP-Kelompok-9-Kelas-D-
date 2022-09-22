package com.example.ugd3_d_0659

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome : Fragment() {
    private var username : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let{
            username = it.getString("username").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getNama : TextView = view.findViewById(R.id.nama)!!
        getNama.setText(username)
//        if (arguments != null) {
//            val massege : String? = getArguments()?.getString(EXTRA_TITLE)
//            println("isi extra : "+ EXTRA_TITLE)
//            println("isi massage : "+massege)
//            val getNama : TextView = view.findViewById(R.id.nama)
//            getNama.setText("haloooo")
//        }


    }


}