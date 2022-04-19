package org.koy.winedb.repository

import org.koy.winedb.model.Vintage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VintageRepository : JpaRepository<Vintage, Long>