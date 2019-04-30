package io.cbedoy.models

import io.cbedoy.holders.protocols.IBaseMessage
import java.util.*

class DateMessage : IBaseMessage {
    lateinit var date: Date

    override fun getMessageType(): IBaseMessage.MESSAGE {
        return IBaseMessage.MESSAGE.date
    }
}