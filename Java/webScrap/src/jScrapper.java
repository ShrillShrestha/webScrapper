import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;

public class jScrapper{
    private static final int MAX_PAGES_TO_SEARCH = 5;
    private Set<String> pageVisited = new HashSet<>();
    private List<String> pagesToVisit = new LinkedList<>();

    private String nextUrl(){
        String nextURL = pagesToVisit.remove(0);
        while(pageVisited.contains(nextURL)){
            nextURL = pagesToVisit.remove(0);
        }
        pageVisited.add(nextURL);
        return nextURL;
    }

    public void search(String url, String word){
        pagesToVisit.add(url);
        int searchPage = 0;
        while(pagesToVisit.size() != 0 && searchPage <= MAX_PAGES_TO_SEARCH){
            Crawler spike = new Crawler();
            String parseUrl = nextUrl();

            spike.crawl(parseUrl);

            boolean found = spike.searchForWord(word);

            if (found){
                System.out.println(String.format("The word \"%s\" found at \"%s\"", word, parseUrl));
                break;
            }
            this.pagesToVisit.addAll(spike.getLinks());
        }
    }
}