package org.koy.winedb.controllers

import org.koy.winedb.model.Vintage
import org.koy.winedb.repository.VintageRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class VintageController(private val vintageRepository: VintageRepository) {

    @GetMapping("/vintages")
    fun getAllVintages(): List<Vintage> = vintageRepository.findAll()

    @GetMapping("/vintages/{id}")
    fun getVintageById(@PathVariable(value = "id") vintageId: Long): ResponseEntity<Vintage> {
        return vintageRepository.findById(vintageId).map { vintage ->
            ResponseEntity.ok(vintage)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/vintages")
    fun createNewVintage(@Valid @RequestBody vintage: Vintage): Vintage = vintageRepository.save(vintage)

    @DeleteMapping("/vintages/{id}")
    fun deleteVintageById(@PathVariable(value = "id") vintageId: Long): ResponseEntity<Void> {
        return vintageRepository.findById(vintageId).map { vintage ->
            vintageRepository.delete(vintage)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}