package com.jaysinghtalreja.githubdemo.ui.about

import android.content.res.AssetManager
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jaysinghtalreja.githubdemo.BuildConfig
import com.jaysinghtalreja.githubdemo.R
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element


class AboutFragment : Fragment() {

    private val versionElement : Element = Element().setTitle("Version:" + BuildConfig.VERSION_CODE.toString())
        .setGravity(Gravity.CENTER_HORIZONTAL)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return AboutPage(context)
            .setImage(R.drawable.logo)
            .isRTL(false)
            .setDescription(getString(com.jaysinghtalreja.githubdemo.R.string.app_description))
            .addItem(versionElement)
            .create()
    }
}