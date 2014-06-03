package backend_models;

public class CryptoAnalysis {

    public static CharFrequency[] charFrequenciesOf(String theTextStr) {
        CharFrequency[] charFreqs = new CharFrequency[141];

        for (int j = 0; j < charFreqs.length; j++) {

            charFreqs[j] = new CharFrequency((char) j);
        }


        for (int m = 0; m < theTextStr.length(); m++) {

            char currentChar = theTextStr.charAt(m);

            for (int n = 0; n < charFreqs.length; n++) {

                CharFrequency currentCharFreq = charFreqs[n];
                if ((currentCharFreq.getChar() == currentChar)) {

                    currentCharFreq.plusOne();
                }

            }

        }
        return charFreqs;
    }

    public static CharProbability[] charProbabilitiesOf(String theTextStr) {

        CharFrequency[] charFreqs = CryptoAnalysis.charFrequenciesOf(theTextStr);
        int total = 0;
        for (int i = 0; i < charFreqs.length; i++) {

            CharFrequency currShit = charFreqs[i];
            total += currShit.getFrequency();

        }
        CharProbability[] charProbs = new CharProbability[charFreqs.length];

        for (int j = 0; j < charFreqs.length; j++) {

            CharFrequency currenCharFreq = charFreqs[j];
            CharProbability currentCharProbs = new CharProbability(currenCharFreq.getChar(), ((float) currenCharFreq.getFrequency() / (float) total));
            charProbs[j] = currentCharProbs;

        }

        return charProbs;
    }

    public static CharProbability[] sortedCharProbabilitiesOf(String theTextStr) {

        CharProbability[] charProbs = CryptoAnalysis.charProbabilitiesOf(theTextStr);
        boolean sorted = false;

        while (sorted == false) {

            boolean swapped = false;

            for (int i = 0; i < charProbs.length - 1; i++) {


                float curr, next;
                curr = charProbs[i].getProbability();
                next = charProbs[i + 1].getProbability();

                if (curr < next) {

                    CharProbability temp = charProbs[i];
                    charProbs[i] = charProbs[i + 1];
                    charProbs[i + 1] = temp;
                    swapped = true;

                }
            }

            if (swapped == false) {
                sorted = true;
            }
        }
        double bs = 1.0 / 100000.0;
        int zeroFinderIndex = -1;
        for (int t = 0; t < charProbs.length; t++) {
            if ((charProbs[t].getProbability() < bs) && (zeroFinderIndex == -1)) {
                zeroFinderIndex = t;

            }
        }

        CharProbability[] finalCharProbsArray = new CharProbability[zeroFinderIndex];
        for (int r = 0; r < zeroFinderIndex; r++) {
            finalCharProbsArray[r] = charProbs[r];
        }

        return finalCharProbsArray;
    }

    public static String approxDecrypt(String cipherText, String sortedProbabilities) {

        CharProbability[] cipherSortedProbabilities = CryptoAnalysis.sortedCharProbabilitiesOf(cipherText);

        char[] cipherTextArray = cipherText.toCharArray();

        for (int i = 0; i < cipherTextArray.length; i++) {
            char currCipherChar = cipherTextArray[i];


            int currCipherCharIdx = -1;


            for (int l = 0; l < cipherSortedProbabilities.length; l++) {
                if (cipherSortedProbabilities[l].getChar() == currCipherChar) {
                    currCipherCharIdx = l;
                }
            }

            if (currCipherCharIdx > -1) {

                char decryptedChar = sortedProbabilities.charAt(currCipherCharIdx);
                cipherTextArray[i] = decryptedChar;
            }
        }
        String decryptedString = new String(cipherTextArray);
        return decryptedString;
    }
}