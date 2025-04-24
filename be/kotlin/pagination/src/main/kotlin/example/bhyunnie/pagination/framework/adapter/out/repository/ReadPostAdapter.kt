package example.bhyunnie.pagination.framework.adapter.out.repository

import example.bhyunnie.pagination.application.port.out.ReadPostOutPort
import example.bhyunnie.pagination.framework.port.out.jpa.repository.PostJpaRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
class ReadPostAdapter(
    private val postJpaRepository: PostJpaRepository
):ReadPostOutPort {

}