package com.innaval.fragments

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonHome: Button
    private lateinit var buttonConsoles: Button
    private lateinit var buttonGames: Button

    private lateinit var homeFragment: HomeFragment
    private lateinit var gameFragment: GameFragment
    private lateinit var consoleFragment: ConsoleFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonHome = findViewById(R.id.button_home)
        buttonHome.setOnClickListener(this)

        buttonConsoles = findViewById(R.id.button_consoles)
        buttonConsoles.setOnClickListener(this)

        buttonGames = findViewById(R.id.button_games)
        buttonGames.setOnClickListener(this)

        homeFragment = HomeFragment()
        consoleFragment = ConsoleFragment()
        gameFragment = GameFragment()

        setFragment(homeFragment)

    }

    private fun setFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_fragments, fragment)
        fragmentTransaction.commit()

    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.button_home -> {
                setFragment(homeFragment)
            }

            R.id.button_games -> {
                setFragment(gameFragment)
            }

            R.id.button_consoles -> {
                setFragment(consoleFragment)
            }
        }
    }
}