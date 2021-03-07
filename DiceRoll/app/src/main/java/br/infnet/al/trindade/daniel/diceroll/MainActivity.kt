package br.infnet.al.trindade.daniel.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity shows a button that when pressed generates and displays
 * random number between 1 and 6, inclusive, simulating a 6-sided dice roll.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

        rollDice()
    }

    private fun rollDice() {
        val diceImage: ImageView = findViewById(R.id.imageView)
        val dice6: Dice = Dice(6)
        val diceRoll: Int = dice6.roll()
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val sides: Int) {

    fun roll(): Int {
        return (1..sides).random()
    }
}