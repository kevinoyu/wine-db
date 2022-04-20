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
    lateinit var vintage: Vintage

    @ManyToOne
    lateinit var producer: Producer

    @ManyToOne
    lateinit var region: Region

    @ManyToMany
    var varietals: MutableSet<Varietal> = mutableSetOf()

    var price: Double = 0.0
}