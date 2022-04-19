package org.koy.winedb.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne

@Entity
class Appellation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @ManyToOne
    var country: Country? = null

    @ManyToMany
    var producers: Set<Producer> = mutableSetOf()

}