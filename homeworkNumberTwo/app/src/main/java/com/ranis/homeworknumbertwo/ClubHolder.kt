package com.ranis.homeworknumbertwo

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.ranis.homeworknumbertwo.databinding.FragmentProfileBinding
import com.ranis.homeworknumbertwo.databinding.ItemClubBinding

class ClubHolder(
    private val binding: ItemClubBinding,
    private val onClick: (Club) -> Unit,
) : ViewHolder(binding.root) {

    fun onBind(club: Club) {
        binding.run {
            tvNameFootballClub.text = club.name
            tvNameCountry.text = club.country

            Glide.with(itemView.context)
                .load(club.url)
                .into(ivImage)
            root.setOnClickListener {
                onClick(club)
            }
        }
    }
}