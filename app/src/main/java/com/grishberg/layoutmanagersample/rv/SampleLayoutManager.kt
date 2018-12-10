package com.grishberg.layoutmanagersample.rv

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Sample LayoutManager
 */
class SampleLayoutManager : RecyclerView.LayoutManager() {
    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT)
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State) {
        val currentView = recycler.getViewForPosition(0)
        addView(currentView)
        measureChildWithMargins(currentView, 0, 0)
        layoutDecorated(currentView, 0, 0, width, height)
    }

    private fun measureChildWithDecorationsAndMargin(child: View, widthSpec: Int, heightSpec: Int) {
        val decorationRect = Rect()
        calculateItemDecorationsForChild(child, decorationRect)
        val lp = child.layoutParams as RecyclerView.LayoutParams
        val newWidthSpec = updateSpecWithExtra(
            widthSpec, lp.leftMargin + decorationRect.left,
            lp.rightMargin + decorationRect.right
        )
        val newHeightSpan = updateSpecWithExtra(
            heightSpec, lp.topMargin + decorationRect.top,
            lp.bottomMargin + decorationRect.bottom
        )
        child.measure(newWidthSpec, newHeightSpan)
    }

    private fun updateSpecWithExtra(spec: Int, start: Int, end: Int): Int {
        if (start == 0 && end == 0) {
            return spec
        }
        val mode = View.MeasureSpec.getMode(spec)
        if (mode == View.MeasureSpec.AT_MOST || mode == View.MeasureSpec.EXACTLY) {

        }
    }
}