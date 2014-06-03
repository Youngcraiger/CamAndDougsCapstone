/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

public class CharFrequency {

    private char letter;
    private int frequency;

    public CharFrequency(char letter) {
        this.frequency = 0;
        this.letter = letter;
    }

    public CharFrequency(char letter, int freq) {
        this.letter = letter;
        this.frequency = freq;
    }

    public int getFrequency() {
        
        return this.frequency;
    }

    public char getChar() {
        return this.letter;
    }

    public void plusOne() {
        this.frequency = frequency + 1;
    }

    @Override
    public String toString() {

        String x = "" + this.letter;
        String num = "" + this.frequency;  
        return x + " = " + num;
    }
}