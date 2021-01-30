package com.example.loginapp

import android.app.Dialog
import android.content.DialogInterface
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ProgressBarLayoutBinding

abstract class BaseActivity : AppCompatActivity() {
    private var progressDialog: Dialog? = null
    private var exitFlag: Boolean = false
    private val handler = Handler(Looper.getMainLooper())

    fun showProgressDialog() {
        val binding = ProgressBarLayoutBinding.inflate(layoutInflater)
        progressDialog = Dialog(this, R.style.CustomAlertDialog)
        progressDialog?.setContentView(binding.root)
        progressDialog?.setCancelable(true)
        progressDialog?.setOnCancelListener { }
        progressDialog?.show()
    }

    fun hideProgressDialog() {
        if (progressDialog?.isShowing == true) progressDialog?.dismiss()
    }

    fun showErrorDialog(errorMessage: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage(errorMessage)
            .setCancelable(true)
            .setPositiveButton(R.string.ok,
                DialogInterface.OnClickListener { dialog, id -> dialog.dismiss() })

        val alert: AlertDialog = builder.create()
        alert.setOnCancelListener { }
        alert.show()
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        if (!exitFlag) {
            exitFlag = true
            resources?.getString(R.string.request_exit_app)?.let { showToast(it) }
            handler.postDelayed({ exitFlag = false }, 3500)
        } else {
            super.onBackPressed()
        }
    }

    override fun onPause() {
        handler.removeCallbacksAndMessages(null)
        super.onPause()
    }
}