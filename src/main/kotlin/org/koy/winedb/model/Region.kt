package org.koy.winedb.model

import javax.persistence.*

@Entity
class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var name: String = ""
    var classification: String = ""
    var details : String = ""

    @Enumerated(EnumType.STRING)
    var type: RegionType = RegionType.COUNTRY

    @ManyToOne
    lateinit var parentRegion: Region

    @ManyToMany
    var varietals: MutableSet<Varietal> = mutableSetOf()
}
