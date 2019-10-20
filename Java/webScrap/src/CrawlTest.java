import java.util.Scanner;

public class CrawlTest {
    public static void main(String[] args){
        jScrapper scrap = new jScrapper();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the url to start the search:");
        String url = in.nextLine().strip();

        System.out.print("\nEnter search word//sentence: ");
        String word = in.nextLine().strip();

        System.out.print("\nEnter number of pages(if present, also < 10) to search in: ");
        int maxNum = in.nextInt();

        /*
        input validation. Avoid large number of pages so that the java virtual memory can withstand the load
         */
        while(!(maxNum<=10)){
            System.out.println("\nError! Number of pages should be less than or equals to 10");
            System.out.print("Enter number of pages to search in (<=10): ");
            maxNum = in.nextInt();
        }

        System.out.println("\nInitiating....");
    }
}
