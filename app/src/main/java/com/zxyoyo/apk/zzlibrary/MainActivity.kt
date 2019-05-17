package com.zxyoyo.apk.zzlibrary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.jetbrains.annotations.TestOnly

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("---------------------------------------------")

        for(i in 1..4)
        println(i)
        println("-------")
        for(i in 4..1)
            println(i)
        println("-=--------------------------------------------")
        Toast.makeText(this,"aaaaa",Toast.LENGTH_LONG).show()
    }
}
