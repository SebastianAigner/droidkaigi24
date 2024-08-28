import com.jetbrains.workshop.BirdImage
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

class BirdRepository {
    suspend fun getImages(): List<BirdImage> =
        httpClient
            .get("https://sebi.io/demo-image-api/pictures.json")
            .body<List<BirdImage>>()


    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    fun close() {
        httpClient.close()
    }
}