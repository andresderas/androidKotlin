package com.naldana.gamescore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ScoreFragment.OnScorePlusListener {

    private var scoreTeamA = 0
    private var scoreTeamB = 0

    companion object {
        const val TEAM_A = "TEAM_A"
        const val TEAM_B = "TEAM_B"
        val TAG = MainActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
        savedInstanceState?.let {
            scoreTeamA = it.getInt(TEAM_A, 0)
            scoreTeamB = it.getInt(TEAM_B, 0)
        }

        // Accediendo al fragmento
        val fragmentManager = supportFragmentManager

        //Creando el fragmento de cada quipo
        val teamAFragment =
            ScoreFragment.newInstance(getString(R.string.title_equipo_a), scoreTeamA)
        val teamBFragment =
            ScoreFragment.newInstance(getString(R.string.title_equipo_b), scoreTeamB)

        fragmentManager
            .beginTransaction() // Comenzando transaccion
            .replace(R.id.team_a_fragment, teamAFragment) // Agregando fragmento 1.Adonde, 2.Fragmento
            .replace(R.id.team_b_fragment, teamBFragment) // reemplazar el que ya estaba por eso se usa replace
            .addToBackStack(null) // Cuando le de atras se cierre la aplicacion de un solo
            .commit() // Ya esta lsito

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(TEAM_A, scoreTeamA)
        outState.putInt(TEAM_B, scoreTeamB)
    }

    override fun onPlus(teamName: String, newScore: Int) {
        when (teamName) {
            getString(R.string.title_equipo_a) -> scoreTeamA = newScore
            getString(R.string.title_equipo_b) -> scoreTeamB = newScore
        }
    }
}