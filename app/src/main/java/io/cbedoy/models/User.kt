package io.cbedoy.models

class User{
    lateinit var identifier: String
    lateinit var nickname: String
    lateinit var avatar: String

    constructor()

    constructor(identifier: String, nickname: String, avatar: String){
        this.identifier = identifier
        this.nickname = nickname
        this.avatar = avatar
    }

    constructor(nickname: String, avatar: String){
        this.identifier = nickname.toLowerCase().replace(" ", "_")
        this.nickname = nickname
        this.avatar = avatar
    }
}