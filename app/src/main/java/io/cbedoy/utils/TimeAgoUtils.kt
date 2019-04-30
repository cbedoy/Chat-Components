package io.cbedoy.utils

import java.text.SimpleDateFormat
import java.util.*

object TimeAgoUtils{
    private val SECOND_MILLIS: Long = 1000
    private val MINUTE_MILLIS = 60 * SECOND_MILLIS
    private val HOUR_MILLIS = 60 * MINUTE_MILLIS
    private val DAY_MILLIS = 24 * HOUR_MILLIS
    private val MONT_MILLIS = 30 * DAY_MILLIS
    private val YEARS_MILLIS = 12 * MONT_MILLIS

    fun getTimeAgoAsSeparator(time: Long) : String{
        val diff = diffDate(time)

        val hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

        return when {
            diff < hourOfDay * HOUR_MILLIS -> "Today"
            diff < 48 * HOUR_MILLIS -> "Yesterday"
            diff < 30 * DAY_MILLIS -> (diff / DAY_MILLIS).toString() + " days ago"
            diff < 12 * MONT_MILLIS -> (diff / MONT_MILLIS).toString() + " months ago"
            else -> (diff / YEARS_MILLIS).toString() + " years ago"
        }
    }

    fun getTimeAgo(time: Long): String {
        val diff = diffDate(time)
        return when {
            diff < 24 * HOUR_MILLIS -> {
                val  dateFormat = SimpleDateFormat("HH:mm", Locale.US)

                dateFormat.format(time)
            }
            diff < 48 * HOUR_MILLIS -> "yesterday"
            diff < 30 * DAY_MILLIS -> (diff / DAY_MILLIS).toString() + " days ago"
            diff < 12 * MONT_MILLIS -> (diff / MONT_MILLIS).toString() + " months ago"
            else -> (diff / YEARS_MILLIS).toString() + " years ago"
        }
    }

    private fun diffDate(timestamp: Long): Long {
        var time = timestamp
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000
        }

        val now = System.currentTimeMillis()

        if (time <= 0) {
            return 0
        }

        return now - time
    }
}