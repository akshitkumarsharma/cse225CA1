package com.example.cse225ca1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class ToolBar : AppCompatActivity() {
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool_bar)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle("ToolBar Example")
        toolbar.setLogo(R.drawable.applelogo)
        //setSupportActionBar(toolbar) //replace toolbar as an ActionBar
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Back Arrow", Toast.LENGTH_LONG).show()
        }


        val pgsBar = findViewById<ProgressBar>(R.id.pBar)
        val pgsBar1 = findViewById<ProgressBar>(R.id.pBarCircular)
        val txtView = findViewById<TextView>(R.id.tView)
        val btn = findViewById<Button>(R.id.btnShow)
        val btnR = findViewById<Button>(R.id.btnReset)

        pgsBar1.visibility = View.INVISIBLE

        btn.setOnClickListener {
            pgsBar1.visibility = View.VISIBLE
            i= pgsBar.progress
            Thread{
                while(i<100){
                    i = i+1
                    Handler(Looper.getMainLooper()).post {
                        pgsBar.progress = i
                        txtView.text = i.toString() + "/" + pgsBar.max
                        if (i == 100) {
                            pgsBar1.visibility = View.INVISIBLE
                        }
                    }
                    try {
                        Thread.sleep(100)
                    }
                    catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }.start()
        }

        btnR.setOnClickListener {
            pgsBar.progress = 0
            txtView.text = 0.toString() + "/" + pgsBar.max
        }



        val btnToast = findViewById<Button>(R.id.btnToast)
        btnToast.setOnClickListener {
            val vg: ViewGroup? = findViewById(R.id.custom_toast)
            val inflater = layoutInflater

            val layout: View = inflater.inflate(R.layout.custom_toast_layout,vg)

            val tv = layout.findViewById<TextView>(R.id.txtVw)
            tv.text = "Custom Toast Notification"

            val toast = Toast(applicationContext)

            toast.setGravity(Gravity.CENTER_VERTICAL, 0 , 100)
            toast.duration = Toast.LENGTH_LONG
            toast.setView(layout)
            toast.show()

        }





    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id:Int = item.itemId
        if(id==R.id.action_settings)
        {
            Toast.makeText(applicationContext, "Settings Menu", Toast.LENGTH_LONG).show()
            return true
        }
        else if(id == R.id.action_email)
        {
            Toast.makeText(applicationContext, "Email", Toast.LENGTH_LONG).show()
            return true
        }
        else if (id == R.id.action_add)
        {
            Toast.makeText(applicationContext, "Add", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }




}