/*
import essential libraries
 */
import java.io.IOException;
import java.util.ArrayList;
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

    private List<String> links = new LinkedList<>(); //list of Urls
    private Document htmlDocument; //the document page of our web page
    /*
    no argument constructor
     */
    public Crawler(){

    }

    /**
     * collects the links in that website
     * @return list of all the links in the website
     */
    public List<String> getLinks(){
        return new ArrayList<String>();
    }

    /**
     * the craweler method that crawls the website
     * @param url the url which is being used for the time being
     */
    public void crawl(String url){
        try{
            Connection connection = Jsoup.connect(url);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;

            System.out.println("Received web page at: " + url);

            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found " + "(" + linksOnPage.size() + ")" + " link(s)");
            for(Element link: linksOnPage){
                this.links.add(link.absUrl("href"));
            }

        }catch (IOException ioe){
            System.out.println("Error in HTTPS request " + ioe);
        }
    }

    /**
     * searches the world in the active url
     * @param word the word to be searched
     * @return boolean value to represent if the word was found in the website
     */
    public boolean searchForWord(String word){
        System.out.println("Searching for " + word + ".....");
        String bodyText = this.htmlDocument.body().text(); //document body text stored in a string variable
        return bodyText.toLowerCase().contains(word.toLowerCase()); //string method contains to search for the sequence of the char in word in the body test
    }
}


