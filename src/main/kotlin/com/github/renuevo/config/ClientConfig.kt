package com.github.renuevo.config

import discord4j.core.DiscordClientBuilder
import discord4j.core.GatewayDiscordClient
import discord4j.core.`object`.presence.ClientActivity
import discord4j.core.`object`.presence.ClientPresence
import discord4j.rest.RestClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientConfig(@Value("\${discord.token}") private val token: String) {

    @Bean
    fun gatewayDiscordClient(): GatewayDiscordClient = DiscordClientBuilder.create(token).build()
            .gateway()
            .setInitialPresence { ClientPresence.online(ClientActivity.playing("Booting up")) }
            .login()
            .block()!!

    @Bean
    fun discordRestClient(client: GatewayDiscordClient): RestClient = client.restClient

}