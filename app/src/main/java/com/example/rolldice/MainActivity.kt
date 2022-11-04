package com.example.rolldice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Oncreate behaves like main function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.textview)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice() {
        /** Create new Dice object with 6 sides and roll it */
        val dice = Dice(6)
        val diceRoll = dice.roll()

        /** Update the screen with text in dice roll*/
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
        /** dice image show and using when condition to show image at a number*/
        var diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        /** all images of dice*/
        diceImage.setImageResource(drawableResource)
    }
}
/** take the random number in dice */
class Dice(val numSides : Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}



