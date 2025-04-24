package example.bhyunnie.pagination.global.config

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.opencsv.CSVReader
import org.openjdk.jol.info.GraphLayout
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.io.InputStreamReader
import java.time.LocalDateTime

@Configuration
class StringPoolConfig {
    @Bean
    fun stringPool():List<String> {
        val mapper = ObjectMapper()
        val resource = ClassPathResource("korean_string_pool.csv")
        val reader = CSVReader(InputStreamReader(resource.inputStream))
        val result = mutableListOf<String>()
        val header = reader.readNext()
        val exampleIndex = header.indexOf("example")
        reader.forEach { row ->
            val raw = row.getOrNull(exampleIndex)
            if (!raw.isNullOrBlank() && raw != "null") {
                try {
                    val nested: List<List<String>> = mapper.readValue(raw, object : TypeReference<List<List<String>>>() {})
                    result.addAll(nested.flatten())
                } catch (e: Exception) {
                    println("예문 파싱 실패: $raw")
                }
            }
        }

        println("✅ 전역 설정으로 예문 ${result.size}개 로드됨")
        val layout = GraphLayout.parseInstance(result)
        return result.toList()
    }
}