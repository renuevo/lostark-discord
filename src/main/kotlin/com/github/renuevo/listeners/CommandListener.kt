package com.github.renuevo.listeners

import com.github.renuevo.commands.Command
import com.github.renuevo.commands.TraderCommand
import discord4j.core.GatewayDiscordClient
import discord4j.core.event.domain.message.MessageCreateEvent
import discord4j.core.spec.EmbedCreateSpec
import discord4j.rest.util.Color
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.mono
import org.springframework.stereotype.Component
import java.time.Instant


@Component
class CommandListener(
        private val commands: List<Command>,
        private val client: GatewayDiscordClient,
        private val traderCommand: TraderCommand
) {

    init {
        mono {
            client.on(MessageCreateEvent::class.java)
                    .asFlow()
                    .collect {
                        commands.filter { command -> command.name == it.message.content }
                                .map { command ->
                                    val channel = it.message.channel.awaitSingle()
                                    channel.createMessage(command.getMessage()).awaitSingle()
                                }

                        if (it.message.content.startsWith("!")) {
                            val messageList = it.message.content.split(" ")
                            if (messageList.size == 2) {
                                when (messageList[0]) {
                                    "!떠상" -> {
                                        traderCommand.traderModelMap.keys
                                                .filter { key -> key.contains(messageList[1]) }
                                                .forEach { key ->
                                                    val channel = it.message.channel.awaitSingle()
                                                    channel.createMessage(traderCommand.getMessage(key)).awaitSingle()
                                                }
                                    }
                                    "!정보" -> {
                                        //todo
                                    }
                                    "!모코코" -> {
                                        //todo
                                    }
                                    "!로아와" -> {
                                        val channel = it.message.channel.awaitSingle()
                                        channel.createMessage(EmbedCreateSpec.builder().apply {
                                            color(Color.RED)
                                            title("로아와 검색 - ${messageList[1]}")
                                            url("https://loawa.com/char/${messageList[1]}")
                                            timestamp(Instant.now())
                                        }.build()).awaitSingle()
                                    }
                                }
                            }
                        }
                    }
        }.block()
    }
}