package com.example.football6

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.football6.view.BestPlayerFragment
import com.example.football6.view.FreeKickFragment
import com.example.football6.view.PenaltyFragment
import com.example.football6.view.CornersFragment
import com.onesignal.OneSignal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val freeKickFragment = FreeKickFragment()
    private val penaltyFragment = PenaltyFragment()
    private val cornersFragment = CornersFragment()
    private val bestPlayerFragment = BestPlayerFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(intent.getStringExtra("url")=="nopush"){
            OneSignal.disablePush(true)
        }

        MAIN = this

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        replaceFragment(freeKickFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.id_menu_freekick ->replaceFragment(freeKickFragment)
                R.id.id_menu_penalty ->replaceFragment(penaltyFragment)
                R.id.id_menu_corners ->replaceFragment(cornersFragment)
            }
            true
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()

        finishAffinity()

    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }

    fun replaceToBestPlayerFragment(str:String){
        val bundle = Bundle()
        bundle.putString("key",str)

        bestPlayerFragment.arguments = bundle

        replaceFragment(bestPlayerFragment)
    }

    fun getRecordPenaltyAllTime():Int{
        val recordAllTimePreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).getInt(
            RECORD_ALL_TIME_PENALTY,0)
        return recordAllTimePreferences ?: 0
    }

    fun setRecordPenaltyAllTime(record:Int){
        val recordAllTimePreferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        recordAllTimePreferences.edit()
            .putInt(RECORD_ALL_TIME_PENALTY,record)
            .apply()
    }

    fun getRecordCornersAllTime():Int{
        val recordAllTimePreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).getInt(
            RECORD_ALL_TIME_CORNERS,0)
        return recordAllTimePreferences ?: 0
    }

    fun setRecordCornersAllTime(record:Int){
        val recordAllTimePreferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        recordAllTimePreferences.edit()
            .putInt(RECORD_ALL_TIME_CORNERS,record)
            .apply()
    }

    fun getRecordFreeKickAllTime():Int{
        val recordAllTimePreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).getInt(
            RECORD_ALL_TIME_FREEKICK,0)
        return recordAllTimePreferences ?: 0
    }

    fun setRecordFreeKickAllTime(record:Int){
        val recordAllTimePreferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        recordAllTimePreferences.edit()
            .putInt(RECORD_ALL_TIME_FREEKICK,record)
            .apply()
    }

}