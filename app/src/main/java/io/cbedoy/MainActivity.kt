package io.cbedoy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.cbedoy.adapter.ChatAdapter
import io.cbedoy.models.DateMessage
import io.cbedoy.models.EventMessage
import io.cbedoy.models.GroupMessage
import kotlinx.android.synthetic.main.chat_view_controller.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val chatAdapter = ChatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_view_controller)

        chat_view_controller_recycler_view.adapter = chatAdapter
        chat_view_controller_recycler_view.layoutManager = LinearLayoutManager(this)
        chat_view_controller_recycler_view.hasFixedSize()

        chatAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()

        runOnUiThread {
            val dateMessage = DateMessage()
            dateMessage.date = Date()
            chatAdapter.dataModel.add(dateMessage)

            ChatProvider.groupMessagesCount(4).forEach {
                chatAdapter.dataModel.add(it)
            }

            chatAdapter.notifyDataSetChanged()
        }
    }
}
