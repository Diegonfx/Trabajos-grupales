package TrabajoPractico_Distancia;

/**
 * Created by DiegoMancini on 18/3/17.
 */
public class DistanceCalculator {

    public int hammingDistance(String firstWord, String secondWord) {
        int result = 0;

        char[] firstWordArray = firstWord.toLowerCase().toCharArray();
        char[] secondWordArray = secondWord.toLowerCase().toCharArray();

        if (firstWordArray.length != secondWordArray.length) {
            throw new RuntimeException("String must have the same amount of letters");
        }

        for (int i = 0; i < firstWordArray.length; i++) {
            if(firstWordArray[i] != secondWordArray[i]) {
                result += 1;
            } else if (firstWordArray[i] == secondWordArray[i]) {
                result += 0;
            }
        }

        return result;
    }

    public int levenshteinDistance(String firstWord, String secondWord) {

        int result = 0;

        int lengthOfFirstWord = firstWord.length();
        int lengthOfSecondWord = secondWord.length();
        char[] firstWordArray = firstWord.toLowerCase().toCharArray();
        char[] secondWordArray = secondWord.toLowerCase().toCharArray();
        int[][] matrixOfLevenshtein = new int[lengthOfFirstWord+1][lengthOfSecondWord+1];

        if (lengthOfFirstWord == 0) {
            return lengthOfSecondWord;

        } if (lengthOfSecondWord == 0) {
            return lengthOfFirstWord;

        } if (firstWord.equals(secondWord)){
            return 0;
        }

        for (int i = 0 ; i < lengthOfFirstWord ; i++) {
            matrixOfLevenshtein[i][0] = i;
        }

        for (int j = 0; j < lengthOfSecondWord; j++) {
            matrixOfLevenshtein[0][j] = j;
        }

        for (int i = 1 ; i <= lengthOfFirstWord; i++) {
            for (int j = 1 ; j <= lengthOfSecondWord; j++) {
                int deleteOperation = matrixOfLevenshtein[i-1][j] + 1 ;
                int insertionOperation = matrixOfLevenshtein[i][j-1] + 1 ;
                int substitutionOperation = matrixOfLevenshtein[i-1][j-1];
                if (firstWordArray[i-1] != secondWordArray[i-1]) {
                    substitutionOperation += 1 ;
                }
                matrixOfLevenshtein[i][j] = Math.min(Math.min(deleteOperation , insertionOperation) , substitutionOperation);
                result = matrixOfLevenshtein[i][j];
            }
        }
        return result;
    }
}
