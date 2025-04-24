package example.bhyunnie.pagination.application.port.`in`

import example.bhyunnie.pagination.application.port.`in`.command.GeneratePostCommand

interface GeneratePostInPort {
    fun generate(command: GeneratePostCommand)
}