package com.ranis.homeworknumbertwo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ranis.homeworknumbertwo.databinding.ItemClubBinding

class ClubAdapter(
    private val list: List<Club>,
    private val onClick: (Club) -> Unit,
) : RecyclerView.Adapter<ClubHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClubHolder = ClubHolder(
        binding = ItemClubBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onClick = onClick
    )

    override fun onBindViewHolder(holder: ClubHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}