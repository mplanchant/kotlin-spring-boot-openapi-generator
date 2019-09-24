package uk.co.logiccache.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uk.co.logiccache.domain.repository.PetRepository
import uk.co.logiccache.web.dto.Pet
import java.util.*

interface PetService {
    fun retrievePet(petId: String): Optional<Pet>
    fun retrieveAllPets(limit: Int): Optional<List<Pet>>
}

@Service
class PetServiceImpl @Autowired constructor(private val petRepository: PetRepository) : PetService {

    override fun retrievePet(petId: String): Optional<Pet> {
        return petRepository.findById(petId.toInt())
    }

    override fun retrieveAllPets(limit: Int): Optional<List<Pet>> {
        val pets = petRepository.findAll().toList()
        return when {
            pets.isNotEmpty() -> Optional.of(pets.take(limit))
            else -> Optional.empty()
        }
    }
}