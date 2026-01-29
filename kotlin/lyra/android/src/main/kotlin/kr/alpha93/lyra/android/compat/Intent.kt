package kr.alpha93.lyra.android.compat

import android.content.Intent
import android.os.Parcelable
import androidx.core.content.IntentCompat


public inline fun <reified T : Parcelable> Intent.getExtra(name: String): T? =
    IntentCompat.getParcelableExtra(this, name, T::class.java)
