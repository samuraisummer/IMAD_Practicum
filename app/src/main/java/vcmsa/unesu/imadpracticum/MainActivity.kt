package vcmsa.unesu.imadpracticum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //start of code

        val btnExit = findViewById<Button>(R.id.btnExit)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSecondScreen = findViewById<Button>(R.id.btnSecondScreen)
        val edtSongTitle = findViewById<EditText>(R.id.edtSongTitle)
        val edtRating = findViewById<EditText>(R.id.edtRating)
        val edtUserComments = findViewById<EditText>(R.id.edtUserComments)
        val edtArtistName = findViewById<EditText>(R.id.edtArtistName)

        val message = "Enter song details"
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        btnAdd.setOnClickListener {
            //retrieve the data from the elements
            val edtSongTitle = edtSongTitle.text.toString()
            val edtRating = edtRating.text.toString()
            val edtUserComments = edtUserComments.text.toString()
            val edtArtistName = edtArtistName.text.toString()
        }

        btnAdd.setOnClickListener {
            //retrieve data from the elements
        }
        val songDetails = arrayOf(
            edtSongTitle.text.toString(), "Song Title",
            edtArtistName.text.toString(), "Artist Name",
            edtRating.text.toString(), "Rating (1 - 5)",
            edtRating.text.toString(), "User Comments",
        )

        //navigate to second screen
        val intent = Intent(this, DetailedView::class.java).putExtra("Details", songDetails)
        startActivity(intent)
        finish()
}//end of onCreate
}//end of MainActivity