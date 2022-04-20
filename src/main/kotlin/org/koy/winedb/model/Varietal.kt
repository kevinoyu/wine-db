package org.koy.winedb.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Varietal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var description : String = ""

    @get: NotBlank
    var color: String = ""

    @ManyToMany(cascade = [CascadeType.ALL], mappedBy = "varietals")
    var wines: MutableSet<Wine> = mutableSetOf()

    @ManyToMany
    var regions: MutableSet<Region> = mutableSetOf()
}