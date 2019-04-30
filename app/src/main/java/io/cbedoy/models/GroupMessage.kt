package io.cbedoy.models


import io.cbedoy.holders.protocols.IBaseMessage
import io.cbedoy.holders.protocols.IBaseMessageType
import java.util.*

class GroupMessage : IBaseMessage {
    var messages = ArrayList<IBaseMessageType>()
    lateinit var user: User
    lateinit var date: Date

    override fun getMessageType(): IBaseMessage.MESSAGE {
        return IBaseMessage.MESSAGE.group
    }
}