import java.util.Locale;
public class AssignmentMain {
    static IOScanner ioScanner = new IOScanner();

    public static void pressEnter() {
        System.out.println("\n\npress \"Enter\" to continue: ");
        ioScanner.nextLine();
    }

    public static void printGrades(int[] studentScores) {
        String[] grades = new String[7];
        for (int i = 0; i < grades.length; i++) {

            if (studentScores[i] >= 0 && studentScores[i] < 50) {
                grades[i] = "U";
            } else if (studentScores[i] >= 50 && studentScores[i] < 70) {
                grades[i] = "3";
            } else if (studentScores[i] >= 70 && studentScores[i] < 85) {
                grades[i] = "4";
            } else if (studentScores[i] >= 85 && studentScores[i] <= 100) {
                grades[i] = "5";
            } else {
                grades[i] = "Invalid";
            }

        }
        System.out.println("Grades for all scores: ");
        for (int i = 0; i < grades.length; i++) {
            // System.out.print(grades[i] + ", ");
            if (i < grades.length - 1) {
                System.out.print(grades[i] + ", ");
            } else {
                System.out.print(grades[i]);
            }
        }
        pressEnter();
    }

    public static void calculatingMean(int[] studentScores) {

        int sum = 0;

        for (int i = 0; i < studentScores.length; i++) {
            sum += studentScores[i];
        }
        // double mean = (double)sum / (double)studentScores.length;
        double mean = (double) sum / studentScores.length;
        System.out.printf(Locale.ENGLISH, "The mean of the numbers is %.2f\n", mean); // Locale.ENGLISH
        pressEnter();
    }

    public static void highestLowestScore(int[] studentScores) {
        int highest = studentScores[0];
        int secondHighest = -1;
        int lowest = studentScores[0];
        int secondLowest = 101;

        for (int i = 0; i < studentScores.length; i++) {
            if (studentScores[i] > highest) {
                secondHighest = highest;
                highest = studentScores[i];
            } else if ((studentScores[i] < highest) && (studentScores[i] > secondHighest)) {
                secondHighest = studentScores[i];
            } else if (studentScores[i] < lowest) {
                secondLowest = lowest;
                lowest = studentScores[i];

            } else if ((studentScores[i] > lowest) && (studentScores[i] < secondLowest)) {
                secondLowest = studentScores[i];
            }
        }

        System.out.printf("\nThe two lowest scores provided are %d, and %d\n", lowest, secondLowest);
        System.out.printf("The two highest scores provided are %d, and %d\n", highest, secondHighest);
        pressEnter();
    }
    public static void readHashtags(){
        String caption = ioScanner.nextLine();
        String[] words = caption.split(" ");
        String[] hashtags = ne
            for (int i  = 0; i < words.length; i++){
                boolean isHashtag = words[i].contains("#");
                if (isHashtag == true){
                    
                } 
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

        System.out.println("The highest score is " + highest + " and belongs to the " + place + suffixs[place-1] + " student");
        pressEnter();
    }

    public static int[] newStudentScores() {
        String[] suffixs = new String[] { "st", "nd", "rd", "th", "th", "th", "th" };
        int[] studentScores = new int[7];
        for (int i = 0; i < studentScores.length; i++) {
            do {
                System.out.printf("please enter the score for the %d%s student: ", i + 1, suffixs[i]);
                studentScores[i] = ioScanner.nextIntCLR_BUFF();
                if ((studentScores[i] < 0) || (studentScores[i] > 100)) {
                    System.out.println("not a correct score. the score must be between 0 and 100.");
                } else {
                }
            } while ((studentScores[i] < 0) || (studentScores[i] > 100));
        }
        System.out.println("thank you for you input!");
        System.out.println("your entered scores are: ");
        for (int i = 0; i < studentScores.length; i++) {
            if (i < 6) {
                System.out.printf("%d, ", studentScores[i]);
            } else {
                System.out.printf("%d \n", studentScores[i]);
            }
        }
        pressEnter();
        return studentScores;

    }

    public static void main(String[] args) {
        int menuOpt;
        int[] studentScores = new int[7];
        do {
            System.out.println("\n\nWelcome to the menu. chose one of the options bellow: ");
            System.out.printf("%5d. %s", 1, "Register new scores for students.\n");
            System.out.printf("%5d. %s", 2, "Print all registered grades.\n");
            System.out.printf("%5d. %s", 3, "Calculate the mean of the entered scores.\n");
            System.out.printf("%5d. %s", 4, "Find the two highest and two lowest scores.\n");
            System.out.printf("%5d. %s", 5, "Find the highest score and its position.\n");
            System.out.printf("%5d. %s", 6, "Collect hashtags from a post.\n");
            System.out.printf("%5d. %s", 7, "To exit.\n");
            do {
                System.out.print("Type your option: ");
                menuOpt = ioScanner.nextIntCLR_BUFF();
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
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("ERROR. INPUT NOT VALID. Please enter a number between 1-7!");
                }
            } while ((menuOpt < 1) || (menuOpt > 7));

        } while (menuOpt != 7);
        System.out.println("Thank you for using our grading system. Have a nice day!");

        ioScanner.close();
    }
}
