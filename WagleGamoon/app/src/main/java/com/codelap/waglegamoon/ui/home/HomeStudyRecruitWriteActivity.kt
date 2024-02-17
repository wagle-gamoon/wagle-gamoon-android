package com.codelap.waglegamoon.ui.home

import com.codelap.waglegamoon.R
import com.codelap.waglegamoon.base.BaseActivity
import com.codelap.waglegamoon.databinding.ActivityHomeStudyRecruitWriteBinding

class HomeStudyRecruitWriteActivity : BaseActivity<ActivityHomeStudyRecruitWriteBinding>(R.layout.activity_home_study_recruit_write) {
    override fun setLayout() {
        setClickLisetner()
    }

    private fun setClickLisetner() {
        with(binding) {
            toolbarPostStudyRecruitWrite.setNavigationOnClickListener {
                finish()
            }
        }
    }
}