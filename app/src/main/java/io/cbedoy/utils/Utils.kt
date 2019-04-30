package io.cbedoy.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import org.nibor.autolink.LinkExtractor
import org.nibor.autolink.LinkType
import java.util.*

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

    fun convertDpToPixel(dp: Int, context: Context): Int {
        val displayMetrics = context.resources.displayMetrics
        return (dp * displayMetrics.density + 0.5).toInt()
    }

    fun extractURL(input: String): String? {
        if (input.isEmpty())
            return null

        val positionsOfUrl = positionsOfUrl(input)

        return input.substring(positionsOfUrl[0], positionsOfUrl[1])
    }

    fun positionsOfUrl(input: String): IntArray {
        val linkExtractor = LinkExtractor.builder()
            .linkTypes(EnumSet.of(LinkType.URL, LinkType.WWW))
            .build()
        val links = linkExtractor.extractLinks(input)
        return if (links.iterator().hasNext()) {
            val link = links.iterator().next()
            link.type        // LinkType.URL
            link.beginIndex  // 17
            link.endIndex

            intArrayOf(link.beginIndex, link.endIndex)
        } else
            intArrayOf(0, 0)
    }
}