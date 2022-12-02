import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    private static char response(char first, char second){
        if(second == 'X'){
            switch (first){
                case 'R': return 'S';
                case 'P': return 'R';
                case 'S': return 'P';
            }
        }
        if(second == 'Z'){
            switch (first) {
                case 'R': return 'P';
                case 'P': return 'S';
                case 'S': return 'R';
            }
        }
    return first;
    }

    private static int move_score(char c){
        if(c == 'R') return 1;
        if(c == 'P') return 2;
        return 3;
    }

    private static char decode(char c){
        switch(c) {
            case ('A'):
            case ('X'):
                return 'R';
            case ('B'):
            case ('Y'):
                return 'P';
        }
        return ('S');

    }

    private static int process_line(String line){
        int score = 0;

        String[] split  = line.split(" ");
        char first = split[0].toCharArray()[0];
        char second = split[1].toCharArray()[0];

        first = decode(first);
        second = response(first, second);

        score += move_score(second);

        if(first == second) return (score + 3);
        if(first == 'R' && second == 'P') return (score + 6);
        if(first == 'P' && second == 'S') return (score + 6);
        if(first == 'S' && second == 'R') return (score + 6);

    return score;
    }

    public static void main(String[] args) {

        try {
            File myObj = new File("src/input.txt");
            Scanner myReader = new Scanner(myObj);
            int total = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int score = process_line(data);
                total += score;
                System.out.println(data);
                System.out.println(score);

            }
            System.out.println(total);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
