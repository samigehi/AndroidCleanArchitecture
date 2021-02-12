package com.dubizzle.classified.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dubizzle.classified.R
import com.dubizzle.classified.listeners.ItemClickListener
import com.dubizzle.core.domain.models.Classified


class ClassifiedAdapter(
    var classifieds: ArrayList<Classified>,
    var listener: ItemClickListener<Classified?>?
) : RecyclerView.Adapter<ClassifiedHolder>() {
    val backup = ArrayList<Classified>()

    private val diffCallback = object : DiffUtil.ItemCallback<Classified>() {

        override fun areItemsTheSame(oldItem: Classified, newItem: Classified): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: Classified, newItem: Classified): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassifiedHolder {
        return ClassifiedHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_classified, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return classifieds.size
    }

    override fun onBindViewHolder(holder: ClassifiedHolder, position: Int) {
        holder.bind(classifieds[position], listener)

    }

    fun add(classified: Classified) {
        classifieds.add(classified)
    }

    fun addAll(list: Collection<Classified>) {
        classifieds.clear()
        classifieds.addAll(list)
        notifyDataSetChanged()
    }

    fun submitList(newListData: List<Classified>?) {
        differ.submitList(newListData)
        notifyDataSetChanged()
    }

    fun filter(query: String?) {
        query?.let {
            if (backup.isEmpty())
                backup.addAll(classifieds)

            classifieds.clear()
            for (classified in backup) {
                if (classified.search(it))
                    classifieds.add(classified)
            }

            notifyDataSetChanged()
        }
    }


}