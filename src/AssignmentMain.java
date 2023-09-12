public class AssignmentMain {
    static String[] PrintGrades(int[] studentScores){
        String[] grades = new String[1];
        return grades;
    }

    static void highestLowestScore(int[] studentScores){
        IOScanner ioScanner = new IOScanner();
        int highest = studentScores[0];
        int secondHighest = -1;
        int lowest = studentScores [0];
        int secondLowest = 101;
        
        for (int i = 0; i < studentScores.length; i++){
            if (studentScores[i] > highest){
                    secondHighest = highest;
                    highest = studentScores[i];
            } else if ((studentScores[i] < highest) && (studentScores[i] > secondHighest)){
                    secondHighest = studentScores[i];
            } else if (studentScores[i] < lowest){
                    secondLowest = lowest;
                    lowest = studentScores[i];
                    
            } else if ((studentScores[i] > lowest) && (studentScores[i] < secondLowest)){
                    secondLowest = studentScores[i];
            }
            }
        
        System.out.printf("\nThe two lowest scores provided are %d, and %d\n", lowest, secondLowest);
        System.out.printf("The two highest scores provided are %d, and %d\n", highest, secondHighest);
        System.out.println("\npress \"Enter\" to continue: ");
        ioScanner.nextLine();
    }

    static int[] NewStudentScores() {
        IOScanner ioScanner = new IOScanner();

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
        return studentScores;
        
        
    }

    public static void main(String[] args) {
        IOScanner ioScanner = new IOScanner();
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
                        studentScores = NewStudentScores();
                        break;
                    case 2:
                        PrintGrades(studentScores);
                        break;
                    case 3:
                        break;
                    case 4:
                        highestLowestScore(studentScores);
                        break;
                    case 5:
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