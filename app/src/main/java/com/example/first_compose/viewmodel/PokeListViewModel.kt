package com.example.first_compose.viewmodel

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import com.example.first_compose.repository.PokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokeListViewModel @Inject constructor(
    private val repository: PokeRepository
): ViewModel() {

    fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {

        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888,true)

        Palette.from(bmp).generate { palette->
            palette?.dominantSwatch?.rgb?.let { colorValue->
                onFinish(Color(colorValue))
            }
        }
    }
}