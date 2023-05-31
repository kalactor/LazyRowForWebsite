package com.rabarka.lazyrow

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Flower(
    @DrawableRes val imageResId: Int,
    @StringRes val nameResId: Int,
)
