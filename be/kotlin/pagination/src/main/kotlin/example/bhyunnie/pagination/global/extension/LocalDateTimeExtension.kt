package example.bhyunnie.pagination.global.extension

import java.time.Duration
import java.time.LocalDateTime

fun LocalDateTime.isExpiredByDays(days: Int):Boolean {
    // 초(seconds)까지 포함 해서 7일을 넘겨야 함
    return Duration.between(this, LocalDateTime.now()) < Duration.ofDays(days.toLong())
}