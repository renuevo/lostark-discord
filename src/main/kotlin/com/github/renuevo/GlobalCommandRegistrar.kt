package com.github.renuevo

import discord4j.rest.RestClient
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component


@Component
class GlobalCommandRegistrar(private val client: RestClient) : ApplicationRunner {

    @Override
    override fun run(args: ApplicationArguments) {
//        val d4jMapper = JacksonResources.create()
//        val matcher = PathMatchingResourcePatternResolver()
        val applicationService = client.applicationService
        val applicationId = client.applicationId.block()!!

        /*
        val commands: List<ApplicationCommandRequest> = matcher.getResources("commands/*.json")
                .map { d4jMapper.objectMapper.readValue(it.inputStream, ApplicationCommandRequest::class.java) }

        applicationService.bulkOverwriteGlobalApplicationCommand(applicationId, commands).subscribe()
         */
         */


        applicationService.getGlobalApplicationCommands(applicationId).subscribe()
    }
}