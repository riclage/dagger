package com.riclage.common

interface HasServiceCreator {
    fun serviceCreator(): ServiceCreator
}

interface ServiceCreator {
    fun <T> create(javaClass: Class<T>): T
}