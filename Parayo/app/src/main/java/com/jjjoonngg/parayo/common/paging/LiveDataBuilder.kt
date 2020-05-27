package com.jjjoonngg.parayo.common.paging

import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList


interface LiveDataPagedListBuilder<K, T> {

    fun createDateSource(): DataSource<K, T>

    private fun factory() = object :
        DataSource.Factory<K, T>() {
        override fun create(): DataSource<K, T> = createDateSource()
    }

    private fun config() = PagedList.Config.Builder()
        .setPageSize(10)
        .setEnablePlaceholders(false)
        .build()

    fun buildPagedList() = LivePagedListBuilder(factory(), config()).build()
}