package com.github.renuevo.commands.raid

import com.github.renuevo.commands.Command
import com.github.renuevo.common.MessageCreator
import discord4j.core.spec.EmbedCreateSpec
import org.springframework.stereotype.Component

@Component
class CowNormalCommand(
        private val messageCreator: MessageCreator
) : Command {
    override val name: String = "!발노"
    override val resource: String = "cow-normal"
    override fun getMessage(): EmbedCreateSpec = messageCreator.getMassage(resource)
}