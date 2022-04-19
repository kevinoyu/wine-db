package org.koy.winedb.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @get: NotBlank
    var name: String = ""

    @ManyToOne
    var vintage: Vintage = Vintage()

    @ManyToMany
    var grapes: MutableSet<Grape> = mutableSetOf()

}