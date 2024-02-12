import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UniversiteServiceImplTest {

    @Mock
    private UniversiteRepository universiteRepository;

    @Mock
    private DepartementRepository departementRepository;

    @InjectMocks
    private UniversiteServiceImpl universiteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRetrieveAllUniversites() {
        // Arrange
        List<Universite> universites = new ArrayList<>();
        when(universiteRepository.findAll()).thenReturn(universites);

        // Act
        List<Universite> result = universiteService.retrieveAllUniversites();

        // Assert
        assertEquals(universites, result);
    }

    @Test
    void testAddUniversite() {
        // Arrange
        Universite universiteToAdd = new Universite();
        when(universiteRepository.save(universiteToAdd)).thenReturn(universiteToAdd);

        // Act
        Universite result = universiteService.addUniversite(universiteToAdd);

        // Assert
        assertEquals(universiteToAdd, result);
    }

    @Test
    void testUpdateUniversite() {
        // Arrange
        Universite universiteToUpdate = new Universite();
        when(universiteRepository.save(universiteToUpdate)).thenReturn(universiteToUpdate);

        // Act
        Universite result = universiteService.updateUniversite(universiteToUpdate);

        // Assert
        assertEquals(universiteToUpdate, result);
    }

    @Test
    void testRetrieveUniversite() {
        // Arrange
        int idUniversite = 1;
        Universite expectedUniversite = new Universite();
        when(universiteRepository.findById(idUniversite)).thenReturn(Optional.of(expectedUniversite));

        // Act
        Universite result = universiteService.retrieveUniversite(idUniversite);

        // Assert
        assertEquals(expectedUniversite, result);
    }

    @Test
    void testDeleteUniversite() {
        // Arrange
        int idUniversite = 1;
        Universite universiteToDelete = new Universite();
        when(universiteRepository.findById(idUniversite)).thenReturn(Optional.of(universiteToDelete));

        // Act
        universiteService.deleteUniversite(idUniversite);

        // Assert
        verify(universiteRepository, times(1)).delete(universiteToDelete);
    }



    @Test
    void testRetrieveDepartementsByUniversite() {
        // Arrange
        int idUniversite = 1;
        Universite universite = new Universite();
        Set<Departement> expectedDepartements = new HashSet<>();
        universite.setDepartements(expectedDepartements);
        when(universiteRepository.findById(idUniversite)).thenReturn(Optional.of(universite));

        // Act
        Set<Departement> result = universiteService.retrieveDepartementsByUniversite(idUniversite);

        // Assert
        assertEquals(expectedDepartements, result);
    }
}
