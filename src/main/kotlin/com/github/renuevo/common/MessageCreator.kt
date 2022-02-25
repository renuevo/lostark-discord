package com.github.renuevo.common

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import discord4j.core.spec.EmbedCreateSpec
import discord4j.rest.util.Color
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class MessageCreator {

    private val objectMapper = ObjectMapper().registerModule(kotlinModule())!!

    fun getMassage(resource: String): EmbedCreateSpec {
        val messageModel = objectMapper.readValue(ClassPathResource("./commands/${resource}.json").file, MessageModel::class.java)
        return EmbedCreateSpec.builder().apply {
            color(Color.RED)
            title(messageModel.title)
            messageModel.url?.let { url(it) }
            messageModel.image?.let { image(it) }
            messageModel.addFields.forEach { addField(it.name, it.value, it.inline) }
            timestamp(Instant.now())
        }.build()
    }

}