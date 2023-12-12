package kz.yerbol.myapplication12_5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.DOWN
import androidx.recyclerview.widget.ItemTouchHelper.END
import androidx.recyclerview.widget.ItemTouchHelper.LEFT
import androidx.recyclerview.widget.ItemTouchHelper.RIGHT
import androidx.recyclerview.widget.ItemTouchHelper.START
import androidx.recyclerview.widget.ItemTouchHelper.UP
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections

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


        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(UP or DOWN, LEFT or RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition
                Collections.swap(list, fromPosition, toPosition)

                recyclerView.adapter?.notifyItemMoved(fromPosition,toPosition)
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                list.removeAt(viewHolder.adapterPosition)
                (recyclerView.adapter as CustomAdapter).notifyItemRemoved(viewHolder.adapterPosition)
            }
        }).attachToRecyclerView(recyclerView)
    }
}