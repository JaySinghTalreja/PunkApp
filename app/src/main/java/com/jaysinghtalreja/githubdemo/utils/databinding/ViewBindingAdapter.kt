package com.jaysinghtalreja.githubdemo.utils.databinding

import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import com.jaysinghtalreja.githubdemo.R
import kotlin.random.Random

object ViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("isGone")
    fun bindIsGone(view: View, isGone: Boolean) {
        view.visibility = if (isGone) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    @JvmStatic
    @BindingAdapter("isKnowMoreGone")
    fun isKnowMoreGone(button: MaterialButton, isGone: Boolean) {
        button.visibility = if (isGone) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    /**
     * Set Random Description on Null Description for consistent UI
     */

    @JvmStatic
    @BindingAdapter("setDescription")
    fun setDescription(textView: TextView, text: String?) {
        if(text == null) {
            textView.text = "An open source framework for building and running fast, secure, and composable cloud microservices with WebAssembly"
        }
        else {
            textView.text = text
        }
    }



    @JvmStatic
    @BindingAdapter("setLanguage")
    fun setLanguage(textView: TextView, text: String?) {
        if(text == null) {
            textView.text = "Rust"
        }
        else {
            textView.text = text
        }
    }


    @JvmStatic
    @BindingAdapter("setColorToLanguage")
    fun setColorToLanguage(view: View, isEnabled: Boolean) {
        if(isEnabled) {
            val randomColor = Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            view.setBackgroundColor(randomColor)
        }

    }

    @JvmStatic
    @BindingAdapter("isLoading")
    fun isLoading(shimmerFrameLayout: ShimmerFrameLayout, isLoading: Boolean) {
        if (isLoading) {
            Log.i("isLoading", "isLoading: " + isLoading)
            shimmerFrameLayout.startShimmer()
            shimmerFrameLayout.visibility = View.VISIBLE
        } else {
            Log.i("isLoading", "isLoading: " + isLoading)
            shimmerFrameLayout.stopShimmer()
            shimmerFrameLayout.visibility = View.GONE
        }
    }


    /**
     * Beer Adapter
     */

    /**
     * Set Beer Image
     */

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(view: ShapeableImageView, imageUrl: String?) {
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(view.context)
                .load(imageUrl)
                .into(view)
        }
    }

}