package miage.donab.bowling;

import java.util.ArrayList;
import java.util.List;

public class Partie {
    private List<Jeu> jeux = new ArrayList<>();

    public Partie(Jeu leJeu) {
        for (int i = 0; i<10; i++)
        {
            this.jeux.add(leJeu);
        }

        if (this.jeux.get(9).getLancer1() == 10 )
        {
            Jeu bonus = new Jeu(jeux.get(9).getLancer1(), jeux.get(9).getLancer1());
            this.jeux.add(bonus);
        }

        if (this.jeux.get(9).getLancer2() != null && this.jeux.get(9).getLancer1()+ this.jeux.get(9).getLancer2() == 10)
        {
            Jeu bonus = new Jeu(jeux.get(9).getLancer1(), null);
            this.jeux.add(bonus);
            this.jeux.add(bonus);
        }

    }

    public Integer calculeScore() {
        Integer score = 0;

        for (int i = 0; i<9; i++){
            Jeu jeuCourant = jeux.get(i);


            if (jeuCourant.isSpare())
            {
                Jeu jeuSuivant = jeux.get(i+1);
                score+= jeuCourant.nombreQuillesTombees() + jeuSuivant.getLancer1();
            }

           if (jeuCourant.isStrike())
            {
                Jeu jeuSuivant = jeux.get(i+1);
                Jeu jeuSuivant2 = jeux.get(i+2);
                score+= jeuCourant.nombreQuillesTombees() + jeuSuivant.nombreQuillesTombees() + jeuSuivant2.nombreQuillesTombees();
            }
            else
            {
                score += jeuCourant.nombreQuillesTombees();
            }
        }
        return score;
    }
}
