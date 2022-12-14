package com.example.ugd3_d_0659.library.PagerIndicatorForRecyclerViews

import android.app.AlertDialog
import android.app.Dialog
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import com.example.ugd3_d_0659.R
import com.example.ugd3_d_0659.entity.MPFavorit
import com.example.ugd3_d_0659.entity.MPFavorit.Companion.listOfMPFavorit

class PagerNumberPickerDialogPreference : DialogFragment() {

    companion object {
        const val KEY_NUM_PAGES = "num_pages"

        private const val MIN_PAGES = 0
        private val MAX_PAGES = listOfMPFavorit.size
        const val DEFAULT_PAGES = 3
    }

    private lateinit var numberPicker: NumberPicker

    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferences = PreferenceManager.getDefaultSharedPreferences(activity)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val view = View.inflate(activity, R.layout.dialog_pager_number_picker, null)

        bindViews(view)
        setupViews()

        return AlertDialog.Builder(activity)
            .setTitle(R.string.pager_number_picker_dialog_title)
            .setView(view)
            .setPositiveButton(R.string.pager_number_picker_dialog_positive_text) { _, _ ->
                preferences.edit().putInt(KEY_NUM_PAGES, numberPicker.value).apply()
                (activity as OnPagerNumberChangeListener).onPagerNumberChanged()
                dismiss()
            }
            .setNegativeButton(R.string.pager_number_picker_dialog_negative_text) { _, _ -> dismiss() }
            .create()
    }

    private fun bindViews(view: View) {
        numberPicker = view.findViewById(R.id.pager_number_dialog_number_picker)
    }

    private fun setupViews() {
        numberPicker.minValue = MIN_PAGES
        numberPicker.maxValue = MAX_PAGES
        numberPicker.value = preferences.getInt(KEY_NUM_PAGES, DEFAULT_PAGES)
    }
}