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

class CornersFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_corners, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext())
            .asGif()
            .load("http://37.27.9.28/6/corner.gif")
            .into(id_gif_corners)

        id_button_enter_corners.setOnClickListener {
            if (id_edittext_corners.text.toString().toInt() in 0..20){
                val goals = id_edittext_corners.text.toString().toInt()
                if(MAIN.getRecordCornersAllTime()<goals){
                    MAIN.setRecordCornersAllTime(goals)
                    Toast.makeText(requireContext(),"you have updated the record!", Toast.LENGTH_SHORT).show()
                    id_edittext_corners.hint = "past record: ${MAIN.getRecordCornersAllTime()}"
                }
                id_edittext_corners.setText("")
            }else{
                Toast.makeText(requireContext(),"enter the number of heads from 1 to 20!",Toast.LENGTH_SHORT).show()
            }
        }

        id_edittext_corners.hint = "past record: ${MAIN.getRecordCornersAllTime()}"

        id_button_to_rv_corners.setOnClickListener {
            MAIN.replaceToBestPlayerFragment("corners")
        }


    }


}