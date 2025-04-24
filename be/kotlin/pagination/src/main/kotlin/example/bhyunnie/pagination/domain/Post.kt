package example.bhyunnie.pagination.domain

import example.bhyunnie.pagination.framework.port.out.jpa.entity.PostEntity
import example.bhyunnie.pagination.global.extension.isExpiredByDays
import java.time.LocalDateTime
import java.util.UUID

class Post(
    val id: Long,
    val uuid: UUID,
    val title: String,
    val author: Long,
    val content: String,
    val category: String,
    var deleted: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var modifiedAt: LocalDateTime = LocalDateTime.now(),
    var deletedAt: LocalDateTime?,
    val new: Boolean,
) {
    companion object {
        fun from(entity: PostEntity): Post {
            return Post(
                entity.id,
                entity.uuid,
                entity.title,
                entity.author,
                entity.content,
                entity.category,
                entity.deleted,
                entity.createdAt,
                entity.modifiedAt,
                entity.deletedAt,
                !entity.createdAt.isExpiredByDays(7) // 만 7일 이하 true
            )
        }
    }

    fun toEntity():PostEntity {
        return PostEntity(
            this.id,
            this.uuid,
            this.title,
            this.author,
            this.content,
            this.category,
            this.deleted,
            this.createdAt,
            this.modifiedAt,
            this.deletedAt,
        )
    }
}