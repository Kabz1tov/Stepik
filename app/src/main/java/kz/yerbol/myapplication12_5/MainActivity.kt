package kz.yerbol.myapplication12_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        val recyclerView: RecyclerView = findViewById(R.id.rv)

        val list = mutableListOf(
            ListItem.CurrencyItem(1, (0..123456).random(), "Тенге, Казахстан"),
            ListItem.CurrencyItem(1, (0..123456).random(), "Доллары, США"),
            ListItem.CurrencyItem(1, (0..123456).random(), "Рубли, Россия"),
            ListItem.CurrencyItem(1, (0..123456).random(), "Тенге, Казахстан"),
            ListItem.CurrencyItem(1, (0..123456).random(), "Доллары, США"),
            ListItem.CurrencyItem(1, (0..123456).random(), "Рубли, Россия"),

            ListItem.ButtonItem("Добавить"),
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(list)
    }
}