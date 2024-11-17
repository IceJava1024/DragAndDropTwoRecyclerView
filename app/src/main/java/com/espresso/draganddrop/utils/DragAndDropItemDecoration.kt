package com.espresso.draganddrop.utils

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.espresso.draganddrop.R

class DragAndDropItemDecoration(
    resources: Resources,
    columnCount: Int
) : RecyclerView.ItemDecoration() {

    private val screenWidth = resources.displayMetrics.widthPixels
    private val recyclerViewWidth = screenWidth -
            resources.getDimensionPixelSize(R.dimen.app_padding) -
            resources.getDimensionPixelSize(R.dimen.custom_area_layout_padding)
    private val formatItemWidth = resources.getDimensionPixelSize(R.dimen.format_item_width)
    private val formatItemMaxWidth = recyclerViewWidth / columnCount
    private val verticalOffset =
        resources.getDimensionPixelSize(R.dimen.format_item_vertical_offset)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = if (formatItemMaxWidth > formatItemWidth) {
            (formatItemMaxWidth - formatItemWidth) / 2
        } else {
            0
        }
        outRect.top = verticalOffset
        outRect.bottom = verticalOffset
    }
}
