package org.koy.winedb.model

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.validation.constraints.NotBlank

@Entity
class Grape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @get: NotBlank
    var color: String = ""

    @ManyToMany(cascade = [CascadeType.ALL], mappedBy = "grapes")
    var wines: MutableSet<Wine> = mutableSetOf()

    @ManyToMany
    var appellations: MutableSet<Appellation> = mutableSetOf()
}