package kr.alpha93.lyra.android.activity

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher as AndroidActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.Companion.ACTION_INTENT_SENDER_REQUEST
import androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.Companion.EXTRA_INTENT_SENDER_REQUEST


public class ActivityResultCallback :
    ActivityResultContract<Pair<IntentSenderRequest, ActivityResult.() -> Unit>, Unit>() {

    public companion object {

        public typealias ActivityResultLauncher =
                AndroidActivityResultLauncher<Pair<IntentSenderRequest, ActivityResult.() -> Unit>>

        @JvmStatic
        public fun ComponentActivity.register(): Companion.ActivityResultLauncher =
            registerForActivityResult(ActivityResultCallback()) {}

        @JvmStatic
        public fun Companion.ActivityResultLauncher.launch(
            intentSenderRequest: IntentSenderRequest,
            callback: ActivityResult.() -> Unit)
        {
            launch(Pair(intentSenderRequest, callback))
        }

    }

    private var callback: (ActivityResult.() -> Unit)? = null

    override fun createIntent(
        context: Context,
        input: Pair<IntentSenderRequest, ActivityResult.() -> Unit>
    ): Intent {
        check(callback == null) { "Callback is already set. Only one callback can be set at a time." }
        callback = input.second
        return Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, input.first)
    }

    override fun parseResult(resultCode: Int, intent: Intent?) {
        callback!!(ActivityResult(resultCode, intent))
        callback = null
    }

}
