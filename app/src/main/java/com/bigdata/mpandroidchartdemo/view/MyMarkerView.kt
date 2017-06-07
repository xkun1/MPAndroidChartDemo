package com.bigdata.mpandroidchartdemo.view

import android.annotation.SuppressLint
import android.content.Context
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.github.mikephil.charting.utils.Utils
import kotlinx.android.synthetic.main.custom_marker_view.view.*

@SuppressLint("ViewConstructor")
/**
 * user:kun
 * Date:2017/6/7 or 下午1:57
 * email:hekun@gamil.com
 * Desc: 自定义MarKerView
 */
class MyMarkerView(context: Context?, layoutResource: Int) : MarkerView(context, layoutResource) {


    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)

        //is  方法代表java instanceof
        if (e is CandleEntry) {
            val ce = e
            tvContent.text = Utils.formatNumber(ce.high, 0, true)
        } else {
            tvContent.text = Utils.formatNumber(e!!.y, 0, true)
        }
    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-height).toFloat())
    }
}