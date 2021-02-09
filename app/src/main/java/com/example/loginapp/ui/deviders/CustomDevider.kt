package com.example.loginapp.ui.deviders

import android.R
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CustomDevider : RecyclerView.ItemDecoration {
    private val ATTRS = intArrayOf(R.attr.listDivider)

    private var divider: Drawable? = null

    constructor(context: Context) {
        val styledAttributes: TypedArray = context.obtainStyledAttributes(ATTRS)
        divider = styledAttributes.getDrawable(0)
        styledAttributes.recycle()
    }

    /**
     * Custom divider will be used
     */
    constructor(context: Context?, resId: Int) {
        divider = context?.let { ContextCompat.getDrawable(it, resId) }
    }
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val paint = Paint()
        paint.setColor(Color.BLACK)
        paint.setStrokeWidth(12f)
        paint.alpha = 80
        val childCount = parent.childCount
        //step 2
        for (i in 0 until childCount step 1) {
            val child: View = parent.getChildAt(i)
            val params = child.getLayoutParams() as RecyclerView.LayoutParams
            val top: Int = child.getBottom() + params.bottomMargin //+10
            val bottom = divider!!.intrinsicHeight + top
            val left = child.getLeft() + params.leftMargin +120
            val right = child.getRight() + params.rightMargin -10
            c.drawLine(child.getLeft().toFloat(), child.getBottom().toFloat()+7, left.toFloat(), child.getBottom().toFloat()+7,paint)
            divider!!.setBounds(left, top, right, bottom)
            divider!!.draw(c)
        }
    }
}