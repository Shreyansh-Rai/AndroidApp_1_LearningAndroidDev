package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    lateinit var nicknameInput:EditText
//    lateinit var nicknameOutput : TextView
//    lateinit var done : Button
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        nicknameInput = findViewById<EditText>(R.id.nickname_edit)
//        nicknameOutput = findViewById<TextView> (R.id.nickname_box)
//        done = findViewById<Button>(R.id.nickname_button)
        binding.nicknameButton.setOnClickListener{
            nicknameedit(it)
        }
    }

    private fun nicknameedit(view:View) {
        binding.apply{
            invalidateAll()
            nicknameBox.text = binding.nicknameEdit.text
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameBox.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
//steps to apply binding:
/*
1) Firstly go to the android part of the gradle build and add
    dataBinding {
        enable = true
    }
2) make sure that the entire activity_main.xml has been enclosed in a set of layout tags
    and the xmlns has been pasted in the same
3) now go to the MainActivity.kt file and make a variable called lateinit var binding
    in onCreate make
    binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
    //do not worry auto correct will help you there
    now what you need to do is access all the buttons and views and shit using binding.XYZ
4) In summary Change dataBinding status in gradle -> wrap xml in layout tag -> make binding variable
    in the kt file and then finally you may use binding upon
    binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)

 */