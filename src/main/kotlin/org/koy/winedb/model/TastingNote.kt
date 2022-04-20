package org.koy.winedb.model

import javax.persistence.*

@Entity
class TastingNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @ManyToOne
    lateinit var wine: Wine

    @ManyToOne
    lateinit var user: User

    var note : String = ""
}