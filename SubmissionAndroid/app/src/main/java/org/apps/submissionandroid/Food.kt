package org.apps.submissionandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val nama: String,
    val desc: String,
    val photo: Int
): Parcelable
