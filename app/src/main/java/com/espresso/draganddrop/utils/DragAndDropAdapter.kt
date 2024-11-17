package com.espresso.draganddrop.utils

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.espresso.draganddrop.databinding.FormatItemBinding
import com.espresso.draganddrop.model.FormatModel
import com.espresso.draganddrop.model.TypeModel

class DragAndDropAdapter(
    val type: TypeModel
) : ListAdapter<FormatModel, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return FormatItemViewHolder(
            FormatItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FormatItemViewHolder).bind(getItem(position))
    }

    inner class FormatItemViewHolder(private val binding: FormatItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FormatModel) {
            val context = binding.root.context
            binding.image.setImageDrawable(ContextCompat.getDrawable(context, item.imageId))
            binding.title.text = context.resources.getString(item.titleId)
            binding.root.setOnLongClickListener { view ->
                val data = ClipData.newPlainText("", "")
                val shadowBuilder = View.DragShadowBuilder(view)
                if (view?.startDragAndDrop(data, shadowBuilder, view, 0) == true) {
                    setFormatItemVisibility(view, false)
                }
                false
            }
        }
    }

    fun setFormatItemVisibility(itemView: View, isVisible: Boolean) {
        itemView.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<FormatModel>() {
            override fun areItemsTheSame(oldItem: FormatModel, newItem: FormatModel): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: FormatModel, newItem: FormatModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}