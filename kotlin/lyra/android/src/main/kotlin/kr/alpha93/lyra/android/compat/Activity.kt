package kr.alpha93.lyra.android.compat

import android.app.Activity
import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import androidx.core.app.ActivityCompat


public fun Activity.shouldShowRequestPermissionRationale(permission: String): Boolean =
    ActivityCompat.shouldShowRequestPermissionRationale(this, permission)
