package com.bigdata.mpandroidchartdemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bigdata.mpandroidchartdemo.R
import com.github.mikephil.charting.charts.ScatterChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.ScatterData
import com.github.mikephil.charting.data.ScatterDataSet
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.actvity_scatter.*
import java.util.*

/**
 * user:kun
 * Date:2017/6/7 or 下午3:41
 * email:hekun@gamil.com
 * Desc: 散点图
 */
class ScatterChartActivity : AppCompatActivity() {

    var mScatterChart: ScatterChart? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_scatter)
        mScatterChart = ScatterChart
        initChart()
        initData()
    }

    private fun initData() {


        val yVals1 = ArrayList<Entry>()
        val yVals2 = ArrayList<Entry>()
        val yVals3 = ArrayList<Entry>()

        for (i in 0..100 - 1) {
            val `val` = (Math.random() * 10).toFloat() + 3
            yVals1.add(Entry(i.toFloat(), `val`))
        }

        for (i in 0..100 - 1) {
            val `val` = (Math.random() * 15).toFloat() + 3
            yVals2.add(Entry(i + 0.33f, `val`))
        }

        for (i in 0..100 - 1) {
            val `val` = (Math.random() * 20).toFloat() + 3
            yVals3.add(Entry(i + 0.66f, `val`))
        }

        val set1 = ScatterDataSet(yVals1, "第一条")
        set1.setScatterShape(com.github.mikephil.charting.charts.ScatterChart.ScatterShape.SQUARE)
        set1.color = ColorTemplate.COLORFUL_COLORS[0]
        val set2 = ScatterDataSet(yVals2, "第二条")
        set2.setScatterShape(com.github.mikephil.charting.charts.ScatterChart.ScatterShape.CIRCLE)
        set2.scatterShapeHoleColor = ColorTemplate.COLORFUL_COLORS[3]
        set2.scatterShapeHoleRadius = 3f
        set2.color = ColorTemplate.COLORFUL_COLORS[1]
        val set3 = ScatterDataSet(yVals3, "第三条")
        set3.color = ColorTemplate.COLORFUL_COLORS[2]

        set1.scatterShapeSize = 8f
        set2.scatterShapeSize = 8f
        set3.scatterShapeSize = 8f

        val dataSets = ArrayList<IScatterDataSet>()
        dataSets.add(set1)
        dataSets.add(set2)
        dataSets.add(set3)

        val data = ScatterData(dataSets)

        mScatterChart!!.data = data
        mScatterChart!!.invalidate()
    }

    private fun initChart() {

        mScatterChart!!.setDrawGridBackground(false)
        mScatterChart!!.maxHighlightDistance = 50f
        mScatterChart!!.isDragEnabled = true

        val xAxis = mScatterChart!!.xAxis
        xAxis.position=XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(true)

        val axisLeft = mScatterChart!!.axisLeft
        axisLeft.setDrawGridLines(true)

        val axisRight = mScatterChart!!.axisRight
        axisRight.setDrawGridLines(true)
        axisRight.setDrawLabels(false)
    }
}