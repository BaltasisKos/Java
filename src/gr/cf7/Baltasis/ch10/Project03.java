package gr.cf7.Baltasis.ch10;



import java.io.*;
import java.util.Arrays;

public class Project03 {

    public static void main(String[] args) {
        String file = "C:/Users/Heave/Desktop/characters.txt";
        int[][] charactersCount;

        try{
            charactersCount = storeCharactersCountInTable(file);
            sortByAppearanceFrequency(charactersCount);

            printDataDescending(charactersCount);

    }catch(IOException e){
        System.out.println(e.getMessage());
    }
    }


    static int[][] storeCharactersCountInTable(String file) throws IOException{
        String line;
        int[][] intCharArray = new int[128][2];
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while ((line = reader.readLine()) != null) {

                char[] characters = line.toCharArray();
                for (char character : characters){
                    if(Character.isWhitespace(character)){
                        continue;
                    }
                    int index = (int) character;
                    if (intCharArray[index][0] == 0) {

                        intCharArray[index][0] = index;
                    }
                    intCharArray[index][1] += 1;
                }
            }
            return intCharArray;
        }catch(IOException e){
            throw e; }
    }

    static void sortByAppearanceFrequency(int[][] arr){
        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));
    }

    static void sortByCharacterAscii(int[][] arr){
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));
    }

    static void printDataDescending(int[][] arr){
        for (int[] chars : arr) {
            if (chars[1] == 0) return;
            System.out.println("Character '" + (char) chars[0] +
                    "' appears " + chars[1] + " times");
        }
    }

    static void printDataAscending(int[][] arr){
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            if(arr[i][1] == 0) continue;
            System.out.println("Character '" + (char) arr[i][0] +
                    "' appears " + arr[i][1] + " times");
        }
    }
}
