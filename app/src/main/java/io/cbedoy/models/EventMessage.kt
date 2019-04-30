package io.cbedoy.models

import io.cbedoy.holders.protocols.IBaseMessage
import java.util.*

class EventMessage : IBaseMessage{

    lateinit var date: Date
    lateinit var event: String

    override fun getMessageType(): IBaseMessage.MESSAGE {
        return IBaseMessage.MESSAGE.event
    }
}