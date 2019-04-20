package io.cbedoy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.cbedoy.adapter.ChatAdapter
import io.cbedoy.models.GroupMessage
import io.cbedoy.models.Message
import kotlinx.android.synthetic.main.chat_view_controller.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_view_controller)

        val message = Message()
        message.date = Date()

        val chatAdapter = ChatAdapter()

        for (i in 1..9){
            val groupMessage = GroupMessage()
            groupMessage.user = ChatProvider.getUser()
            groupMessage.date = Date()

            val random = Random()

            val nextInt = random.nextInt(4)

            for (j in 0..nextInt){
                groupMessage.messages.add(ChatProvider.plainMessage())
            }
            chatAdapter.dataModel.add(groupMessage)
        }

        chat_view_controller_recycler_view.adapter = chatAdapter
        chat_view_controller_recycler_view.layoutManager = LinearLayoutManager(this)
        chat_view_controller_recycler_view.hasFixedSize()
    }
}
