package com.github.renuevo.commands

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.github.renuevo.common.TraderModel
import discord4j.core.spec.EmbedCreateSpec
import discord4j.rest.util.Color
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class TraderCommand {

    private val objectMapper = ObjectMapper().registerModule(kotlinModule())!!
    val traderModelMap: Map<String, TraderModel> = objectMapper.readValue(ClassPathResource("./commands/trader/trader.json").file, object : TypeReference<List<TraderModel>>() {}).associateBy { it.name }

    fun getMessage(key: String) = EmbedCreateSpec.builder().apply {
        color(Color.RED)
        title(traderModelMap[key]!!.name)
        image(traderModelMap[key]!!.image)
        timestamp(Instant.now())
    }.build()
}