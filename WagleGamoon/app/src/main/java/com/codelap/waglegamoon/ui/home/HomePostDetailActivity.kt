package com.codelap.waglegamoon.ui.home

import com.codelap.waglegamoon.R
import com.codelap.waglegamoon.base.BaseActivity
import com.codelap.waglegamoon.databinding.ActivityHomePostDetailBinding

class HomePostDetailActivity : BaseActivity<ActivityHomePostDetailBinding>(R.layout.activity_home_post_detail) {
    override fun setLayout() {
        setClickListener()
    }

    private fun setClickListener() {
        with(binding) {
            toolbarPostStudyRecruitDetail.setNavigationOnClickListener {
                finish()
            }
        }
    }
}