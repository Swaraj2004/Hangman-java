import java.util.Scanner;
import java.util.Random;

public class Hangman {

    static Scanner sc = new Scanner(System.in);
	static Random random = new Random();

    public static String replaceCharAt(String s, int pos, char c) {
        return s.substring(0,pos) + c + s.substring(pos+1);
    }

    public static String wordGenerator() {
        String words[] = {"java", "python", "phone", "forest", "nature", "earth", "laptop", "book"};
	    return words[random.nextInt(words.length)];
    }

    public static String hiddenWordGenerator(String x) {
        String hiddenWord = "";
	    for (int i = 0; i < x.length(); i++) {
            hiddenWord += "*";
        }
        return hiddenWord;
    }

    public static void hangMan(int lives) {
        if (lives == 5) {
            	System.out.println("   |");
		System.out.println("   |");
		System.out.println("   |");
		System.out.println("   |");
		System.out.println("   |");
		System.out.println("   |");
		System.out.println("   |");
		System.out.println("___|___");
        }
        if (lives == 4) {
            	System.out.println("   ____________");
		System.out.println("   |");
		System.out.println("   |");
		System.out.println("   |");
		System.out.println("   |");
		System.out.println("   |");
		System.out.println("   |");
		System.out.println("   | ");
		System.out.println("___|___");
        }
        if (lives == 3) {
            	System.out.println("   ____________");
		System.out.println("   |          _|_");
		System.out.println("   |         /   \\");
		System.out.println("   |        |     |");
		System.out.println("   |         \\_ _/");
		System.out.println("   |");
		System.out.println("   |");
		System.out.println("   |");
		System.out.println("___|___");
        }
        if (lives == 2) {
            	System.out.println("   ____________");
		System.out.println("   |          _|_");
		System.out.println("   |         /   \\");
		System.out.println("   |        |     |");
		System.out.println("   |         \\_ _/");
		System.out.println("   |           |");
		System.out.println("   |           |");
		System.out.println("   |");
		System.out.println("___|___");
        }
        if (lives == 1) {
            	System.out.println("   ____________");
		System.out.println("   |          _|_");
		System.out.println("   |         /   \\");
		System.out.println("   |        |     |");
		System.out.println("   |         \\_ _/");
		System.out.println("   |           |");
		System.out.println("   |           |");
		System.out.println("   |          / \\ ");
		System.out.println("___|___      /   \\");
        }
        if (lives == 0) {
            System.out.println("   ____________");
		System.out.println("   |          _|_");
		System.out.println("   |         /   \\");
		System.out.println("   |        |     |");
		System.out.println("   |         \\_ _/");
		System.out.println("   |          _|_");
		System.out.println("   |         / | \\");
		System.out.println("   |          / \\ ");
		System.out.println("___|___      /   \\");
        }
    }
	public static void main(String args[]) {
		System.out.println("   HANGMAN GAME  \n");
		String word = wordGenerator();
		String hiddenWord = hiddenWordGenerator(word);
		int lives = 6;
		while (lives > 0) {
		    System.out.println("The word is: " + hiddenWord);
		    System.out.print("Guess a letter: ");
		    char guess = sc.next().charAt(0);
		    if (word.indexOf(guess) >= 0) {
			System.out.println("Correct!\n");
			for (int i = 0; i < word.length(); i++) {
			    if (word.charAt(i) == guess)
				hiddenWord = replaceCharAt(hiddenWord, i, guess);
			}
			hangMan(lives);
			System.out.println("You have " + lives + " lives left.\n");
		    }
		    else {
			System.out.println("Wrong!");
			lives--;
			hangMan(lives);
			System.out.println("You have " + lives + " lives left.\n");
		    }
		    if (hiddenWord.indexOf("*") < 0) {
			System.out.println("Congratulations! You guessed the word: " + word);
			try {
			    System.out.print("\nEnter 1 if you want to play again: ");
			    if (sc.nextInt() == 1){
				word = wordGenerator();
				hiddenWord = hiddenWordGenerator(word);
				lives = 6;
				System.out.println();
				continue;
			    }
			} catch(Exception e) {
			    System.out.println("Invalid Input!!");
			}
			break;
		    }
		    if (lives == 0) {
			System.out.println("Game over! The word was: " + word);
			try {
			    System.out.print("\nEnter 1 if you want to play again: ");
			    if (sc.nextInt() == 1){
				word = wordGenerator();
				hiddenWord = hiddenWordGenerator(word);
				lives = 6;
				System.out.println();
				continue;
			    }
			} catch(Exception e) {
			    System.out.println("Invalid Input!!");
			}
		    }
		}
		System.out.println("\nThanks for playing!!\n");
	}
}
