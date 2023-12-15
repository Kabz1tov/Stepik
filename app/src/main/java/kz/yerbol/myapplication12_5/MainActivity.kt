package kz.yerbol.myapplication12_5

import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.DOWN
import androidx.recyclerview.widget.ItemTouchHelper.LEFT
import androidx.recyclerview.widget.ItemTouchHelper.RIGHT
import androidx.recyclerview.widget.ItemTouchHelper.UP
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections


class MainActivity : AppCompatActivity() {

    private lateinit var customAdapter: CustomAdapter
    private lateinit var menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
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

        customAdapter = CustomAdapter(list, this)
        recyclerView.adapter = customAdapter

        /*        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(UP or DOWN, LEFT or RIGHT) {
                    override fun onMove(
                        recyclerView: RecyclerView,
                        viewHolder: RecyclerView.ViewHolder,
                        target: RecyclerView.ViewHolder
                    ): Boolean {
                        val fromPosition = viewHolder.adapterPosition
                        val toPosition = target.adapterPosition

                        if (fromPosition < toPosition) {
                            for (i in fromPosition until toPosition) {
                                Collections.swap(list, i, i + 1)
                            }
                        } else {
                            for (i in fromPosition downTo toPosition + 1) {
                                Collections.swap(list, i, i - 1)
                            }
                        }

        //                Collections.swap(list, fromPosition, toPosition)

                        recyclerView.adapter?.notifyItemMoved(fromPosition, toPosition)
                        return false
                    }

                    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                        list.removeAt(viewHolder.adapterPosition)
                        (recyclerView.adapter as CustomAdapter).notifyItemRemoved(viewHolder.adapterPosition)
                    }
                }).attachToRecyclerView(recyclerView)*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        this.menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_order_asc -> {
                customAdapter.sortItemsAsc()

                item.setChecked(true);
                true
            }

            R.id.menu_order_sum -> {
                customAdapter.sortItemsSum()

                item.setChecked(true);
                true
            }

            R.id.menu_order_reset -> {
                customAdapter.sortReset()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onItemLongClick(itemPosition: Int) {
        this.title = "Item selected ${itemPosition + 1}"
        val menuItem: MenuItem = menu.findItem(R.id.menu_delete)
        menuItem.isVisible = true
    }
}