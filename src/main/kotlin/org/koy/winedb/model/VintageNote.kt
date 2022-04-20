package org.koy.winedb.model

import javax.persistence.*

@Entity
class VintageNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @ManyToOne
    var vintage: Vintage? = null

    @ManyToOne
    lateinit var region: Region

    var note: String = ""
}