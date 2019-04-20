package io.cbedoy.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object Utils{

    val cacheSize = ((5 * 1024) * 1024).toLong()
    val mediaHosts = arrayOf("spotify", "vimeo", "itunes", "youtube", "twitch", "netflix", "primevideo", "deezer")

    fun hasNetwork(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
}