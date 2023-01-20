package com.vonisak.sport.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vonisak.sport.R
import com.vonisak.sport.databinding.FragmentMatchesBinding
import com.vonisak.sport.databinding.FragmentWebViewBinding


class WebViewFragment : Fragment() {

    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://1xstavka.ru/")

        return binding.root
    }

}