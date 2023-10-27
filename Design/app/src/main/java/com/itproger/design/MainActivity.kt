import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.itproger.design.R

class MainActivity : AppCompatActivity() {
    private lateinit var scroll: ScrollView
    private lateinit var bottom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scroll = findViewById(R.id.scrollView)
        bottom = findViewById(R.id.bottomButton)

        val contentView = scroll.getChildAt(0)
        val observer = contentView.viewTreeObserver
        observer.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                if (contentView.height > scroll.height) {
                    scroll.isScrollContainer = true
                    bottom.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                    bottom.requestLayout()
                } else {
                    scroll.isScrollContainer = false
                    bottom.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
                    bottom.requestLayout()
                }
                contentView.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })
    }
}
