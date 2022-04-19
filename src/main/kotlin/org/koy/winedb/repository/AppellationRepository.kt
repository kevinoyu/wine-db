package org.koy.winedb.repository

import org.koy.winedb.model.Appellation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AppellationRepository : JpaRepository<Appellation, Long>