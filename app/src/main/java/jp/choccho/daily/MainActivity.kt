package jp.choccho.daily

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val sampleList = mutableListOf<String>()
        for (i in 0..10) {
            sampleList.add(i.toString())
        }
        val adapter = RecyclerViewAdapter(sampleList)
        recyclerView.adapter = adapter

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val sampleList = mutableListOf<String>()
            for (i in 0..10) {
                sampleList.add("${year}年${month}月${dayOfMonth}日")

            }
            adapter.items = sampleList
            adapter.notifyDataSetChanged()
        }

        button.setOnClickListener {
            val intent = Intent(this, RecordActivity::class.java)
            startActivity(intent)
        }
    }
}
