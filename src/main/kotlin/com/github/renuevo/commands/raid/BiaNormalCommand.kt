package com.github.renuevo.commands.raid

import com.github.renuevo.commands.Command
import com.github.renuevo.common.MessageCreator
import discord4j.core.spec.EmbedCreateSpec
import org.springframework.stereotype.Component

@Component
class BiaNormalCommand(
        private val messageCreator: MessageCreator
) : Command {
    override val name: String = "!비노"
    override val resource: String = "bia-normal"
    override fun getMessage(): EmbedCreateSpec = messageCreator.getMassage(resource)
}