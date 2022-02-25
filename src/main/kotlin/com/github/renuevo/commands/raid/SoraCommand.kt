package com.github.renuevo.commands.raid

import com.github.renuevo.commands.Command
import com.github.renuevo.common.MessageCreator
import discord4j.core.spec.EmbedCreateSpec
import org.springframework.stereotype.Component

@Component
class SoraCommand(
        private val messageCreator: MessageCreator
) : Command {
    override val name: String = "!태수야"
    override val resource: String = "sora"
    override fun getMessage(): EmbedCreateSpec = messageCreator.getMassage(resource)
}