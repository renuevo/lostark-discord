package com.github.renuevo.commands

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.github.renuevo.domain.MokokoModel
import discord4j.core.spec.EmbedCreateSpec
import discord4j.rest.util.Color
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class MokokoCommand {

    private val objectMapper = ObjectMapper().registerModule(kotlinModule())!!
    val mokokoModelMap: Map<String, MokokoModel> = objectMapper.readValue(ClassPathResource("./commands/mokoko/mokoko.json").file, object : TypeReference<List<MokokoModel>>() {}).associateBy { it.name }

    fun getMessage(key: String) = EmbedCreateSpec.builder().apply {
        color(Color.RED)
        title("${mokokoModelMap[key]!!.name} - 블로그 설명")
        url(mokokoModelMap[key]!!.url)
        image(mokokoModelMap[key]!!.image)
        timestamp(Instant.now())
    }.build()
}