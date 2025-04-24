package example.bhyunnie.pagination.application.usecase

import example.bhyunnie.pagination.application.port.`in`.GeneratePostInPort
import example.bhyunnie.pagination.application.port.`in`.command.GeneratePostCommand
import example.bhyunnie.pagination.application.port.out.GeneratePostOutPort
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class GeneratePostUsecase(
    private val stringPool: List<String>,
    private val generatePostOutPort: GeneratePostOutPort
): GeneratePostInPort {
    override fun generate(command: GeneratePostCommand) {
        val startTime = System.currentTimeMillis()
        val sentences = arrayListOf<String>()
        repeat(command.count) {
            sentences.add(generateSentence())
        }
    }

    private fun generateSentence(): String {
        val poolSize = stringPool.size
        val sb = StringBuilder()
        // 문장 개수 랜덤 1~4
        val pickCount = Random.nextInt(1,4)
        // 문장 범위 stringPool.size
        repeat(pickCount) {
            val string = stringPool[Random.nextInt(poolSize)]
            sb.append(string).append(" ")
        }
        return sb.toString()
    }
}