package com.zxyoyo.apk.testlocal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.zxyoyo.apk.zzlibrary.FormFragment
import com.zxyoyo.apk.zzlibrary.ItemBean
import com.zxyoyo.apk.zzlibrary.ZzItemView
import kotlinx.android.synthetic.main.activity_container.*

class MainActivity : AppCompatActivity() {

    var fragment: FormFragment = FormFragment.getInstance()
    var aid: Int = R.id.fl_container
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        findViewById<ZzItemView>(R.id.zz_123).setOnClickListener((view: View) -> {
//
//        })
        supportFragmentManager
            .beginTransaction()
            .add(aid,fragment )
            .show(fragment)
            .commit()


        var item1: ItemBean = ItemBean("姓名","小明")
        var item2: ItemBean = ItemBean("爱好","打篮球")
        var item3: ItemBean = ItemBean("出生地","澳门大堂")
        var data: List<ItemBean> = mutableListOf(item1,item2,item3)
        fragment.showResult(data)


    }
}
