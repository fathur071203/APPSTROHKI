package com.example.appstrov2.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Username(
    var tokenName : String = "",
) : Parcelable