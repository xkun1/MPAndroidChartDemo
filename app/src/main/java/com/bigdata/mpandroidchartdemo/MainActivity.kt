package com.bigdata.mpandroidchartdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bigdata.mpandroidchartdemo.ui.BarChartActivity
import com.bigdata.mpandroidchartdemo.ui.LineChartActivity
import com.bigdata.mpandroidchartdemo.ui.PieCharActivity
import com.blankj.utilcode.util.ActivityUtils
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 使用Kotlin来开发
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //线形图
        LineChart.setOnClickListener { ActivityUtils.startActivity(this@MainActivity, LineChartActivity::class.java) }
        //条形图
        BarChart.setOnClickListener { ActivityUtils.startActivity(this@MainActivity, BarChartActivity::class.java) }
        //饼装图
        PieChart.setOnClickListener { ActivityUtils.startActivity(this@MainActivity, PieCharActivity::class.java) }
    }
}
