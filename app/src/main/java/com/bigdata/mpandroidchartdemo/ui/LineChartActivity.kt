package com.bigdata.mpandroidchartdemo.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import com.bigdata.mpandroidchartdemo.R
import com.bigdata.mpandroidchartdemo.view.MyMarkerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.activity_linechart.*
import java.util.*

/**
 * user:kun
 * Date:2017/6/7 or 上午10:31
 * email:hekun@gamil.com
 * Desc: 线形图
 */
class LineChartActivity : AppCompatActivity() {

    var mLineChart: LineChart? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linechart)
        mLineChart = LineChart
        initChart()
        setData(45)
    }

    private fun setData(count: Int) {
        val values = ArrayList<Entry>()
        for (i in 0..count) {
            val d = Math.random() * 100 + 3
            values.add(Entry(i.toFloat(), d.toFloat()))
        }
        var set: LineDataSet? = null
        if (mLineChart!!.data != null &&
                mLineChart!!.data.dataSetCount > 0) {
            set = mLineChart!!.data.getDataSetByIndex(0) as LineDataSet?
            set!!.values = values
            mLineChart!!.getData().notifyDataChanged()
            mLineChart!!.notifyDataSetChanged()
        } else {
            set = LineDataSet(values, "测试线") as LineDataSet?
            /*
            使线条以虚线模式绘制，例如 “ - - - - - ”。
             如果硬件加速关闭，这个工作就可以了。
            请记住，硬件加速提高了性能。
            lineLength线段的长度
            spaceLength之间的空格长度
             */
            set!!.enableDashedLine(10f, 5f, 0f)
            set.enableDashedHighlightLine(10f, 5f, 0f)
            set.setCircleColor(Color.BLACK)
            set.color = Color.BLACK
            set.lineWidth = 2f
            set.circleRadius = 3f
            //将其设置为true可在每个数据圈中绘制一个圆
            set.setDrawCircleHole(true)
            set.valueTextSize = 9f
            //是否填充，默认false
            set.setDrawFilled(true)
            set.fillColor = Color.RED
            val dataSets = ArrayList<ILineDataSet>()
            dataSets.add(set)
            mLineChart!!.data = LineData(dataSets)

        }
    }

    @SuppressLint("NewApi")
    private fun initChart() {
        //设置背景颜色
        mLineChart!!.setBackgroundColor(Color.WHITE)
        //启用时，将渲染边框矩形。如果启用，则无法绘制x轴和y轴的轴线。
        mLineChart!!.setDrawBorders(true)
        //绘制网格背景
        mLineChart!!.setDrawGridBackground(false)
        //设置背景图片
        mLineChart!!.background = Drawable.createFromPath("")


        val myMarkerView = MyMarkerView(this@LineChartActivity, R.layout.custom_marker_view)
        myMarkerView.chartView=mLineChart
        mLineChart!!.marker=myMarkerView

        //设置图表下面的描述
        val description = Description()
        description.text = "LineChart"
        description.textColor = Color.RED
        description.textSize = 20f
        mLineChart!!.description=description
        //x轴
        val xAxis = mLineChart!!.xAxis
        mLineChart!!.defaultValueFormatter
        //x轴的位置在底部
        xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE

        //是否画x轴上的轴线
        xAxis.setDrawAxisLine(true)
        //是否画x轴上的网格线
        xAxis.setDrawGridLines(true)
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
        val axisLeft = mLineChart!!.axisLeft

        axisLeft.setDrawGridLines(true)
        //将其设置为true可绘制零线
        axisLeft.setDrawZeroLine(false)
        //是否画Y轴上的轴线
        axisLeft.setDrawAxisLine(true)
        //是否绘制Y轴的标签(不会影响轴线和网格线)
        axisLeft.setDrawLabels(true)
        //是否画x轴上的网格线
        axisLeft.setDrawGridLines(false)


        // 限制线
        val ll1 = LimitLine(150f, "Upper Limit")
        ll1.lineWidth = 4f
        ll1.enableDashedLine(10f, 10f, 0f)
        ll1.labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP
        ll1.textSize = 10f
        axisLeft.addLimitLine(ll1)
        //x轴动画
        mLineChart!!.animateX(2000)
    }

}