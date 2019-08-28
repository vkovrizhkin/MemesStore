package com.kovrizhkin.memesstore.utils

import androidx.recyclerview.widget.DiffUtil
import com.kovrizhkin.memesstore.model.memes.MemInfo

class MemesDiffUtil(private val oldList: List<MemInfo>, private val newList: List<MemInfo>) :
    DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}