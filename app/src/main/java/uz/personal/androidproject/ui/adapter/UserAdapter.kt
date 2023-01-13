package uz.personal.androidproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.personal.androidproject.databinding.ItemMainUserBinding
import uz.personal.domain.model.UserPageData

class UserAdapter(
    private val list: List<UserPageData>,
    private val onItemMainClickListener: OnItemMainClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            ItemMainUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            holder.binding.apply {
                txtUsername.text = list[position].username
                txtName.text = list[position].name
                mainLayout.setOnClickListener {
                    onItemMainClickListener.onItemMainClickListener(list[position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(val binding: ItemMainUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface OnItemMainClickListener {
        fun onItemMainClickListener(userMainPageData: UserPageData)
    }
}