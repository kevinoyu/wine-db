package org.koy.winedb.controllers

import org.koy.winedb.model.Producer
import org.koy.winedb.repository.ProducerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ProducerController(private val producerRepository: ProducerRepository) {

    @GetMapping("/producers")
    fun getAllProducers(): List<Producer> = producerRepository.findAll()

    @GetMapping("/producers/{id}")
    fun getProducerById(@PathVariable(value = "id") producerId: Long): ResponseEntity<Producer> {
        return producerRepository.findById(producerId).map { producer ->
            ResponseEntity.ok(producer)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/producers")
    fun createNewProducer(@Valid @RequestBody producer: Producer): Producer = producerRepository.save(producer)

    @DeleteMapping("/producers/{id}")
    fun deleteProducerById(@PathVariable(value = "id") producerId: Long): ResponseEntity<Void> {
        return producerRepository.findById(producerId).map { producer ->
            producerRepository.delete(producer)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}