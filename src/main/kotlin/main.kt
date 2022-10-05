import okhttp3.*

private val client = OkHttpClient()

fun main() {
    val request = Request.Builder()
        .url("ws://localhost:8080/listenotp")
        .build()
    val listener = ListenOTPListener()
    client.newWebSocket(request, listener)
}

private class ListenOTPListener: WebSocketListener() {
    override fun onMessage(webSocket: WebSocket, text: String) {
        println("recv:$text")
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        println("error:${t.message}")
    }
}