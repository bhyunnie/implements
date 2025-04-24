package example.bhyunnie.pagination.framework.adapter.`in`.web

import example.bhyunnie.pagination.application.port.`in`.GeneratePostInPort
import example.bhyunnie.pagination.application.port.`in`.command.GeneratePostCommand
import example.bhyunnie.pagination.framework.adapter.`in`.dto.GeneratePostDto
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController(
    private val generatePostInPort: GeneratePostInPort
) {
    @PostMapping("/post/generate")
    fun generate(
        @ModelAttribute generatePostDto: GeneratePostDto
    ) {
        generatePostInPort.generate(
            GeneratePostCommand(generatePostDto.count)
        )
    }
}