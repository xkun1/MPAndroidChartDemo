package com.bigdata.mpandroidchartdemo

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 * user:kun
 * Date:2017/6/7 or 上午10:27
 * email:hekun@gamil.com
 * Desc: 初始化工具类
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
    }
}