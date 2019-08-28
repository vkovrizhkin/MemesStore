package com.kovrizhkin.memesstore.view.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kovrizhkin.memesstore.R
import com.kovrizhkin.memesstore.model.memes.MemInfo
import com.kovrizhkin.memesstore.utils.DateHelperUtil
import java.time.Duration

class DetailMemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mem)

        val memInfo = intent.getSerializableExtra(MEM_EXTRA_KEY) as MemInfo



        val date = DateHelperUtil.getDaysAgo(memInfo.createdDate)

        showMemDetails(memInfo)


    }

    private fun showMemDetails(memInfo: MemInfo) {

        val date = DateHelperUtil.getDaysAgo(memInfo.createdDate)


    }

    companion object {
        const val MEM_EXTRA_KEY = "MEM_EXTRA_KEY"
    }
}
