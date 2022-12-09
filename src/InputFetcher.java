import javax.swing.text.Document;

public class InputFetcher {
    String urlStart;
    String urlEnd;

    // Constructor
    public InputFetcher() {
        urlStart = "https://adventofcode.com/2022/day/";
        urlEnd = "/input";
    }

    public String getInputOfTheDay(int day) {
        String url = urlStart + String.valueOf(day) + urlEnd;
        Document doc = Jsoup.parse
        return Void;
    }       
    
}
