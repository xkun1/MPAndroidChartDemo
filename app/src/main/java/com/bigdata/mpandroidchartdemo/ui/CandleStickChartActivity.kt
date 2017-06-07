package com.bigdata.mpandroidchartdemo.ui

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bigdata.mpandroidchartdemo.R
import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.CandleData
import com.github.mikephil.charting.data.CandleDataSet
import com.github.mikephil.charting.data.CandleEntry
import kotlinx.android.synthetic.main.activity_candlestick.*
import java.util.*

/**
 * user:kun
 * Date:2017/6/7 or 下午4:06
 * email:hekun@gamil.com
 * Desc: k线图
 */
class CandleStickChartActivity : AppCompatActivity() {
    var mCandleStick: CandleStickChart? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candlestick)
        mCandleStick = CandleStickChart
        initChart()
        initData()
    }

    private fun initData() {

        val yVals1 = ArrayList<CandleEntry>()

        for (i in 0..60 - 1) {
            val mult = (0 + 1).toFloat()
            val `val` = (Math.random() * 40).toFloat() + mult

            val high = (Math.random() * 9).toFloat() + 8f
            val low = (Math.random() * 9).toFloat() + 8f

            val open = (Math.random() * 6).toFloat() + 1f
            val close = (Math.random() * 6).toFloat() + 1f

            val even = i % 2 == 0

            yVals1.add(CandleEntry(i.toFloat(), `val` + high, `val` - low, if (even) `val` + open else `val` - open,
                    if (even) `val` - close else `val` + close))
        }

        val set1 = CandleDataSet(yVals1, "Data Set")
        set1.axisDependency = YAxis.AxisDependency.LEFT
        set1.shadowColor = Color.DKGRAY
        set1.shadowWidth = 0.7f
        set1.decreasingColor = Color.RED
        set1.decreasingPaintStyle = Paint.Style.FILL
        set1.increasingColor = Color.rgb(122, 242, 84)
        set1.increasingPaintStyle = Paint.Style.STROKE
        set1.neutralColor = Color.BLUE

        val data = CandleData(set1)

        mCandleStick!!.data = data
        mCandleStick!!.invalidate()
    }

    private fun initChart() {

        mCandleStick!!.setDrawGridBackground(false)
        //将图表上的最大可见绘制值的数量
        mCandleStick!!.setMaxVisibleValueCount(60)
        val xAxis = mCandleStick!!.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)

        val axisLeft = mCandleStick!!.axisLeft
        axisLeft.labelCount = 7
        axisLeft.setDrawGridLines(false)
        axisLeft.setDrawAxisLine(false)

        val axisRight = mCandleStick!!.axisRight
        axisRight.isEnabled = false
        mCandleStick!!.legend.isEnabled = false
    }
}