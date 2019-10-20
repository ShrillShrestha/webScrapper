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
}