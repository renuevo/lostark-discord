package com.github.renuevo.commands.raid

import com.github.renuevo.commands.Command
import com.github.renuevo.common.MessageCreator
import discord4j.core.spec.EmbedCreateSpec
import org.springframework.stereotype.Component

@Component
class CooNormalCommand(
        private val messageCreator: MessageCreator
) : Command {
    override val name: String = "!쿠노"
    override val resource: String = "coo-normal"
    override fun getMessage(): EmbedCreateSpec = messageCreator.getMassage(resource)
}