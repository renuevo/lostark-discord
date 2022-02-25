package com.github.renuevo.commands

import discord4j.core.spec.EmbedCreateSpec

interface Command {
    val name: String
    val resource: String
    fun getMessage(): EmbedCreateSpec
}