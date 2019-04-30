package io.cbedoy.holders.protocols

interface IBaseMessage {

    fun getMessageType(): MESSAGE{
        return MESSAGE.any
    }

    enum class MESSAGE{
        group, date, event, any
    }
}