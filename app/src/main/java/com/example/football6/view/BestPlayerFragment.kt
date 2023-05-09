package com.example.football6.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.football6.R
import com.example.football6.adapter.PlayerAdapter
import com.example.football6.viewmodel.BestPlayerViewModel
import kotlinx.android.synthetic.main.fragment_best_player.*

class BestPlayerFragment : Fragment() {

    lateinit var recyclerViewPlayer: RecyclerView
    lateinit var adapterPlayer: PlayerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_best_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val valueToKey = requireArguments().getString("key")!!

        val bestPlayerViewModel = ViewModelProvider(this)[BestPlayerViewModel::class.java]

        recyclerViewPlayer = id_rv_best_player
        adapterPlayer = PlayerAdapter(requireContext())
        recyclerViewPlayer.adapter = adapterPlayer

        when(valueToKey){
            "corners" -> { bestPlayerViewModel.getPlayerCorners() }
            "freekick" -> { bestPlayerViewModel.getPlayerFreeKick() }
            "penalty" -> { bestPlayerViewModel.getPlayerPenalty() }
        }

        bestPlayerViewModel.Player.observe(viewLifecycleOwner){ list->
            list.body().let{adapterPlayer.setList(it!!)}
        }


    }


}