package org.koy.winedb.model

import javax.persistence.*

@Entity
class Vintage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @OneToMany
    var vintageNotes: MutableSet<VintageNote> = mutableSetOf()

    @OneToMany
    var wines : MutableSet<Wine> = mutableSetOf()
}