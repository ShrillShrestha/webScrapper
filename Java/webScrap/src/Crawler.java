/*
import essential libraries
 */
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
define crawler class
use the Jsoup library to crawl around the web
 */
public class Crawler {
    /*
    Use desired User agent to make the connection to act it like a normal web browsing
     */
    private String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36";
    private List<String> links = new LinkedList<>(); //list of Urls
    private Document htmlDocument; //the document page of our web page

    /**
     * collects the links in that website
     * @return list of all the links in the website
     */
    public List<String> getLinks(){
        return this.links;
    }

    /**
     * the craweler method that crawls the website
     * @param url the url which is being used for the time being
     */
    public boolean crawl(String url){
        try{
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;

            if(connection.response().statusCode() == 200){
                System.out.println("Visiting the " + url + ".....");
            }
            if(!connection.response().contentType().contains("text/html")){
                System.out.println("Received other than html page!");
                return false;
            }

            System.out.println("Received web page at: " + url);

            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found " + linksOnPage.size() + " link(s)");
            for(Element link: linksOnPage){
                this.links.add(link.absUrl("href"));
            }
            return true;

        }catch (IOException ioe){
            System.out.println("Error in HTTPS request " + ioe);
            return false;
        }
    }

    /**
     * searches the world in the active url
     * @param word the word to be searched
     * @return boolean value to represent if the word was found in the website
     */
    public boolean searchForWord(String word){
        if(this.htmlDocument == null){
            System.out.println("Error! Call crawl() before analyzing the document");
            return false;
        }
        System.out.println("Searching for " + word + ".....");
        String bodyText = this.htmlDocument.body().text(); //document body text stored in a string variable
        return bodyText.toLowerCase().contains(word.toLowerCase()); //string method contains to search for the sequence of the char in word in the body test
    }
}


