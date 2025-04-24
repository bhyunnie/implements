package example.bhyunnie.pagination.application.usecase

import example.bhyunnie.pagination.application.port.`in`.ReadPostInPort
import example.bhyunnie.pagination.application.port.out.ReadPostOutPort
import org.springframework.stereotype.Service

@Service
class ReadPostUsecase(
    private val readPostOutPort: ReadPostOutPort
):ReadPostInPort {

}