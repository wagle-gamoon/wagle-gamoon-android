package com.codelap.waglegamoon.ui.profile

import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController
import com.codelap.waglegamoon.R
import com.codelap.waglegamoon.base.BaseFragment
import com.codelap.waglegamoon.databinding.FragmentProfileSettingBinding
import com.codelap.waglegamoon.ui.home.HomeFragmentDirections

class ProfileSetting : BaseFragment<FragmentProfileSettingBinding>(R.layout.fragment_profile_setting) {
    val btnadviser = true
    val btnftf = true
    val btnof = true
    val btnnftf = true
    val btnlisten = true
    val btnsteadily = true

    override fun setLayout() {
        binding.matchingSwitch.isChecked = true
    }
    private fun setClickListener() {
        with(binding) {
            btnProfileAdviserStyle.setOnClickListener {
                binding.btnProfileAdviserStyle.isEnabled = !btnadviser
            }
            btnProfileFtfStyle.setOnClickListener {
                btnProfileFtfStyle.isEnabled = !btnftf
            }
            btnProfileOfStyle.setOnClickListener {
                btnProfileOfStyle.isEnabled = !btnof
            }
            btnProfileNftfStyle.setOnClickListener {
                btnProfileNftfStyle.isEnabled = !btnnftf
            }
            btnProfileListenerStyle.setOnClickListener {
                btnProfileListenerStyle.isEnabled = !btnlisten
            }
            btnProfileSteadilyStyle.setOnClickListener {
                btnProfileSteadilyStyle.isEnabled = !btnsteadily
            }
            matchingSwitch.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    tvMatchingChoice.text = "활성화"
                } else {
                    tvMatchingChoice.text = "비할성화"
                }
            }
        }
    }
}

