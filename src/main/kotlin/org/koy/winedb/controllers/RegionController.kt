package org.koy.winedb.controllers

import org.koy.winedb.model.Region
import org.koy.winedb.repository.RegionRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class RegionController(private val regionRepository: RegionRepository) {

    @GetMapping("/regions")
    fun getAllRegions(): List<Region> = regionRepository.findAll()

    @GetMapping("/regions/{id}")
    fun getRegionById(@PathVariable(value = "id") regionId: Long): ResponseEntity<Region> {
        return regionRepository.findById(regionId).map { region ->
            ResponseEntity.ok(region)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/regions")
    fun createNewRegion(@Valid @RequestBody region: Region): Region = regionRepository.save(region)

    @DeleteMapping("/regions/{id}")
    fun deleteRegionById(@PathVariable(value = "id") regionId: Long): ResponseEntity<Void> {
        return regionRepository.findById(regionId).map { region ->
            regionRepository.delete(region)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}