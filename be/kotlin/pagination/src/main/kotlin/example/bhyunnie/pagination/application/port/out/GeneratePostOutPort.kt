package example.bhyunnie.pagination.application.port.out

import example.bhyunnie.pagination.domain.Post

interface GeneratePostOutPort {
	fun saveAllPost(list:List<Post>): List<Post>
}