package com.example.football6.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.football6.MAIN
import com.example.football6.R
import kotlinx.android.synthetic.main.fragment_corners.*
import kotlinx.android.synthetic.main.fragment_free_kick.*

class FreeKickFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_free_kick, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext())
            .asGif()
            .load("http://37.27.9.28/6/freekick.gif")
            .into(id_gif_freekick)

        id_button_enter_freekick.setOnClickListener {
            if(id_edittext_goals_free_kick.text.toString().toInt() in 0..20){
                val goals = id_edittext_goals_free_kick.text.toString().toInt()
                if(MAIN.getRecordFreeKickAllTime()<goals){
                    MAIN.setRecordFreeKickAllTime(goals)
                    Toast.makeText(requireContext(),"you have updated the record!", Toast.LENGTH_SHORT).show()
                    id_edittext_goals_free_kick.hint = "past record: ${MAIN.getRecordFreeKickAllTime()}"
                }
                id_edittext_goals_free_kick.setText("")
            }else{
                Toast.makeText(requireContext(),"enter the number of heads from 1 to 20!",Toast.LENGTH_SHORT).show()
            }
        }

        id_edittext_goals_free_kick.hint = "past record: ${MAIN.getRecordFreeKickAllTime()}"

        id_button_to_rv_freekick.setOnClickListener {
            MAIN.replaceToBestPlayerFragment("freekick")
        }

    }


}