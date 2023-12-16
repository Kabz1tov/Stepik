package kz.yerbol.myapplication12_5

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class FirstDialogFragment(customAdapter: CustomAdapter) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val customView: View = layoutInflater.inflate(R.layout.dialog_custom, null)
        val dialog: AlertDialog = AlertDialog.Builder(requireContext()).apply {
            setView(customView)
        }.create()

        with(customView) {
            findViewById<Button>(R.id.closeButton).setOnClickListener {
                dialog.dismiss()
            }

            findViewById<Button>(R.id.deleteButton).setOnClickListener {
                (activity as MainActivity).deleteItem()
                dialog.dismiss()
            }
        }

        dialog.show()

        return dialog
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        (activity as MainActivity).onBackPressed()
    }
}