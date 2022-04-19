package org.koy.winedb.repository

import org.koy.winedb.model.Producer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProducerRepository : JpaRepository<Producer, Long>