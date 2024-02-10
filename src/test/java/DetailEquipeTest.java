import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tn.esprit.spring.kaddem.entities.DetailEquipe;
import tn.esprit.spring.kaddem.entities.Equipe;

public class DetailEquipeTest {

    @Test
    public void testGetSetIdDetailEquipe() {
        // Création d'une instance de DetailEquipe
        DetailEquipe detailEquipe = new DetailEquipe();

        // Définition de l'ID
        Integer id = 1;
        detailEquipe.setIdDetailEquipe(id);

        // Vérification
        Assertions.assertEquals(id, detailEquipe.getIdDetailEquipe());
    }

    @Test
    public void testGetSetSalle() {
        // Création d'une instance de DetailEquipe
        DetailEquipe detailEquipe = new DetailEquipe();

        // Définition de la salle
        Integer salle = 10;
        detailEquipe.setSalle(salle);

        // Vérification
        Assertions.assertEquals(salle, detailEquipe.getSalle());
    }

    @Test
    public void testGetSetThematique() {
        // Création d'une instance de DetailEquipe
        DetailEquipe detailEquipe = new DetailEquipe();

        // Définition de la thématique
        String thematique = "Thematique Test";
        detailEquipe.setThematique(thematique);

        // Vérification
        Assertions.assertEquals(thematique, detailEquipe.getThematique());
    }

    @Test
    public void testSetGetEquipe() {
        // Création d'une instance de DetailEquipe
        DetailEquipe detailEquipe = new DetailEquipe();

        // Création d'une instance de Equipe avec Mockito
        Equipe equipeMock = mock(Equipe.class);

        // Définition de l'équipe
        detailEquipe.setEquipe(equipeMock);

        // Vérification
        Assertions.assertEquals(equipeMock, detailEquipe.getEquipe());
    }
}