package kz.yerbol.myapplication12_5

sealed class ListItem {
    data class CurrencyItem(val flag: Int, val sum: Int, val name: String) : ListItem()
    data class ButtonItem(val name: String) : ListItem()
}