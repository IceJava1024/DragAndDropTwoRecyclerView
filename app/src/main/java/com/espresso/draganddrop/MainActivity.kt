package com.espresso.draganddrop

import android.os.Bundle
import android.view.DragEvent
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.espresso.draganddrop.databinding.ActivityMainBinding
import com.espresso.draganddrop.model.FormatModel
import com.espresso.draganddrop.model.TypeModel
import com.espresso.draganddrop.utils.DragAndDropAdapter
import com.espresso.draganddrop.utils.DragAndDropItemDecoration
import com.espresso.draganddrop.viewmodel.DragAndDropViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: DragAndDropViewModel by viewModels()

    private val commonFormatData = FormatModel.entries.filter { it.formatType == TypeModel.COMMON }
    private val otherFormatData = FormatModel.entries.filter { it.formatType == TypeModel.OTHER }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        viewModel.setDraggingState(false)

        listOf(
            binding.commonFormatRecyclerView to TypeModel.COMMON,
            binding.otherFormatRecyclerView to TypeModel.OTHER
        ).map {
            val (view, type) = it
            view.addItemDecoration(
                DragAndDropItemDecoration(
                    resources = view.context.resources,
                    columnCount = COLUMN_COUNT
                )
            )
            view.layoutManager = GridLayoutManager(view.context, COLUMN_COUNT)
            view.adapter = DragAndDropAdapter(type).apply {
                submitList(
                    if (type == TypeModel.COMMON) {
                        commonFormatData
                    } else {
                        otherFormatData
                    }
                )
            }
            view.setOnDragListener(dragListener)
        }
    }

    private val dragListener = View.OnDragListener { targetView, event ->
        if (targetView == null || targetView !is RecyclerView || event == null) {
            false
        }

        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {

            }
            DragEvent.ACTION_DRAG_ENDED -> {

            }
        }
        true
    }

    companion object {
        const val COLUMN_COUNT: Int = 3
    }
}