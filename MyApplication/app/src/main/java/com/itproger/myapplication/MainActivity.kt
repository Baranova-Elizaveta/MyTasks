import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.itproger.myapplication.ColorSwitcherView
import com.itproger.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var colorSwitcher: ColorSwitcherView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private lateinit var colorIndexText: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorSwitcher = findViewById(R.id.colorSwitcherView)
        previousButton = findViewById(R.id.previousButton)
        nextButton = findViewById(R.id.nextButton)
        colorIndexText = findViewById(R.id.colorIndexTextView)

        previousButton.setOnClickListener {
            colorSwitcher.showPreviousColor()
            updateColorIndexText()
        }

        nextButton.setOnClickListener {
            colorSwitcher.showNextColor()
            updateColorIndexText()
        }

        colorSwitcher.setOnClickListener {
            updateColorIndexText()
        }

        updateColorIndexText()
    }

    private fun updateColorIndexText() {
        val currentIndex = colorSwitcher.getCurrentColorIndex()
        colorIndexText.text = "Color Index: $currentIndex"
    }
}
