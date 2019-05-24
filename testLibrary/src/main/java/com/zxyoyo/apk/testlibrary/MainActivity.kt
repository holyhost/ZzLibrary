package com.zxyoyo.apk.testlibrary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.zxyoyo.apk.zzlibrary.FormFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var frag: FormFragment = FormFragment.getInstance()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fl,frag)
            .show(frag)
            .commit()
    }
}
