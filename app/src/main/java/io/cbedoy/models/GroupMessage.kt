package io.cbedoy.models

import java.util.Date

class GroupMessage {
    var messages = ArrayList<Any>()
    lateinit var date: Date
    lateinit var user: User
}