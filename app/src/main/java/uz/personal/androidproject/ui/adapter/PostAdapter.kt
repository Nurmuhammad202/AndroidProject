package uz.personal.androidproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.personal.androidproject.databinding.PostItemAdapterBinding
import uz.personal.domain.model.PostUseCaseData

class PostAdapter (
    private val list: List<PostUseCaseData>,
    private val onItemMainClickListener: OnItemMainClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            PostItemAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            holder.binding.apply {
                txtTitle.text = list[position].title
                txtText.text = list[position].body
                itemCard.setOnClickListener {
                    onItemMainClickListener.onItemMainClickListener(list[position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(val binding: PostItemAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface OnItemMainClickListener {
        fun onItemMainClickListener(userMainPageData: PostUseCaseData)
    }
}