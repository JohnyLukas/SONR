package com.johnydev.sonr

import androidx.lifecycle.ViewModel
import com.johnydev.sonr.domain.model.FeedPost
import com.johnydev.sonr.domain.model.StatisticItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val sourceList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it.toLong()))
        }
    }

    private val _feedPosts = MutableStateFlow<List<FeedPost>>(sourceList)
    val feedPosts = _feedPosts.asStateFlow()

    fun updateCount(feedPost: FeedPost, item: StatisticItem) {
        val oldPosts = _feedPosts.value.toMutableList()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)

        _feedPosts.value = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
    }

    fun remove(feedPost: FeedPost) {
        val oldPosts = _feedPosts.value.toMutableList()
        oldPosts.remove(feedPost)
        _feedPosts.value = oldPosts
    }
}