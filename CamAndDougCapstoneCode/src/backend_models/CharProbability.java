/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

public class CharProbability {

    private char letter;
    private float probability;

    public CharProbability(char letter) {

        this.probability = 0;
        this.letter = letter;

    }

    public CharProbability(char letter, float prob) {

        this.probability = prob;
        this.letter = letter;
    }

    public float getProbability() {
        return this.probability;
    }

    public char getChar() {
        return this.letter;
    }

    // there is no plusOne method!!
    
    @Override
    public String toString() {
        return "" + this.letter + " = " + this.probability;
    }
}
