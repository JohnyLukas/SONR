package com.johnydev.sonr.ui.navigation

sealed class Screen(
    val route: String
) {
    data object NewsFeed: Screen(ROUTE_NEWS_FEED)
    data object Messages: Screen(ROUTE_MESSAGES)
    data object Profile: Screen(ROUTE_PROFILE)

    private companion object {
        const val ROUTE_NEWS_FEED = "news_feed"
        const val ROUTE_MESSAGES = "messages"
        const val ROUTE_PROFILE = "profile"
    }
}