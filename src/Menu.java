import java.util.Locale;

public class Menu {
    static IOScanner ioScanner = new IOScanner();

    public static void printGrades(int[] studentScores) {
        System.out.println("Your entered scores are:");
        for (int i = 0; i < studentScores.length; i++) {
            if (i < 6) {
                System.out.printf("%d, ", studentScores[i]);
            } else {
                System.out.printf("%d \n", studentScores[i]);
            }
        }

    }

    public static void calculatingMean(int[] studentScores) {

        int sum = 0;

        for (int i = 0; i < studentScores.length; i++) {
            sum += studentScores[i];
        }
        double mean = (double) sum / studentScores.length;
        System.out.printf(Locale.ENGLISH, "The mean of the numbers is %.2f\n", mean);
    }

    public static void highestLowestScore(int[] studentScores) {
        int highest = studentScores[0];
        int secondHighest = 0;
        int lowest = studentScores[0];
        int secondLowest = 100;

        for (int i = 0; i < studentScores.length; i++) {
            if (studentScores[i] > highest) {
                secondHighest = highest;
                highest = studentScores[i];
            } else if ((studentScores[i] <= highest) && (studentScores[i] > secondHighest) && i != 0) {
                secondHighest = studentScores[i];
            }
            if (studentScores[i] < lowest) {
                secondLowest = lowest;
                lowest = studentScores[i];

            } else if ((studentScores[i] >= lowest) && (studentScores[i] < secondLowest) && i != 0) {
                secondLowest = studentScores[i];
            }
        }

        System.out.printf("\nThe two lowest scores provided are %d, and %d\n", lowest, secondLowest);
        System.out.printf("The two highest scores provided are %d, and %d\n", highest, secondHighest);

    }

    public static void readHashtags() {
        /*
         * String caption = ioScanner.nextLine();
         * String[] words = caption.split(" ");
         * // String[] hashtags = ne
         * for (int i = 0; i < words.length; i++){
         * int hashtags = words[i].indexOf("#");
         * System.out.println(hashtags);
         * }
         */
        String sentence = ioScanner.nextLine("Please write an sentence with hashtags: ");
        String[] words = sentence.split(" ");

        boolean foundHashtag = false;

        String allHashtags = "";
        for (String word : words) {
            if (word.startsWith("#")) {
                foundHashtag = true;
                allHashtags += word + " ";
            }
            allHashtags.trim();
        }
        System.out.println("Hashtags found: " + allHashtags);
        if (!foundHashtag) {
            System.out.println("No hashtags were typed");
        }
    }

    public static void highestScore(int[] studentScores) {
        // int[] Score = new int[3];
        // int sum = 0;

        // int Heighest;
        // for(Heighest = 0; Heighest <= Score.length - 1; ++Heighest) {
        // System.out.println("Enter your Score");
        // Score[Heighest] = ioScanner.nextIntCLR_BUFF();
        // sum += Score[Heighest];
        // }
        String[] suffixs = new String[] { "st", "nd", "rd", "th", "th", "th", "th" };
        int highest = studentScores[0];
        int place = 1;

        // for(int i = 0; i <= studentScores.length - 1; ++i) {
        for (int i = 0; i < studentScores.length; i++) {
            // if (highest < studentScores[i]) {
            if (studentScores[i] > highest) {
                highest = studentScores[i];
                place = i + 1;
            }
        }
        System.out.println(
                "The highest score is " + highest + " and belongs to the " + place + suffixs[place - 1] + " student");
    }

    public static int[] newStudentScores() {
        String[] suffixs = new String[] { "st", "nd", "rd", "th", "th", "th", "th" };
        int[] studentScores = new int[7];
        for (int i = 0; i < studentScores.length; i++) {
            do {
                System.out.printf("Enter the score for the %d%s student ", i + 1, suffixs[i]);
                studentScores[i] = ioScanner.nextIntCLR_BUFF("");
                if ((studentScores[i] < 0) || (studentScores[i] > 100)) {
                    System.out.println("Error - Input out of bound. Score can only be between 0  and 100.");
                } else {
                }
            } while ((studentScores[i] < 0) || (studentScores[i] > 100));
        }
        System.out.println("Thank you for your input.");
        System.out.println("Your entered scores are:");
        for (int i = 0; i < studentScores.length; i++) {
            if (i < 6) {
                System.out.printf("%d, ", studentScores[i]);
            } else {
                System.out.printf("%d \n", studentScores[i]);
            }
        }

        return studentScores;

    }

    public static void main(String[] args) {
        int menuOpt;
        int[] studentScores = new int[7];
        studentScores = newStudentScores();
        do {
            System.out.println("Welcome to the menu. Choose one of the options below: ");
            System.out.printf("%5d. %s", 1, "Register new scores for students.\n");
            System.out.printf("%5d. %s", 2, "Print all registered grades.\n");
            System.out.printf("%5d. %s", 3, "Calculate the mean of the entered scores.\n");
            System.out.printf("%5d. %s", 4, "Find the two highest and two lowest scores.\n");
            System.out.printf("%5d. %s", 5, "Find the highest score and its position.\n");
            System.out.printf("%5d. %s", 6, "Collect hashtags from a post.\n");
            System.out.printf("%5d. %s", 7, "To exit.\n\n");
            do {
                menuOpt = ioScanner.nextIntCLR_BUFF("Type your option: ");
                switch (menuOpt) {
                    case 1:
                        studentScores = newStudentScores();
                        break;
                    case 2:
                        printGrades(studentScores);
                        break;
                    case 3:
                        calculatingMean(studentScores);
                        break;
                    case 4:
                        highestLowestScore(studentScores);
                        break;
                    case 5:
                        highestScore(studentScores);
                        break;
                    case 6:
                        readHashtags();
                        break;
                    case 7:
                        System.out.println("Thank you for using our grading system. Have a nice day!");
                        break;
                    default:
                        System.out.println("Error - Invalid value. Please type between 1 and 7");
                }
            } while ((menuOpt < 1) || (menuOpt > 7));

        } while (menuOpt != 7);

        ioScanner.close();
    }
}
