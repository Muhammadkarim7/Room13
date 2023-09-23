package com.example.room13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.room13.adapters.RvAdapter
import com.example.room13.databinding.ActivityMainBinding
import com.example.room13.db.MyDbHelper
import com.example.room13.models.MyContact

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var rvAdapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        myDbHelper = MyDbHelper.getInstance(this)
        rvAdapter = RvAdapter()
        binding.rv.adapter = rvAdapter 

        binding.apply {
            btnSave.setOnClickListener {
                val myContact = MyContact(
                    edtName.text.toString(),
                    edtNumber.text.toString()
                )
                myDbHelper.Dao().addContact(myContact)
                onResume()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        rvAdapter.list.clear()
        rvAdapter.list.addAll(myDbHelper.Dao().getAllContacts())
        rvAdapter.notifyDataSetChanged()
    }
}