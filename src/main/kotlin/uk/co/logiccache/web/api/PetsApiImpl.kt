package uk.co.logiccache.web.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import uk.co.logiccache.service.PetService
import uk.co.logiccache.web.dto.Pet

@RestController
class PetsApiImpl @Autowired constructor(private val petService: PetService) : PetsApi {

    override fun listPets(limit: Int?): ResponseEntity<List<Pet>> {
        return ResponseEntity.of(petService.retrieveAllPets(limit ?: 100))
    }

    override fun showPetById(petId: String): ResponseEntity<Pet> {
        return ResponseEntity.of(petService.retrievePet(petId))
    }
}