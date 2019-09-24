package uk.co.logiccache.domain.repository

import org.springframework.data.mongodb.repository.MongoRepository
import uk.co.logiccache.web.dto.Pet

interface PetRepository : MongoRepository<Pet, Int>