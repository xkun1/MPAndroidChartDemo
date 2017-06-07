package com.bigdata.mpandroidchartdemo.ui

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import com.bigdata.mpandroidchartdemo.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_piechart.*
import java.util.*

/**
 * user:kun
 * Date:2017/6/7 or 下午2:47
 * email:hekun@gamil.com
 * Desc: 饼装图
 */
class PieCharActivity : AppCompatActivity() {
    var mPieChart: PieChart? = null
    var mParties = arrayOf("Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H", "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P", "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X", "Party Y", "Party Z")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_piechart)
        mPieChart = PieChart
        initPieChart()
        initData(5)
    }


    private fun initData(count: Int) {


        val mult = 100

        val entries = ArrayList<PieEntry>()

        for (i in 0..count - 1) {
            entries.add(PieEntry((Math.random() * mult + mult / 5).toFloat(), mParties[i % mParties.size]))
        }

        val dataSet = PieDataSet(entries, "Election Results")
        dataSet.sliceSpace = 3f
        dataSet.selectionShift = 5f

        // add a lot of colors

        val colors = ArrayList<Int>()

        for (c in ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c)

        for (c in ColorTemplate.JOYFUL_COLORS)
            colors.add(c)

        for (c in ColorTemplate.COLORFUL_COLORS)
            colors.add(c)

        for (c in ColorTemplate.LIBERTY_COLORS)
            colors.add(c)

        for (c in ColorTemplate.PASTEL_COLORS)
            colors.add(c)

        colors.add(ColorTemplate.getHoloBlue())

        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
        mPieChart!!.data = data

        // undo all highlights
        mPieChart!!.highlightValues(null)

        mPieChart!!.invalidate()

    }

    private fun initPieChart() {
        //如果启用，则PieChart中的值将以百分比绘制
        mPieChart!!.setUsePercentValues(true)
        //取消图表描述
        mPieChart!!.description.isEnabled = false
        //图表偏移
        mPieChart!!.setExtraOffsets(5f, 10f, 5f, 10f)

        mPieChart!!.centerText = "小坤"
        mPieChart!!.setCenterTextSize(30f)
        mPieChart!!.setDrawCenterText(true)
        mPieChart!!.rotationAngle = 0f
        // enable rotation of the chart by touch
        mPieChart!!.isRotationEnabled = true
        mPieChart!!.isHighlightPerTapEnabled = true

        mPieChart!!.animateY(1400, Easing.EasingOption.EaseInOutQuad)
    }

}