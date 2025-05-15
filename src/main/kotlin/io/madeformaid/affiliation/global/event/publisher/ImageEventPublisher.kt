package io.madeformaid.affiliation.global.event.publisher

import event.ImageEvent
import event.ImageEvent.ImageUnusingEvent
import event.ImageEvent.ImageUsingEvents
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ImageEventPublisher(
    private val kafkaTemplate: KafkaTemplate<String, ByteArray>,
) {
    fun publishImagesUsing(event: ImageUsingEvents, usedById: String) {
        kafkaTemplate.send("images-using", usedById, event.toByteArray())
    }

    fun publishImagesUnusing(event: ImageEvent.ImageUnusingEvents, usedById: String) {
        kafkaTemplate.send("images-unusing", usedById, event.toByteArray())
    }
}
