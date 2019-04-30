package io.cbedoy.models

class Reaction{
    lateinit var identifier: String
    lateinit var emoji: String
    var count: Int = 0


    constructor(emoji: String, count: Int){
        this.emoji = emoji
        this.count = count
    }
}