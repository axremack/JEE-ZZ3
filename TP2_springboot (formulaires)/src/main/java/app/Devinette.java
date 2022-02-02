package app;

import org.hibernate.validator.constraints.Range;

import java.util.Random;


public class Devinette {
    //String message;
    public int nombre;
    public boolean isFound;

    @Range(min = 0, max = 100)
    public int proposition;

    static Random random = new Random();

    public Devinette() {
        nombre  = 1 + random.nextInt(100);
        //message = "Je pense à un nombre entre 1 et 100 ("+nombre+"). Pouvez-vous le trouver ?";
    }

    /*public String getMessage() {
        return message;
    }*/

    public int getProposition() {
        return proposition;
    }

    public void setProposition(int proposition) {
        this.proposition = proposition;
    }

    public boolean isFound() {
        return this.proposition == this.nombre;
    }

    public void reset() {
        this.nombre  = 1 + this.random.nextInt(100);
        //this.message = "Je pense à un nombre entre 1 et 100 ("+this.nombre+"). Pouvez-vous le trouver ?";
    }
}
