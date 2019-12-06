package miage.donab.bowling;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartieTest {

    @Test
    public void testCalculeScorePartieSansStrikeSansSpare () {
        // given : une partie de 10 jeu avec 6 quilles tombées dans chaque jeu
        Jeu leJeu = new Jeu(6,0);
        Partie laPartie = new Partie(leJeu);

        // when : on calcule le score
        Integer score = laPartie.calculeScore();

        // then : on obtient un score de 60
        assertEquals(Integer.valueOf(60), score);

    }

    @Test
    public void testCalculeScoreQueDesSpare()
    {
        // given : une partie de 10 jeu avec un spare de 5 quilles par lancé  tombées dans chaque jeu
        Jeu leJeu = new Jeu(5,5);
        Partie laPartie = new Partie(leJeu);

        // when : on calcule le score
        Integer score = laPartie.calculeScore();

        // then : on obtient un score de 150
        assertEquals(Integer.valueOf(150), score);
    }

    @Test
    public void testCalculeScoreQueDesStrike()
    {
        // given : une partie de 10 jeu avec un spare de 5 quilles par lancé  tombées dans chaque jeu
        Jeu leJeu = new Jeu(10,null);
        Partie laPartie = new Partie(leJeu);

        // when : on calcule le score
        Integer score = laPartie.calculeScore();

        // then : on obtient un score de 150
        assertEquals(Integer.valueOf(300), score);
    }
}