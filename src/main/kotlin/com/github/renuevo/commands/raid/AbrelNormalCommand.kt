package com.github.renuevo.commands.raid

import com.github.renuevo.commands.Command
import com.github.renuevo.common.MessageCreator
import discord4j.core.spec.EmbedCreateSpec
import org.springframework.stereotype.Component

@Component
class AbrelNormalCommand(
        private val messageCreator: MessageCreator
) : Command {
    override val name: String = "!아노"
    override val resource: String = "abrel-normal"
    override fun getMessage(): EmbedCreateSpec = messageCreator.getMassage(resource)
}