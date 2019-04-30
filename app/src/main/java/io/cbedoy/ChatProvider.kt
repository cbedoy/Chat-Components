package io.cbedoy

import io.cbedoy.models.GroupMessage
import io.cbedoy.models.Message
import io.cbedoy.models.Reaction
import io.cbedoy.models.User
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

object ChatProvider {

    private val users = ArrayList<User>()
    private val messages = ArrayList<Message>()
    private val reactions = ArrayList<Reaction>()

    init {
        initReactions()
        initUsers()
        initMessages()
    }

    fun addMessage(message: Message){
        messages.add(message)
    }


    fun getUser() : User{
        return users.shuffled()[0]
    }

    fun plainMessage() : Message{
        return messages.shuffled()[0]
    }

    fun randomReactions(count: Int) : ArrayList<Reaction>{
        val list = ArrayList<Reaction>()
        if (count > 0) {
            reactions.shuffled().subList(0, count).forEach {
                list.add(it)
            }
        }

        return list
    }

    fun groupMessage() : GroupMessage{
        val groupMessage = GroupMessage()
        groupMessage.user = ChatProvider.getUser()
        groupMessage.date = Date()

        val random = Random(System.currentTimeMillis())

        val nextInt = random.nextInt(4)

        for (j in 0..nextInt){
            groupMessage.messages.add(ChatProvider.plainMessage())
        }

        return groupMessage
    }

    fun groupMessagesCount(count: Int) : ArrayList<GroupMessage>{
        val messages = ArrayList<GroupMessage>()

        for (i in 1..count){
            messages.add(ChatProvider.groupMessage())
        }

        return messages
    }

    private fun initMessages() {

        val random = Random(System.currentTimeMillis())

        messages.add(Message("Build the project and then use the generated API"))
        messages.add(Message("A classic love heart emoji, used for expressions of love. Displayed in various shades of red on most platforms. A similar emoji exists for the heart suit in a deck of playing cards."))
        messages.add(Message("Hello everyone"))
        messages.add(Message("any device that perceives its environment and takes actions that maximize"))
        messages.add(Message("experience to inform future decisions. Human-inspired AI"))
        messages.add(Message("AI research include reasoning, knowledge representation, planning, learning, natural language processing, perception and the ability to move and manipulate objects.[14] General intelligence is among the field's long-term goals"))
        messages.add(Message("nging problems in compu"))
        messages.add(Message("with concurrent discoveries i"))
        messages.add(Message("the machine could be considered \"intelligent\""))
        messages.add(Message("AI's founders were optimistic about the future"))
        messages.add(Message("Progress slowed and in 1974"))
        messages.add(Message("First of all, you must have a basic knowledge of the Java language for Android Development. "))
        messages.add(Message("Emojipedia® is a registered trademark of Emojipedia Pty Ltd; Apple® is a registered trademark of Apple Inc; Microsoft® and Windows® are registered trademarks of Microsoft Corporation; Google® and Android™ are registered trademarks or trademarks of Google Inc in the United States and/or other countries."))
        messages.add(Message("Being comfortable with the course or the book is very important"))
        messages.add(Message("Understand the Activity Lifecycle as having the knowledge of the activity lifecycle is very"))
        messages.add(Message("Learn how to handle the configuration changes. Some device configurations can change during the runtime such as screen orientation, keyboard availability, and when the user enables multi-window mode. We must know how to handle these changes"))
        messages.add(Message("Know about the 3rd party libraries. We have Mindorks Android Store to browse through all the important Android libraries, projects, tools, and apps. Compare them with their GitHub stars."))
        messages.add(Message("They are not old school, but a neat structure on which a complex android framework is built."))
        messages.add(Message("possible knowledge, by considering every possible hypothesis and matching them against the data. In practice, it is almost never possible to"))
        messages.add(Message("This doesn't work. as you've set, it's the background, so the content overrides the rounded corners, and if you have content that draws on the corners, you won't see them being rounded."))
        messages.add(Message("Approximately 33% of people with influenza are asymptomatic."))
        messages.add(Message("influenza in the early stages of these infections"))
        messages.add(Message("These viruses are only distantly related to the human parainfluenza viruses, which are RNA viruses belonging to the paramyxovirus family that are a common cause of respiratory infections in children such as croup,[37] but can also cause a disease similar to influenza in adults."))
        messages.add(Message("Viruses can replicate only in living cells"))
        messages.add(Message("\uD83D\uDE48 \uD83D\uDE48 \uD83D\uDE48"))
        messages.add(Message("\uD83D\uDE48 \uD83D\uDE49 \uD83D\uDE4A"))

        messages.forEach {
            it.reactions = randomReactions(random.nextInt(3))
        }
    }

