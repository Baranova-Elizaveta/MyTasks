import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.itproger.zorder.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val yellowView = findViewById<View>(R.id.yellowView)
        val redView = findViewById<View>(R.id.redView)
        val blueView = findViewById<View>(R.id.blueView)
        val screenHeight = resources.displayMetrics.heightPixels.toFloat()
        val yellowLayout = yellowView.layoutParams as LinearLayout.LayoutParams
        yellowLayout.height = (screenHeight * 0.5).toInt()
        yellowView.layoutParams = yellowLayout
        val redLayout = redView.layoutParams as LinearLayout.LayoutParams
        redLayout.height = (screenHeight * 0.85).toInt()
        redView.layoutParams = redLayout
        val blueLayout = blueView.layoutParams as LinearLayout.LayoutParams
        blueLayout.height = (screenHeight * 0.8).toInt()
        blueView.layoutParams = blueLayout
    }
}

