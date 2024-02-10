package tn.esprit.spring.kaddem;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.test.annotation.DirtiesContext;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;
import tn.esprit.spring.kaddem.entities.Etudiant;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
@Slf4j
public class EtudiantServiceImplTest {
    @Mock
    private EtudiantRepository etudiantRepository;

    @Mock
    private DepartementRepository departementRepository;
    @Mock
    private ContratRepository contratRepository;
    @Mock
    private EquipeRepository equipeRepository;

    @InjectMocks
    private EtudiantServiceImpl service; //

    @Test
    void assignEtudiantToDepartement_success() {
        // Set up test data
        Integer etudiantId = 1;
        Integer departementId = 2;
        Etudiant etudiant = new Etudiant();
        etudiant.setIdEtudiant(etudiantId);
        Departement departement = new Departement();
        departement.setIdDepart(departementId);

        // Mock repository behavior
        when(etudiantRepository.findById(etudiantId)).thenReturn(Optional.of(etudiant));
        when(departementRepository.findById(departementId)).thenReturn(Optional.of(departement));

        // Call the service method
        service.assignEtudiantToDepartement(etudiantId, departementId);

        // Verify interactions and results
        verify(etudiantRepository).findById(etudiantId);
        verify(departementRepository).findById(departementId);
        verify(etudiantRepository).save(etudiant);
        assertEquals(departement, etudiant.getDepartement());
    }
    @Test
    void addAndAssignEtudiantToEquipeAndContract_success() {
        // Set up test data
        Etudiant e = new Etudiant();
        Integer idContrat = 1;
        Integer idEquipe = 2;
        Contrat c = new Contrat();
        c.setIdContrat(idContrat);
        Equipe eq = new Equipe();
        eq.setIdEquipe(idEquipe);

        // Mock repository behavior
        when(contratRepository.findById(idContrat)).thenReturn(Optional.of(c));
        when(equipeRepository.findById(idEquipe)).thenReturn(Optional.of(eq));

        // Call the service method
        Etudiant savedEtudiant = service.addAndAssignEtudiantToEquipeAndContract(e, idContrat, idEquipe);

        // Verify interactions and results
        verify(contratRepository).findById(idContrat);
        verify(equipeRepository).findById(idEquipe);
        // No explicit save calls due to @Transactional
        assertEquals(c, savedEtudiant.getContrats());
        assertTrue(eq.getEtudiants().contains(savedEtudiant));
    }

    // Add more test cases for different scenarios, such as:
    // - Etudiant not found
    // - Departement not found
    // - Exceptions thrown by repositories
}
