package com.github.renuevo.common

data class MessageModel(
        val title: String,
        val url: String? = null,
        val image: String? = null,
        val addFields: List<MessageField>
)

data class MessageField(
        val name: String,
        val value: String,
        val inline: Boolean
)