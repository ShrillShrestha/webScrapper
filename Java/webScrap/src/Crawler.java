/*
import essential libraries
 */
import java.util.ArrayList;
import java.util.List;

/*
define crawler class
use the Jsoup library to crawl around the web
 */
public class Crawler {

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

    }

    /**
     * searches the world in the active url
     * @param word the word to be searched
     * @return boolean value to represent if the word was found in the website
     */
    public boolean searchForWord(String word){

        return false;
    }
}


