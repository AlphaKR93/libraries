package kr.alpha93.lyra.android.compat

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat


public fun Context.hasPermission(permission: String): Boolean =
    ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
