package com.example.todolist

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity


class Activity_two : AppCompatActivity() {
    var editq:String?=null
    var editd:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
     val addbtn=findViewById<Button>(R.id.AddBtn)
     val edTitle=findViewById<EditText>(R.id.EDtitletext)
     val edDescriptor=findViewById<EditText>(R.id.EDdescriptiontext)

        val intent = getIntent()
        val iseditfrom = intent.getBooleanExtra("isEditFrom",false)
        val position = intent.getIntExtra("position",-1)
        if(iseditfrom==true && position >-1)
        {
            val item = MainActivity.itemslistdata.get(position)
            editq=   edTitle.setText(item.title).toString()
            editd=    edDescriptor.setText(item.descr).toString()
            addbtn.setText("Save")
        }

        addbtn.setOnClickListener{

            if(edTitle?.length()!! >0 && edDescriptor?.length()!!>0)
            {
                Toast.makeText(this, "Its a toast!", Toast.LENGTH_SHORT).show()

            }

            if(iseditfrom){
                MainActivity.itemslistdata.set(position,Dataclass(edTitle.text.toString() , edDescriptor.text.toString()))
                setResult(2)
                finish()
            }else{
                MainActivity.itemslistdata.add(Dataclass(edTitle.text.toString() , edDescriptor.text.toString()))
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }


        }


    }
}