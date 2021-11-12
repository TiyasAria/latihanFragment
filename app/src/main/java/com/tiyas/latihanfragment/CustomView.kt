package com.tiyas.latihanfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import com.tiyas.latihanfragment.databinding.ActivityCustomViewBinding

class CustomView : AppCompatActivity() {

//     membuat viewBinding untuk penggati dari findViewByID
    private lateinit var customViewBinding: ActivityCustomViewBinding
    private lateinit var myButton: MyButton
    private lateinit var myEditText: MyEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
        myButton = findViewById(R.id.my_button)
        myEditText = findViewById(R.id.my_edit_text)



        setMyButtonEnable()

//         tambahkan kode untuk cek kalau edittext udah ada isinya maka button akan enable , kemudian saat udah enable atau di klik maka muncul toast
        myEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        myButton.setOnClickListener { Toast.makeText(this@CustomView, myEditText.text, Toast.LENGTH_SHORT).show() }
    }

    private fun setMyButtonEnable() {
        val result = myEditText.text
        myButton.isEnabled = result != null  && result.toString().isNotEmpty()
    }
}