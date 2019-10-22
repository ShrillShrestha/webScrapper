# WebScrapper
<hr>

Basic Workflow: The user is asked for a website to use as a starting point for the crawl. Then the user specifies a word or a sentence that is to be searched in the given website. The user will also be asked for the nuber of pages to search for.

Once everything is there the program makes the connection with the website and the search is initiated. 

Working: I have used a java library called JSoup to deal with all the web connection and extration stuff. The things on my side was to store the extracted links, track the links and determine if they have been visited before(to avoid loops), keep the track of number of pages that are visited. I have used sets to deal with the repetation problem and have a queue(implementation of linkedlist) to deal with storage of the extracted links. 

Once the crawl is initiated, the body of the html document is extarcted by the use of method calls from the Jsoup library. Then the given word/sentence is search against the content of the extracted body, and returns boolean result as per the condition.

Note: I used intellij IDE for this project and when I ran it in embeded terminal of the IDE, I had to use an extra space character at the end of the url when asked for the website as its default behavior is set to open the url in web brower when we press "enter". Also, if you will be using a system terminal, there won't be need of any need of extra space character for the senario.

During the course of development I used several resourses: <br>
http://www.netinstructions.com/how-to-make-a-simple-web-crawler-in-java/ <br>
https://www.mkyong.com/java/jsoup-basic-web-crawler-example/ <br>
https://jsoup.org/ <br>

Execution: <br>
<img src="./Screen Shot 2019-10-22 at 1.08.10 PM.png" alt="Execution Image">
