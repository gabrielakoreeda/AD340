package com.example.ad340

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

fun formatTempForDisplay(temp: Float, tempDisplaySetting: TempDisplaySetting) : String {
    return when(tempDisplaySetting) {
        TempDisplaySetting.Fahrenheit -> String.format("%.2f Fº", temp)
        TempDisplaySetting.Celsius -> {
            val temp = (temp - 32f) * (5f / 9f)
            String.format("%.2f Cº", temp)
        }
    }
}

fun showTempDisplaySettingDialog(context: Context, tempDisplaySettingManager: TempDisplaySettingManager) {
    val dialogBuilder = AlertDialog.Builder(context)
        .setTitle("Choose Display Units")
        .setMessage("Choose which temperature unit to display")
        .setPositiveButton("Fº") { _, _ ->
            tempDisplaySettingManager.updateSetting(TempDisplaySetting.Fahrenheit)
        }
        .setNeutralButton("Cº") { _, _ ->
            tempDisplaySettingManager.updateSetting(TempDisplaySetting.Celsius)
        }
        .setOnDismissListener {
            Toast.makeText(context, "Setting will take effect on app restart", Toast.LENGTH_SHORT).show()
        }

    dialogBuilder.show()
}