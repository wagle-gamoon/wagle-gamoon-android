package com.codelap.waglegamoon.ui.home

import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.codelap.waglegamoon.R
import com.codelap.waglegamoon.base.BaseActivity
import com.codelap.waglegamoon.databinding.ActivityHomeStudyRecruitWriteBinding
import com.codelap.waglegamoon.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeStudyRecruitWriteActivity : BaseActivity<ActivityHomeStudyRecruitWriteBinding>(R.layout.activity_home_study_recruit_write) {
    private val viewModel by viewModels<HomeViewModel>()
    private var categorySort = "스터디모집게시판"
    private var title = ""
    private var place = ""
    private var content = ""
    private var userID: Long = 0

    override fun setLayout() {
        viewModel.postUsers()
        setClickListener()
        setTextInput()
        initUserId()
    }

    private fun setClickListener() {
        with(binding) {
            toolbarPostStudyRecruitWrite.setNavigationOnClickListener {
                finish()
            }
            btnPostWriteConfirm.setOnClickListener {
                viewModel.postPosts(userID, categorySort, title, place, content, 5, 3)
                isSuccess()
            }
        }
    }

    private fun setTextInput() {
        with(binding) {
            etInputPostTitle.doAfterTextChanged {
                if (!it.isNullOrEmpty()) {
                    title = it.toString()
                } else return@doAfterTextChanged
            }
            etInputPostContent.doAfterTextChanged {
                if (!it.isNullOrEmpty()) {
                    content = it.toString()
                } else return@doAfterTextChanged
            }
            etInputLocation.doAfterTextChanged {
                if (!it.isNullOrEmpty()) {
                    place = it.toString()
                } else return@doAfterTextChanged
            }
        }
    }

    private fun initUserId() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.defaultResult.collectLatest {
                    if (it.success) {
                        userID = it.data
                    }
                }
            }
        }
    }

    private fun isSuccess() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.postResult.collectLatest {
                    if (it.success) {
                        finish()
                    }
                }
            }
        }
    }
}