package com.github.renuevo.commands.raid

import com.github.renuevo.commands.Command
import com.github.renuevo.common.MessageCreator
import discord4j.core.spec.EmbedCreateSpec
import org.springframework.stereotype.Component

@Component
class CowHardCommand(
        private val messageCreator: MessageCreator
) : Command {
    override val name: String = "!발하"
    override val resource: String = "cow-hard"
    override fun getMessage(): EmbedCreateSpec = messageCreator.getMassage(resource)
}