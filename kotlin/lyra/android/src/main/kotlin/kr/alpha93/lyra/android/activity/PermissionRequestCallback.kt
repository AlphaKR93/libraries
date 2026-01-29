package kr.alpha93.lyra.android.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.Companion.ACTION_REQUEST_PERMISSIONS
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.Companion.EXTRA_PERMISSIONS
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher


public class PermissionRequestCallback :
    ActivityResultContract<Pair<String, (Boolean) -> Unit>, Unit>() {

    public companion object {

        @JvmStatic
        public fun ComponentActivity.register(): ActivityResultLauncher<Pair<String, (Boolean) -> Unit>> =
            registerForActivityResult(PermissionRequestCallback()) {}

        @JvmStatic
        public fun ActivityResultLauncher<Pair<String, (Boolean) -> Unit>>.launch(
            permission: String,
            callback: (Boolean) -> Unit
        ) {
            launch(Pair(permission, callback))
        }

    }

    private var callback: ((Boolean) -> Unit)? = null

    override fun createIntent(
        context: Context,
        input: Pair<String, (Boolean) -> Unit>
    ): Intent {
        check(callback == null) { "Callback is already set. Only one callback can be set at a time." }
        callback = input.second
        return Intent(ACTION_REQUEST_PERMISSIONS).putExtra(EXTRA_PERMISSIONS, arrayOf(input.first))
    }

    @Suppress("AutoBoxing")
    override fun parseResult(resultCode: Int, intent: Intent?) {
        if (intent == null || resultCode != Activity.RESULT_OK) callback!!(false)

        else if (intent.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS)
            ?.all { it == PackageManager.PERMISSION_GRANTED } == true) callback!!(true)

        callback = null
    }

}
