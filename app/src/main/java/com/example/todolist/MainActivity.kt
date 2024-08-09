package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity(),ClickListener {
    var myadapter : CustomListViewAdapterNameAndAge? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myadapter=CustomListViewAdapterNameAndAge( this, itemslistdata,this)
        val listdata:ListView=findViewById(R.id.listview)

        listdata.setAdapter(myadapter)
        val imgbtn=findViewById<ImageView>(R.id.imgbtn)

        imgbtn.setOnClickListener{
            val intent=Intent(this,Activity_two::class.java)
            startActivity(intent)
        }



    }
    companion object{
        var itemslistdata=ArrayList<Dataclass>()
    }

    override fun delete(position:Int) {
        if((itemslistdata?.size?:0)>0 && position >-1){
            itemslistdata.removeAt(position)
            myadapter?.notifyDataSetChanged()

        }
    }

    override fun edit(position: Int) {
        val intent = Intent(
            this@MainActivity,
            Activity_two::class.java
        )
        intent.putExtra("isEditFrom",true)
        intent.putExtra("position", position)
      startActivityForResult(intent, 2)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode==2)
        {
                Log.e("Andorid","sdmsokdskmdkk${itemslistdata}")
            myadapter?.notifyDataSetChanged()

        }
    }
}
