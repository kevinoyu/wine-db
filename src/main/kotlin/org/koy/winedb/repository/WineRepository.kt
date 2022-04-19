package org.koy.winedb.repository

import org.koy.winedb.model.Wine
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WineRepository : JpaRepository<Wine, Long>