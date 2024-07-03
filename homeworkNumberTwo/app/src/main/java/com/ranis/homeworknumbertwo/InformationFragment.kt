package com.ranis.homeworknumbertwo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.ranis.homeworknumbertwo.databinding.FragmentInformationBinding

class InformationFragment : Fragment(R.layout.fragment_information) {
    private var binding: FragmentInformationBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInformationBinding.bind(view)

        val id = arguments?.getInt(getString(R.string.id))
        val list = ClubRepository.clubs

        var index: Int? = null
        var club: Club? = null

        for (i in list.indices) {
            if (id?.equals(list[i].id) == true) {
                index = i
            }
        }

        index?.let { club = list[it] }

        binding?.run {
            tvClubName.text = club?.name
            tvCountry.text = getString(R.string.capital).plus(club?.country)
            tvLeague.text = getString(R.string.league).plus(club?.league)
            tvInfo.text = getString(R.string.info).plus(club?.info)
            val urlRes = club?.url
            context?.let {
                Glide.with(it)
                    .load(urlRes)
                    .into(tvLogo)
                backButton.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_informationFragment_to_contactsFragment
                    )
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}