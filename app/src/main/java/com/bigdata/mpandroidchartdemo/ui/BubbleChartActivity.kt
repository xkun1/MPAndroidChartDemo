package com.bigdata.mpandroidchartdemo.ui

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bigdata.mpandroidchartdemo.R
import com.github.mikephil.charting.charts.BubbleChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BubbleData
import com.github.mikephil.charting.data.BubbleDataSet
import com.github.mikephil.charting.data.BubbleEntry
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_bubble.*
import java.util.*

/**
 * user:kun
 * Date:2017/6/7 or 下午3:58
 * email:hekun@gamil.com
 * Desc:气泡图
 */
class BubbleChartActivity : AppCompatActivity() {
    var mBubbleChart: BubbleChart? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bubble)
        mBubbleChart = BubbleChart
        initBubbleChart()
        initData()
    }

    private fun initData() {

        val yVals1 = ArrayList<BubbleEntry>()
        val yVals2 = ArrayList<BubbleEntry>()
        val yVals3 = ArrayList<BubbleEntry>()

        for (i in 0..100 - 1) {
            val `val` = (Math.random() * 50).toFloat()
            val size = (Math.random() * 50).toFloat()

            yVals1.add(BubbleEntry(i.toFloat(), `val`, size))
        }

        for (i in 0..100 - 1) {
            val `val` = (Math.random() * 50).toFloat()
            val size = (Math.random() * 50).toFloat()

            yVals2.add(BubbleEntry(i.toFloat(), `val`, size))
        }

        for (i in 0..100 - 1) {
            val `val` = (Math.random() * 50).toFloat()
            val size = (Math.random() * 50).toFloat()

            yVals3.add(BubbleEntry(i.toFloat(), `val`, size))
        }

        // create a dataset and give it a type
        val set1 = BubbleDataSet(yVals1, "第一条")
        set1.setColor(ColorTemplate.COLORFUL_COLORS[0], 130)
        set1.setDrawValues(true)
        val set2 = BubbleDataSet(yVals2, "第二条")
        set2.setColor(ColorTemplate.COLORFUL_COLORS[1], 130)
        set2.setDrawValues(true)
        val set3 = BubbleDataSet(yVals3, "第三条")
        set3.setColor(ColorTemplate.COLORFUL_COLORS[2], 130)
        set3.setDrawValues(true)

        val dataSets = ArrayList<IBubbleDataSet>()
        dataSets.add(set1)
        dataSets.add(set2)
        dataSets.add(set3)

        val data = BubbleData(dataSets)
        data.setDrawValues(false)
        data.setValueTextSize(8f)
        data.setValueTextColor(Color.WHITE)
        data.setHighlightCircleWidth(1.5f)

        mBubbleChart!!.data = data
        mBubbleChart!!.invalidate()
    }

    private fun initBubbleChart() {

        mBubbleChart!!.setDrawGridBackground(false)

        val xAxis = mBubbleChart!!.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        val axisLeft = mBubbleChart!!.axisLeft
        axisLeft.setDrawGridLines(false)

        val axisRight = mBubbleChart!!.axisRight
        axisRight.setDrawLabels(false)
    }
}