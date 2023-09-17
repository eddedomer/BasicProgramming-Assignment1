import java.util.Locale;

public class Menu {
    //if we want to change the min or max score. 
    final static int maxScore = 100;
    final static int minScore = 0;

    public static int[] newStudentScores() {
        //an array with the correct suffixes for the numbers
        String[] suffixs = new String[] { "st", "nd", "rd", "th", "th", "th", "th" };
        int[] studentScores = new int[7];
        //loop that reads 7 student scores
        for (int i = 0; i < studentScores.length; i++) {
            //Do while loop if the user types an out of bounds number.
            do {
                //here we send a message to print and read the next int while directly clearing the buffer
                studentScores[i] = IOScanner.nextIntCLR_BUFF("Enter the score for the " + (i+1) + suffixs[i] + " student ");
                
                if ((studentScores[i] < minScore) || (studentScores[i] > maxScore)) {
                    System.out.println("Error - Input out of bound. Score can only be between 0  and 100.");
                } else {
                }
            } while ((studentScores[i] < minScore) || (studentScores[i] > maxScore));
        }
        System.out.println("Thank you for your input.\n Your entered scores are:");
        //prints all the scores with a comma except the last score. 
        for (int i = 0; i < studentScores.length; i++) {
            if (i < studentScores.length - 1) {
                System.out.printf("%d, ", studentScores[i]);
            } else {
                System.out.printf("%d%n", studentScores[i]);
            }
        }
        //returns the studentScores array so we can acess it from the main Method. 
        return studentScores;
    }

    public static void printGrades(int[] studentScores) {
        //Prints all the grades similar to how it is printed after the scores being read.
        System.out.println("Your entered scores are:");
        for (int i = 0; i < studentScores.length; i++) {
            if (i < studentScores.length - 1) {
                System.out.printf("%d, ", studentScores[i]);
            } else {
                System.out.printf("%d \n", studentScores[i]);
            }
        }

    }
    
    public static void calculatingMean(int[] studentScores) {

        int sum = 0;
        //sums upp all the point
        for (int i = 0; i < studentScores.length; i++) {
            sum += studentScores[i];
        }
        //here we cast the int sum to a double so we get an mean with decimal points. 
        double mean = (double)sum / studentScores.length;
        //Locale.ENGLISH so we get a "." intead of a ", "
        System.out.printf(Locale.ENGLISH, "The mean of the numbers is %.2f\n", mean);
    }

    public static void highestLowestScore(int[] studentScores) {
        //initializing the highest and lowest scores as the first score, the secondHighest as the lowest possible score, the secondLowest as the highest score. 
        int highest = studentScores[0];
        int secondHighest = minScore;
        int lowest = studentScores[0];
        int secondLowest = maxScore;

        //we start at i = 1 because we already stated that highest and lowest is the first score the the if statements will always be false
        //and we dont want to check for a second highest or lowest score since we dont have a number to compare so we start comparing at the second int in the array.
        for (int i = 1; i < studentScores.length; i++) { 
            //if score "i" is higher than the current highest make the current highest the second highest and the current score the highest.  
            if (studentScores[i] > highest) {
                secondHighest = highest;
                highest = studentScores[i];
            //if score "i" is not higher than highest but higher than second highest make it the secondhighest"
            } else if ((studentScores[i] > secondHighest)) {
                secondHighest = studentScores[i];
            }
            //if score "i" is lower than the current lowest make the current lowest the second lowest and the current score the lowest. 
            if (studentScores[i] < lowest) {
                secondLowest = lowest;
                lowest = studentScores[i];
            //if score "i" is not lower than lowest but lower than second lowest make it the secondLowest"
            } else if ((studentScores[i] < secondLowest)) {
                secondLowest = studentScores[i];
            }
        }
        //Prints the results.
        System.out.printf("\nThe two lowest scores provided are %d, and %d\n", lowest, secondLowest);
        System.out.printf("The two highest scores provided are %d, and %d\n", highest, secondHighest);

    }

    public static void readHashtags() {
        //prompts the user to type in a sentence with hashtags through IOScanner
        String sentence = IOScanner.nextLine("Please write an sentence with hashtags: ");
        //Splits the sentence into an array "words" at every "space". Learned from https://www.geeksforgeeks.org/split-string-java-examples/
        String[] words = sentence.split(" ");
        //init bool foundHashtags as False by default. 
        boolean foundHashtag = false;
        //init String with all the collected hashtags. 
        String allHashtags = "";
        //checks if the words starts with a hashtag for all words. If it has it ads it the the allHashtags String
        for (int i = 0; i < words.length; i++) {
            //.startsWith was learned from https://www.w3schools.com/java/ref_string_startswith.asp
            if (words[i].startsWith("#")) {
                foundHashtag = true;
                allHashtags += words[i] + " ";
            }
        }
        //removes the " " at the end of the allHashtags String //source https://www.w3schools.com/java/ref_string_trim.asp
        allHashtags.trim();
        System.out.println("Hashtags found: " + allHashtags);
        //if no hashtags were found in any word foundHashtag will never be true and we print "No hashtags were typed"
        if (foundHashtag == false) {
            System.out.println("No hashtags were typed");
        }
    }

    public static void highestScore(int[] studentScores) {
        String[] suffixs = new String[] { "st", "nd", "rd", "th", "th", "th", "th" };
        //init highest as the first score
        int highest = studentScores[0];
        //init place as the first place. 
        int place = 1;
        //int "i = 1" because we already stated highest as the first studenScores[0] so it will always be false the first loop so we can skip it. 
        for (int i = 1; i < studentScores.length; i++) {
            //if the score is higher than current highest make score the highest. 
            if (studentScores[i] > highest) {
                highest = studentScores[i];
                //curent place in the for loop + 1 to get the place of the score. 
                place = i + 1;
            }
        }
        //prints the score with the suffix. 
        System.out.println(
                "The highest score is " + highest + " and belongs to the " + place + suffixs[place - 1] + " student");
    }
    public static void printMenu(){
            //prints the menu
            System.out.println("Welcome to the menu. Choose one of the options below: ");
            System.out.printf("%5d. %s", 1, "Register new scores for students.\n");
            System.out.printf("%5d. %s", 2, "Print all registered grades.\n");
            System.out.printf("%5d. %s", 3, "Calculate the mean of the entered scores.\n");
            System.out.printf("%5d. %s", 4, "Find the two highest and two lowest scores.\n");
            System.out.printf("%5d. %s", 5, "Find the highest score and its position.\n");
            System.out.printf("%5d. %s", 6, "Collect hashtags from a post.\n");
            System.out.printf("%5d. %s", 7, "To exit.\n\n");
    }

    public static void main(String[] args) {
        //init int for menu choice. 
        int menuOpt;
        //we beggin the program by getting scores for all the studens. 
        int[] studentScores = newStudentScores();
        do {//Print the menu.
            printMenu();
            do {//this loop is incase the user types an invalid input. 
                //asks the user for a menu choice and calls the correct function.
                menuOpt = IOScanner.nextIntCLR_BUFF("Type your option: ");
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
                        //if menuOpt is outside 1-7 print this error message
                        System.out.println("Error - Invalid value. Please type between 1 and 7");
                }
                //loop if menuOpt is not between 1-7
            } while ((menuOpt < 1) || (menuOpt > 7));
        //if menuOpt is 7 end the program.
        } while (menuOpt != 7);
        //closing the scanner. 
        IOScanner.close();
    }
}
