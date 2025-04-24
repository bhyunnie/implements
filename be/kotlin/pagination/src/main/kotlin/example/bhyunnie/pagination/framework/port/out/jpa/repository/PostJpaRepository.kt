package example.bhyunnie.pagination.framework.port.out.jpa.repository

import example.bhyunnie.pagination.framework.port.out.jpa.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostJpaRepository:JpaRepository<PostEntity, Long>