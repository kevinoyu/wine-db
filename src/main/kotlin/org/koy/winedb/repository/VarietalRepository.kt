package org.koy.winedb.repository

import org.koy.winedb.model.Varietal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VarietalRepository : JpaRepository<Varietal, Long>