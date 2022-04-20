package org.koy.winedb.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var name : String = ""
    var classification : String = ""

    @OneToMany
    var wines : MutableSet<Wine> = mutableSetOf()

    @ManyToMany
    var regions : MutableSet<Region> = mutableSetOf()

}