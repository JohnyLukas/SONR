package com.johnydev.sonr.domain.model

import com.johnydev.sonr.R

data class FeedPost(
    val id: Long,
    val communityName: String = "/dev/null",
    val publicationDate: String = "15:04",
    val communityAvatar: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "Будьте вежливы и соблюдайте наши принципы сообщества.",
    val contentImage: Int = R.drawable.post_content_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, 966),
        StatisticItem(type = StatisticType.SHARES, 7),
        StatisticItem(type = StatisticType.COMMENTS, 8),
        StatisticItem(type = StatisticType.LIKES, 27),
    )
)