package ru.pdn.sfedu.operationshistory.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.InboundChannelAdapter
import org.springframework.integration.annotation.Poller
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.integration.config.EnableIntegration
import org.springframework.integration.file.FileReadingMessageSource
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import org.springframework.xml.transform.StringSource
import java.io.File

@Configuration
@EnableIntegration
class IntegrationConfig(
        private val operationsMarshaller: Jaxb2Marshaller
) {
    @Bean
    @InboundChannelAdapter(value = "operationsFileChannel", poller = [Poller(fixedDelay = "5000")])
    fun fileSource() = FileReadingMessageSource().apply {
        setDirectory(File("c:/operations/in"))
    }

    @ServiceActivator(inputChannel = "operationsFileChannel", outputChannel = "nullChannel")
    fun fileProcessor(file: File) {
        val operations = operationsMarshaller.unmarshal(StringSource(file.readText()))
        println(file.name)
        println(operations)
    }
}