package com.kovrizhkin.memesstore.view.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kovrizhkin.memesstore.R
import com.kovrizhkin.memesstore.model.memes.MemInfo
import com.kovrizhkin.memesstore.utils.DateHelperUtil
import kotlinx.android.synthetic.main.activity_detail_mem.*
import java.time.Duration

class DetailMemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mem)

        val memInfo = intent.getSerializableExtra(MEM_EXTRA_KEY) as MemInfo

        showMemDetails(memInfo)


    }

    private fun showMemDetails(memInfo: MemInfo) {

        val date = DateHelperUtil.getFormattedDaysAgo(memInfo.createdDate)

        dateAgoText.text = date
        descriptionText.text = memInfo.description
        titleText.text = memInfo.title

        Glide.with(this)
            .load(memInfo.photoUtl)
            .placeholder(R.drawable.ic_crop_original_white_24dp)
            .into(image)
    }

    companion object {
        const val MEM_EXTRA_KEY = "MEM_EXTRA_KEY"
    }
}
