package ch8_diff;

import aux.Function;

public class RichardsonExtrapolation {


     // La valeur qui représente l'intervalle utilisé dans le calcul

        private double h;

        // Créer un objet donne la valeur initiale de h
        public RichardsonExtrapolation()
        {
            h = 0.0001;
        }

        // Creating Object, où la valeur initiale de h est donnée
        public RichardsonExtrapolation(double h)
        {
            this.h = h;
        }


        public double getH()
        {
            return h;
        }


        public void setH(double h)
        {
            this.h = h;
        }
        //Calcul de la première dérivée de la fonction f au point x
        // avec l'intervalle h, en utilisant le schéma différentiel central

        public double centralDividedDifference(Function f, double x, double h)
        {
            return (f.eval(x + h) - f.eval(x - h)) / (2 * h);
        }

        // Calcul de la première dérivée de la fonction f au point x
        // En utilisant l'extrapolation de Richardson aussi le schéma différentiel central

        public double richardsonExtrapolation(Function f, double x)
        {
            // Dérivée au point x avec l'intervalle h

            double d1 = centralDividedDifference(f, x, this.h);

            // Dérivée au point x avec l'intervalle h
            double d2 = centralDividedDifference(f, x, this.h / 2);

            // Utiliser l'extrapolation de Richardson pour obtenir le résultat final de la fonction

            return d2 + (d2 - d1) / 3;
        }



}
