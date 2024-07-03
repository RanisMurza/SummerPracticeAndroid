package com.ranis.homeworknumbertwo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ranis.homeworknumbertwo.databinding.FragmentContactsBinding

class ContactsFragment : Fragment(R.layout.fragment_contacts) {
    private var binding: FragmentContactsBinding? = null

    private var adapter: ClubAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactsBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = ClubAdapter(
            list = ClubRepository.clubs,
            onClick = { club ->
                val bundle = Bundle()
                bundle.putInt("ID_TAG", club.id)
                findNavController().navigate(
                    R.id.action_contactsFragment_to_informationFragment,
                    args = bundle
                )
            }
        )

        binding?.run {
            rvFootballClubs.adapter = adapter
            rvFootballClubs.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}