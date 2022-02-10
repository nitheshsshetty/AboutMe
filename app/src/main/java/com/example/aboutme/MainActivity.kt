package com.example.aboutme

import android.content.Context
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val done_Button:Button = findViewById(R.id.button)
        val nickname_edit:EditText = findViewById(R.id.nickname_edit)
        val nickname_text:TextView = findViewById(R.id.nickname_text)
        done_Button.setOnClickListener{addnickname(done_Button,nickname_edit,nickname_text)}
        nickname_text.setOnClickListener{Updatetext(done_Button,nickname_edit,nickname_text)}

    }
    private fun addnickname(done:Button,edit:EditText,text:TextView){

        text.text = edit.text
        edit.visibility = View.GONE
        text.visibility = View.VISIBLE
        done.visibility = View.GONE
//code to hide the keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(done.windowToken, 0)
    }

    private fun Updatetext(done:Button,edit:EditText,text:TextView){
        edit.visibility = View.VISIBLE
        text.visibility = View.GONE
        done.visibility = View.VISIBLE
        edit.requestFocus()
//code to Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(edit, 0)

    }

}