    private fun initUsers() {
        users.add(User("Paola Macias",
            "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p80x80/57154387_100114481190675_6567880125235331072_n.jpg?_nc_cat=107&_nc_ht=scontent.fmex4-1.fna&oh=d97c6f1b7c6dfc2c9da116fa27d9160e&oe=5D48CCCE"))
        users.add(User("Majo Vega",
            "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p80x80/56887147_10215081640169465_7650365540577312768_n.jpg?_nc_cat=102&_nc_ht=scontent.fmex4-1.fna&oh=2afc1bcb666f0bc74732b76d38eba396&oe=5D3E8469"))
        users.add(User("Luis Guerra",
            "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p80x80/52708390_10156989264790040_8642131174929465344_n.jpg?_nc_cat=109&_nc_ht=scontent.fmex4-1.fna&oh=65cb961151c2fa3f9ccde8d20bd78ec1&oe=5D760C40"))
        users.add(User("Areceli Guadalajara",
            "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/c0.16.80.80a/p80x80/12249930_10206614919124911_5201185869058032218_n.jpg?_nc_cat=102&_nc_ht=scontent.fmex4-1.fna&oh=b4112901d3872f639d1c182322de02de&oe=5D71ED28"))
        users.add(User("Gabriela Martinez",
            "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p80x80/43708883_10160994972645652_9223202282567368704_n.jpg?_nc_cat=110&_nc_ht=scontent.fmex4-1.fna&oh=4e0a3f182fe7c27b876b363ba1774542&oe=5D41A9F6"))
        users.add(User("Katy Romo",
            "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p80x80/49644349_2241405745890572_3837882479629303808_n.jpg?_nc_cat=104&_nc_ht=scontent.fmex4-1.fna&oh=62ebf050546a9d838fff4e5ad2f2a7cd&oe=5D37A608"))
        users.add(User("Josseline Alvarez",
            "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p80x80/53392897_2169108149849175_4519516174874050560_n.jpg?_nc_cat=108&_nc_ht=scontent.fmex4-1.fna&oh=9d8efcbfd8d3a2d6218bbb1b548bf29d&oe=5D318DC8"))
        users.add(User("Carlos Bedoy",
            "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p160x160/54800084_3148146541878356_6275916731013660672_n.jpg?_nc_cat=105&_nc_ht=scontent.fmex4-1.fna&oh=c924e733610d807e29fd0f790272e830&oe=5D31F71C"))
        users.add(User("Ramona Duarte",
            "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/c1.0.160.160a/p160x160/56624548_107477090443422_6267208538792132608_n.jpg?_nc_cat=104&_nc_ht=scontent.fmex4-1.fna&oh=be6f28a5935ff90ee1acedc055bc6328&oe=5D345F72"))
        users.add(User("Agelica Montez",
            "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p160x160/56591023_1045850578947136_1992680661441314816_n.jpg?_nc_cat=107&_nc_ht=scontent.fmex4-1.fna&oh=0ea4d45b3f583a06aae7a87de11b92eb&oe=5D3486A3"))
        users.add(User("Diana de Alba",
            "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p160x160/55468499_152570762436836_9060406546554421248_n.jpg?_nc_cat=105&_nc_ht=scontent.fmex4-1.fna&oh=7e611f8845909eb079054bdcd7263936&oe=5D3C0FA6"))
        users.add(User("Patricia Ruíz",
            "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/p160x160/56398402_10161703493715333_96243413875163136_n.jpg?_nc_cat=103&_nc_ht=scontent.fmex4-1.fna&oh=a3671231ec037694ad2b9f3ad6972145&oe=5D2DC7B1"))
    }

    private fun initReactions(){
        val random = Random(System.currentTimeMillis())

        arrayListOf(
            "\uD83D\uDE4A",
            "\uD83D\uDE49",
            "\uD83D\uDE4A",
            "\uD83E\uDD2A",
            "\uD83D\uDE0F",
            "\uD83D\uDE11",
            "\uD83D\uDE10",
            "\uD83D\uDE2A",
            "\uD83C\uDF47",
            "\uD83E\uDD6D",
            "\uD83E\uDD5D",
            "\uD83C\uDF46",
            "\uD83E\uDD51",
            "\uD83C\uDF4E",
            "\uD83C\uDF4D",
            "\uD83D\uDC3D",
            "\uD83D\uDC03",
            "\uD83D\uDC39",
            "\uD83E\uDD87",
            "\uD83D\uDEA3",
            "\uD83C\uDFDF️",
            "\uD83C\uDFDC️",
            "\uD83C\uDF0B"
        ).forEach {
            val count = random.nextInt(10) + 1

            reactions.add(Reaction(it, count))
        }
    }
}