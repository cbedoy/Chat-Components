package io.cbedoy.holders.protocols

interface IBaseMessageType{
    fun getType() : TYPE

    enum class TYPE{
        link, plain, media, image
    }
}