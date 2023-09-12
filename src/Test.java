public class Test {
    public static void main(String[] args) {
        IOScanner ioScanner = new IOScanner();
        
        System.out.println("Whats you age: ");
        int age = ioScanner.nextIntCLR_BUFF();
        System.out.println("Whats you age: ");
        int age2 = ioScanner.nextIntCLR_BUFF();
        System.out.println("Whats you age: ");
        int age3 = ioScanner.nextIntCLR_BUFF();
        System.out.println("What's your name?");
        String name = ioScanner.nextLine();

        System.out.println(name + age);

    }
}
