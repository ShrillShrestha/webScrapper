/*
importing essential libraries native to java
*/
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;

/*
 * define jScrapper class
 */
public class jScrapper{
    /*
    declare and instantiate instance variable
     */
    private Set<String> pageVisited = new HashSet<>();
    private List<String> pagesToVisit = new LinkedList<>();

    /**
     * provide the url which is previously not parsed by the crawler
     * @return unparsed url
     */
    private String nextUrl(){
        String nextURL = pagesToVisit.remove(0);

        //checks weather the url is visited before
        while(pageVisited.contains(nextURL)){
            nextURL = pagesToVisit.remove(0);
        }
        pageVisited.add(nextURL);
        return nextURL;
    }

    /**
     * search for the word specified by the user to search in the particular url
     * @param url starting url to search for the word
     * @param word word to be searched for in urls
     */
    public void search(String url, String word, int maxPage){
        pagesToVisit.add(url);

        //checks if pagesToVisit is empty and searchPage exceeds the max number of pages to be searched
        while(pagesToVisit.size() != 0 && pageVisited.size() < maxPage){
            Crawler spike = new Crawler();  //declare and instantiate new Crawler object
            String parseUrl = nextUrl(); //url to be used for parsing

            spike.crawl(parseUrl);

            boolean found = spike.searchForWord(word);

            //outputs if the word is found
            if (found){
                System.out.println(String.format("The word \"%s\" found at \"%s\"", word, parseUrl));
                break;
            }
            this.pagesToVisit.addAll(spike.getLinks());
        }
    }
}