package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Signuppage : AppCompatActivity() {
    var isdatapresent:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signuppage)

//here we are creating sharedPreferences obj and editor which will help to store the data

        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val editor=sharedPreferences.edit()

        // here we creating the obj of edit field

        val edfirstname=findViewById<EditText>(R.id.edfirstname)
        val edlastname=findViewById<EditText>(R.id.edlastname)
        val edemail=findViewById<EditText>(R.id.edemail)
        val edpassword=findViewById<EditText>(R.id.edpass)
val nextbtn=findViewById<Button>(R.id.nextbtn)


        nextbtn.setOnClickListener{
            //here we get the input from the user

            val firstname=edfirstname.text.toString().trim()
            val lastname=edlastname.text.toString().trim()
            val email=edemail.text.toString().trim()
            val password=edpassword.text.toString().trim()


            //here we write the data in sp
            editor.putString("firstname",firstname)
            editor.putString("lastname",lastname)
            editor.putString("email",email)
            editor.putString("password",password)

            editor.apply()
            if(firstname=="" && lastname=="" && email=="" && password=="")
            {
                Toast.makeText(this, "Please enter the above field before pressing the button ", Toast.LENGTH_SHORT).show()

            }
            else
            {
                startActivity(Intent(this,MainActivity::class.java))
                isdatapresent= true
                editor.putBoolean("isdatapresent", this.isdatapresent!!)
                editor.apply()
                finish()
                 }
        }



    }
}