package org.koy.winedb.controllers

import org.koy.winedb.model.Wine
import org.koy.winedb.repository.WineRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class WineController(private val wineRepository: WineRepository) {

    @GetMapping("/wines")
    fun getAllWines(): List<Wine> = wineRepository.findAll()

    @GetMapping("/wines/{id}")
    fun getWineById(@PathVariable(value = "id") wineId: Long): ResponseEntity<Wine> {
        return wineRepository.findById(wineId).map { wine ->
            ResponseEntity.ok(wine)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/wines/search/{searchTerm}")
    fun searchForWine(@PathVariable(value="searchTerm") searchTerm : Long) : List<Wine> {
        TODO("implement search by name, description, etc")
    }

    @PostMapping("/wines")
    fun createNewWine(@Valid @RequestBody wine: Wine): Wine = wineRepository.save(wine)

    @DeleteMapping("/wines/{id}")
    fun deleteWineById(@PathVariable(value = "id") wineId: Long): ResponseEntity<Void> {
        return wineRepository.findById(wineId).map { wine ->
            wineRepository.delete(wine)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}