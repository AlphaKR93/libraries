package kr.alpha93.lyra.android

import android.content.Context
import android.widget.Toast


public inline fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT, block: Toast.() -> Unit = {}) {
    Toast.makeText(this, message, duration).apply(block).show()
}

public inline fun Context.showToast(resource: Int, duration: Int = Toast.LENGTH_SHORT, block: Toast.() -> Unit = {}) {
    Toast.makeText(this, resource, duration).apply(block).show()
}
