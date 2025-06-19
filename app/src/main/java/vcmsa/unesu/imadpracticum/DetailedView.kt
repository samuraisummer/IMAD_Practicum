package vcmsa.unesu.imadpracticum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class DetailedView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        //code starts here

        val btnList = findViewById<Button>(R.id.btnList) //Button to display list of songs
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnReturn = findViewById<Button>(R.id.btnReturn)
        val txtlist = findViewById<TextView>(R.id.txtList)
        var averageRating = findViewById<TextView>(R.id.txtCalculation)
        //code logic

        var totalRatingSum = 0
        var validRatingEntries = 0
        var receivedSongList = 0

        if (validRatingEntries > 0) {
            /* Calculate the average only if there was at least one valid rating. */
            val averageRating = totalRatingSum / validRatingEntries

            // Format the average to two decimal places for better readability.
            val formattedAverage = String.format("%.2f", averageRating)



            // Display the result in TextView.
            var txtList = "Average Song Rating: $formattedAverage\n" +
                    "(Based on $validRatingEntries songs with valid ratings)"

            Toast.makeText(this, "Average rating calculated!", Toast.LENGTH_SHORT).show()

            // No songs in the list had a rating that could be converted to a number.
            txtList = "No valid ratings found in the playlist to calculate an average."
            Toast.makeText(this, "No valid song ratings to average.", Toast.LENGTH_SHORT).show()
        } else {
        // The song list is either null (not received) or empty.
            var txtList = "Playlist is empty. Add songs to calculate average rating."
            Toast.makeText(this, "No songs in the playlist.", Toast.LENGTH_SHORT).show()

            btnReturn.setOnClickListener {
                finish()

            }
        }
    }
}