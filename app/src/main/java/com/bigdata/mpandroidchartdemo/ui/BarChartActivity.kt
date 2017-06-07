package com.bigdata.mpandroidchartdemo.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import com.bigdata.mpandroidchartdemo.R
import com.bigdata.mpandroidchartdemo.view.MyMarkerView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_barchart.*
import java.util.*

/**
 * user:kun
 * Date:2017/6/7 or 下午2:15
 * email:hekun@gamil.com
 * Desc: 条形图
 */
class BarChartActivity : AppCompatActivity() {

    var mBarChart: BarChart? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barchart)
        mBarChart = BarChart
        initBarChat()
        initData(20)
    }

    private fun initData(count: Int) {
        val start = 1f

        val yVals1 = ArrayList<BarEntry>()
        var i = start.toInt()
        while (i < start + count.toFloat() + 1f) {
            val mult = 50 + 1
            val `val` = (Math.random() * mult).toFloat()
            yVals1.add(BarEntry(i.toFloat(), `val`))
            i++
        }
        var dataSet: BarDataSet? = null
        if (mBarChart!!.data != null &&
                mBarChart!!.data.dataSetCount > 0) {
            dataSet = mBarChart!!.data.getDataSetByIndex(0) as BarDataSet?
            dataSet!!.values = yVals1
            mBarChart!!.data.notifyDataChanged()
            mBarChart!!.notifyDataSetChanged()
        } else {
            dataSet = BarDataSet(yVals1, "2017")
            dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
            val dataSets = ArrayList<IBarDataSet>()
            dataSets.add(dataSet)

            val data = BarData(dataSets)
            data.setValueTextSize(10f)
            data.barWidth = 0.9f
            mBarChart!!.data = data
        }

    }

    @SuppressLint("NewApi")
    private fun initBarChat() {
        //设置背景颜色
        mBarChart!!.setBackgroundColor(Color.WHITE)
        //启用时，将渲染边框矩形。如果启用，则无法绘制x轴和y轴的轴线。
        mBarChart!!.setDrawBorders(false)
        //绘制网格背景
        mBarChart!!.setDrawGridBackground(false)

        val myMarkerView = MyMarkerView(this@BarChartActivity, R.layout.custom_marker_view)
        myMarkerView.chartView = mBarChart
        mBarChart!!.marker = myMarkerView

        //设置图表下面的描述
        val description = Description()
        description.text = "BarChart"
        description.textColor = Color.RED
        description.textSize = 20f
        mBarChart!!.description = description
        //x轴
        val xAxis = mBarChart!!.xAxis
        mBarChart!!.defaultValueFormatter
        //x轴的位置在底部
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        //是否画x轴上的轴线
        xAxis.setDrawAxisLine(true)
        //是否画x轴上的网格线
        xAxis.setDrawGridLines(false)
        //是否绘制x轴上的标签(不会影响轴线和网格线)
        xAxis.setDrawLabels(true)
        //是否绘制x轴的标签(不会影响轴线和网格线)
        xAxis.setDrawLabels(true)
        //设置轴线的颜色
        xAxis.axisLineColor = Color.BLACK
        //轴线的宽度
        xAxis.axisLineWidth = 2f
        /*
        设置此轴的自定义最大值。 如果设置，则不会计算此值自动取决于
        提供的数据.使用resetAxisMaxValue（）来撤销此操作。
         */
        xAxis.axisMaximum = 10f
        //网格颜色
        xAxis.gridColor = Color.BLACK
        //左边的Y轴
        val axisLeft = mBarChart!!.axisLeft
        val axisRight = mBarChart!!.axisRight
        axisRight.setDrawTopYLabelEntry(false)
        axisRight.setDrawGridLines(false)
        axisRight.setDrawLabels(false)
        //将其设置为true可绘制零线
        axisLeft.setDrawZeroLine(false)
        //是否画Y轴上的轴线
        axisLeft.setDrawAxisLine(true)
        //是否绘制Y轴的标签(不会影响轴线和网格线)
        axisLeft.setDrawLabels(true)
        //是否画x轴上的网格线
        axisLeft.setDrawGridLines(false)
        //x轴动画
        mBarChart!!.animateX(2000)
    }

}