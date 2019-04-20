package io.cbedoy

import android.app.Application
import io.cbedoy.utils.RetrofitUtil

class ApplicationManager : Application() {
    override fun onCreate() {
        super.onCreate()

        RetrofitUtil.init(this)
    }
}