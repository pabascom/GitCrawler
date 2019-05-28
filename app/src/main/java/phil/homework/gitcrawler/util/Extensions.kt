package phil.homework.gitcrawler.util

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

fun Context.toast(message: String?){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(this.context).inflate(layoutRes,this, attachToRoot)
}