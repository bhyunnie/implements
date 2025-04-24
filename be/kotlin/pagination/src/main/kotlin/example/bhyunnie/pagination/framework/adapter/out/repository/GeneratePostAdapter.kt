package example.bhyunnie.pagination.framework.adapter.out.repository

import example.bhyunnie.pagination.application.port.out.GeneratePostOutPort
import example.bhyunnie.pagination.domain.Post
import example.bhyunnie.pagination.framework.port.out.jpa.repository.PostJpaRepository
import org.springframework.stereotype.Repository

@Repository
class GeneratePostAdapter(
	private val postJpaRepository: PostJpaRepository
):GeneratePostOutPort {
	override fun saveAllPost(list: List<Post>): List<Post> {
		return postJpaRepository.saveAll(list.map{it.toEntity()}).map{ Post.from(it) }
	}
}