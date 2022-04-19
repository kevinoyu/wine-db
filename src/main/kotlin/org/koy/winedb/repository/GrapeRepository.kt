package org.koy.winedb.repository

import org.koy.winedb.model.Grape
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GrapeRepository : JpaRepository<Grape, Long>