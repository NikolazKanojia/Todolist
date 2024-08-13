package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


import androidx.appcompat.app.AppCompatActivity
class Loginpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)

// here we get the data from sharedprefrence
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        val data=sharedPreferences.getBoolean("isdatapresent", false)
        if(data)
        {
            startActivity(Intent(this,MainActivity::class.java))

        }

//here we are make obj of the edit field
        val edemailtxt=findViewById<EditText>(R.id.Edemail)
        val edpasstxt=findViewById<EditText>(R.id.Edpass)
        val forgotpass=findViewById<TextView>(R.id.Tvforgotpass)
        val loginbtn=findViewById<Button>(R.id.Loginbtn)
        val createbtn=findViewById<Button>(R.id.btnCreateFreeAcc)

        //here we get the input from the user and storing it to a var





        //login btn work is done is here
        loginbtn.setOnClickListener{
            var edemail=edemailtxt.text.toString().trim()
            var edpass=edpasstxt.text.toString().trim()

            val emailid=sharedPreferences.getString("email",null)
            val pass=sharedPreferences.getString("password",null)


                        if((edemail.equals(emailid) && edpass.equals(pass)))
            {
                startActivity(Intent(this,MainActivity::class.java))

            }
            else if(edemail==null && edpass==null)
            {
                Toast.makeText(this,"please enter the above fields before pressing the button",Toast.LENGTH_LONG).show()

            }
            else
            {
                Toast.makeText(this,"Please enter the valid Credentials",Toast.LENGTH_LONG).show()
            }

        }
        //create a free account work is done here
        createbtn.setOnClickListener{
            startActivity(Intent(this,Signuppage::class.java))
        }

        //Forgotpassword work is done here
        forgotpass.setOnClickListener{
            startActivity(Intent(this,Signuppage::class.java))
        }



        }
    }
