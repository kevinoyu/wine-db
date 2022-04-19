package org.koy.winedb.repository

import org.koy.winedb.model.VintageNote
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VintageNoteRepository : JpaRepository<VintageNote, Long>