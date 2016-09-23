package baseball;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class WebsitePull {
	public static void main(String[] args) {

		Document doc;
		try {
			doc = Jsoup.connect("https://www.fantasypros.com/mlb/projections/hitters.php").get();

			for (Element table : doc.select("table[id=data]")) {
				for (Element row : table.select("tr")) {
					Elements tds = row.select("td");
					if (tds.isEmpty()) { // Header <tr> with only <th>s
						continue;
					}
					Elements a = row.select("a");
					if (a.isEmpty()) {
						continue;
					}
					Elements small = row.select("small");
					if (small.isEmpty()) {
						continue;
					}
					System.out.println(small.get(0).text() + "," + a.get(0).text() + "," + a.get(1).text() + "," + a.get(2).text() + "\t | " + tds.get(1).text() + " | " + tds.get(2).text() + " | " + tds.get(3).text() + " | " + tds.get(4).text() + " | " + tds.get(5).text() + " | " + tds.get(6).text() + " | " + tds.get(7).text() + " | " + tds.get(8).text() + " | " + tds.get(9).text() + " | " + tds.get(10).text() + " | " + tds.get(11).text() + " | " + tds.get(12).text() + " | " + tds.get(13).text() + " | " + tds.get(14).text() + " | " + tds.get(15).text() + " | " + tds.get(16).text());
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//
//public class WebsitePull {
//
////need to rewrite this as needed
//	public static void main(String[] args) throws IOException {
//
//		// Make a URL to the web page
//		URL url = new URL("https://www.fantasypros.com/mlb/projections/hitters.php");
//
//		// Get the input stream through URL Connection
//		URLConnection con = url.openConnection();
//		InputStream is =con.getInputStream();
//
//		// Once you have the Input Stream, it's just plain old Java IO stuff.
//
//		// For this case, since you are interested in getting plain-text web page
//		// I'll use a reader and output the text content to System.out.
//
//		// For binary content, it's better to directly read the bytes from stream and write
//		// to the target file.
//
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//		String line = null;
//
//		// read each line and write to System.out
//		while ((line = br.readLine()) != null) {
//			System.out.println(line);
//		}
//	}
//
//}
