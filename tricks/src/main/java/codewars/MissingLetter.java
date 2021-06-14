package codewars;

public class MissingLetter {
    public static char findMissingLetter(char[] array) {
        int k = 0;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        boolean cs = false;
        if (Character.isUpperCase(array[0])) {
            cs = true;
        }
        for (char c : alphabet) {
            if (Character.toLowerCase(array[k]) == c) {
                k++;
            } else if (k != 0) {
                if (cs) {
                    return Character.toUpperCase(c);
                } else {
                    return Character.toLowerCase(c);
                }
            }
        }
        return 'X';
    }
}

//public class Kata
//{
//  public static char findMissingLetter(char[] array){
//    char expectableLetter = array[0];
//    for(char letter : array){
//      if(letter != expectableLetter) break;
//      expectableLetter++;
//    }
//    return expectableLetter;
//  }
//}