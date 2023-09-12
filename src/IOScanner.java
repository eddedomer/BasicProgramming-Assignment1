import java.util.Scanner; 

public class IOScanner {
    //good practice to make the the Scanner private when accessing it so we dont ge uninteded interference. 
    private Scanner input;

    //initializing the scanner
    //"public" so we can access it outside of the class. 
    public IOScanner (){
        this.input = new Scanner(System.in);
    }
    //This creates a function we can call from the main class ex. ioScanner.nextInt() and read the input;
    public int nextInt(){
        return input.nextInt();
    }
    //this works exactly like the .nextInt(); but it directly clears the keyboard buffer so you dont have to put input.nextLine(); after reading an int. 
    public int nextIntCLR_BUFF(){
        int temp = input.nextInt();
        input.nextLine();
        return temp;
    }
    public String nextLine(){
        return input.nextLine();
    }
    public String next(){
        return input.next();
    }
    public double nextDouble(){
        return input.nextDouble();
    }
    public void close(){
        input.close();
    }
}