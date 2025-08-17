import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO

object KtorClient {

    val client = HttpClient(CIO) {
        engine {
            requestTimeout = 5000
        }
    }

}