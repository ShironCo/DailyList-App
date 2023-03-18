package com.appsuware.courses.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.appsuware.courses.R

data class Topic(
  @StringRes val stringRes: Int,
  val cantCourses: Int,
  @DrawableRes val imageResourceId: Int
)

object DataSource {
    val topics = listOf(
        Topic(R.string.architecture, 58, R.drawable.image5),
        Topic(R.string.crafts, 121, R.drawable.image4),
        Topic(R.string.business, 78, R.drawable.image3),
        Topic(R.string.culinary, 118, R.drawable.image2),
        Topic(R.string.design, 423, R.drawable.image1),
    )
}
