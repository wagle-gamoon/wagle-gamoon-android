package com.codelap.waglegamoon.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codelap.waglegamoon.domain.model.PostStudyRecruit
import com.codelap.waglegamoon.databinding.ItemPostStudyRecruitBinding
import com.codelap.waglegamoon.domain.model.PostResponseDto

class StudyRecruitAdapter(private val listener: PostClickListener) : RecyclerView.Adapter<StudyRecruitAdapter.StudyRecruitViewHolder>() {
    private val items = mutableListOf<PostResponseDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudyRecruitViewHolder {
        return StudyRecruitViewHolder.from(parent)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: StudyRecruitViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    fun update(posts: List<PostResponseDto>) {
        val diffUtil = StudyRecruitDiffUtil(items, posts)
        val result = DiffUtil.calculateDiff(diffUtil)
        items.clear()
        items.addAll(posts)
        result.dispatchUpdatesTo(this)
    }

    class StudyRecruitDiffUtil(
        private val oldItems: List<PostResponseDto>,
        private val newItems: List<PostResponseDto>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldItems.size

        override fun getNewListSize(): Int = newItems.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldItems[oldItemPosition]
            val newItem = newItems[newItemPosition]
            return oldItem.postId == newItem.postId
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItems[oldItemPosition] == newItems[newItemPosition]
        }

    }

    class StudyRecruitViewHolder(private val binding: ItemPostStudyRecruitBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostResponseDto, listener: PostClickListener) {
            binding.postResponseDto = item
            binding.listener = listener
        }

        companion object {
            fun from(parent: ViewGroup): StudyRecruitViewHolder {
                return StudyRecruitViewHolder(
                    ItemPostStudyRecruitBinding.inflate(LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }
}