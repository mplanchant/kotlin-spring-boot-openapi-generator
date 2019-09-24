package uk.co.logiccache.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import uk.co.logiccache.domain.repository.PetRepository
import uk.co.logiccache.web.dto.Pet

@Component
class DataLoader @Autowired constructor(private val petRepository: PetRepository) : ApplicationRunner {

    override fun run(applicationArguments: ApplicationArguments) {
        createPets()
    }

    private fun createPets() {
        val dog = Pet(1L, "Fido")
        val cat = Pet(2L, "Tiddles")
        petRepository.saveAll(listOf(cat, dog))
    }
}