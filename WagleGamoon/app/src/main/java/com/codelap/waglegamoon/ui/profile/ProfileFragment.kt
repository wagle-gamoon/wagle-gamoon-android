package com.codelap.waglegamoon.ui.profile

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.codelap.waglegamoon.R
import com.codelap.waglegamoon.base.BaseFragment
import com.codelap.waglegamoon.databinding.FragmentProfileBinding
import com.codelap.waglegamoon.ui.profile.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
    private val viewModel by viewModels<ProfileViewModel>()
    override fun setLayout() {
        binding.ivProfileIcon.setOnClickListener {
            viewModel.postUsers()
        }
    }

    fun testPostUser() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.defaultResult.collectLatest {
                    if (it.success) {
                        Log.e("API SUCCESS", it.status)
                    }
                }
            }
        }
    }


}