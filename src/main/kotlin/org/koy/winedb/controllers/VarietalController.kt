package org.koy.winedb.controllers

import org.koy.winedb.model.Varietal
import org.koy.winedb.repository.VarietalRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class VarietalController(private val varietalRepository: VarietalRepository) {

    @GetMapping("/varietals")
    fun getAllVarietals(): List<Varietal> = varietalRepository.findAll()

    @GetMapping("/varietals/{id}")
    fun getVarietalById(@PathVariable(value = "id") varietalId: Long): ResponseEntity<Varietal> {
        return varietalRepository.findById(varietalId).map { varietal ->
            ResponseEntity.ok(varietal)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/varietals")
    fun createNewVarietal(@Valid @RequestBody varietal: Varietal): Varietal = varietalRepository.save(varietal)

    @DeleteMapping("/varietals/{id}")
    fun deleteVarietalById(@PathVariable(value = "id") varietalId: Long): ResponseEntity<Void> {
        return varietalRepository.findById(varietalId).map { varietal ->
            varietalRepository.delete(varietal)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}