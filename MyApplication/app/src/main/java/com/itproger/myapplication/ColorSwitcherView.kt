package com.itproger.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class ColorSwitcherView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val colors = arrayOf(
        Color.RED,
        Color.GREEN,
        Color.BLUE,
        Color.YELLOW,
        Color.CYAN,
        Color.MAGENTA,
        Color.GRAY,
        Color.BLACK,
        Color.WHITE,
        Color.DKGRAY
    )

    private var currentIndex = 0

    private val paint = Paint()

    init {
        setOnClickListener {
            currentIndex = (currentIndex + 1) % colors.size
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = colors[currentIndex]

        canvas.drawColor(Color.WHITE)
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }

    fun showNextColor() {
        currentIndex = (currentIndex + 1) % colors.size
        invalidate()
    }

    fun showPreviousColor() {
        currentIndex = (currentIndex - 1 + colors.size) % colors.size
        invalidate()
    }

    fun getCurrentColorIndex(): Int {
        return currentIndex
    }
}
