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
import kotlinx.android.synthetic.main.fragment_penalty.*

class PenaltyFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_penalty, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext())
            .asGif()
            .load("http://37.27.9.28/6/penalty.gif")
            .into(id_gif_penalty)

        id_button_enter_penalty.setOnClickListener {
            if(id_edittext_goals_penalty.text.toString().toInt() in 0..20){
                val goals = id_edittext_goals_penalty.text.toString().toInt()
                if(MAIN.getRecordPenaltyAllTime()<goals){
                    MAIN.setRecordPenaltyAllTime(goals)
                    Toast.makeText(requireContext(),"you have updated the record!",Toast.LENGTH_SHORT).show()
                    id_edittext_goals_penalty.hint = "past record: ${MAIN.getRecordPenaltyAllTime()}"
                }
                id_edittext_goals_penalty.setText("")
            }else{
                Toast.makeText(requireContext(),"enter the number of heads from 1 to 20!",Toast.LENGTH_SHORT).show()
            }
        }

        id_edittext_goals_penalty.hint = "past record: ${MAIN.getRecordPenaltyAllTime()}"

        id_button_to_rv_penalty.setOnClickListener {
            MAIN.replaceToBestPlayerFragment("penalty")
        }

    }


}