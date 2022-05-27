package com.mkao.mvvmsamplewithdatabinding.View.activities

import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity() {
    override fun onResume() {
        super.onResume()
        this.getToolbarInstance()?.let {this.initView(it)}
    }
    private fun initView(toolbar: Toolbar) = setSupportActionBar(toolbar)
    abstract fun getToolbarInstance():Toolbar?
}