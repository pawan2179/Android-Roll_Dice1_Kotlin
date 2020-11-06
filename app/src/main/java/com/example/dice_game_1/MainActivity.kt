package com.example.dice_game_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var random_number: Int = 0
    private var player_a_score: Int = 0
    private var player_b_score: Int = 0
    private var game_point: Int = 100
    private var player_a_active: Boolean = true
    private var player_b_active: Boolean = false
    private var game_end_msg: String = "The Winner is : "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice_image.isEnabled = false

        btn_start_game.setOnClickListener {
            dice_image.isEnabled = true
            reset_game()
        }

        dice_image.setOnClickListener{
            random_number = (1..6).random()

            when(random_number) {
                1 -> {
                    dice_image.setImageResource(R.drawable.dice1)
                }
                2 -> {
                    dice_image.setImageResource(R.drawable.dice2)
                }
                3 -> {
                    dice_image.setImageResource(R.drawable.dice3)
                }
                4 -> {
                    dice_image.setImageResource(R.drawable.dice4)
                }
                5 -> {
                    dice_image.setImageResource(R.drawable.dice5)
                }
                6 -> {
                    dice_image.setImageResource(R.drawable.dice6)
                }
            }
            if(player_a_active) {
                player_a_score += random_number
                player_a_active = false
                player_b_active = true

            }
            else {
                player_b_score += random_number
                player_b_active = false
                player_a_active = true
            }
            score_A.setText(player_a_score.toString())
            score_B.setText(player_b_score.toString())

            if(player_a_score >= game_point) {
                game_over_msg.text = game_end_msg + "  Player A"
                dice_image.isEnabled = false
            }
            else if(player_b_score >= game_point) {
                game_over_msg.text = game_end_msg + " Player B"
                dice_image.isEnabled = false
            }
        }
    }
    fun reset_game() {
        player_a_score = 0
        player_b_score = 0
        player_a_active = true
        player_b_active = false
        game_over_msg.text = ""
        score_A.setText(player_a_score.toString())
        score_B.setText(player_b_score.toString())
        dice_image.setImageResource(R.drawable.dice1)
    }
}