package com.bigdata.mpandroidchartdemo.ui

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bigdata.mpandroidchartdemo.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
import kotlinx.android.synthetic.main.activity_radar.*
import java.util.*

/**
 * user:kun
 * Date:2017/6/7 or 下午4:22
 * email:hekun@gamil.com
 * Desc: 雷达图
 */
class RadarChartChartActivity :AppCompatActivity() {
    var mRadarChart:RadarChart?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radar)
        mRadarChart=RadarChartChart
        initChart()

        initData()
    }

    private fun initData() {

        val mult = 80f
        val min = 20f
        val cnt = 5

        val entries1 = ArrayList<RadarEntry>()
        val entries2 = ArrayList<RadarEntry>()

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (i in 0..cnt - 1) {
            val val1 = (Math.random() * mult).toFloat() + min
            entries1.add(RadarEntry(val1))

            val val2 = (Math.random() * mult).toFloat() + min
            entries2.add(RadarEntry(val2))
        }

        val set1 = RadarDataSet(entries1, "Last Week")
        set1.color = Color.rgb(103, 110, 129)
        set1.fillColor = Color.rgb(103, 110, 129)
        set1.setDrawFilled(true)
        set1.fillAlpha = 180
        set1.lineWidth = 2f
        set1.isDrawHighlightCircleEnabled = true
        set1.setDrawHighlightIndicators(false)

        val set2 = RadarDataSet(entries2, "This Week")
        set2.color = Color.rgb(121, 162, 175)
        set2.fillColor = Color.rgb(121, 162, 175)
        set2.setDrawFilled(true)
        set2.fillAlpha = 180
        set2.lineWidth = 2f
        set2.isDrawHighlightCircleEnabled = true
        set2.setDrawHighlightIndicators(false)

        val sets = ArrayList<IRadarDataSet>()
        sets.add(set1)
        sets.add(set2)

        val data = RadarData(sets)
        data.setValueTextSize(8f)
        data.setDrawValues(false)
        data.setValueTextColor(Color.WHITE)

        mRadarChart!!.data=data
        mRadarChart!!.invalidate()
    }

    private fun initChart() {

        mRadarChart!!.setBackgroundColor(Color.rgb(60, 65, 82))
        //网线的宽度。
        mRadarChart!!.webLineWidth=1f
        // 线条的宽度
        mRadarChart!!.webLineWidthInner=1f
        //设置网的背景颜色
        mRadarChart!!.webColor=Color.LTGRAY
        //设置网的线宽
        mRadarChart!!.webLineWidthInner=1f
        //设置网的线颜色
        mRadarChart!!.webColorInner=Color.RED

        mRadarChart!!.webAlpha=100

        mRadarChart!!.animateXY(1400,1000,Easing.EasingOption.EaseInBack,Easing.EasingOption.EaseInBack)
    }
}