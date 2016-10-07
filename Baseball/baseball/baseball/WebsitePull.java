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
					String[] posPull = small.get(0).text().split(" - ");
					posPull[1] = posPull[1].replaceAll("[,]", "/");
					String pos = posPull[1].replaceAll("[)(]", "");
					String name = a.get(0).text();
					String team = a.get(1).text();
					int ab = Integer.parseInt(tds.get(1).text());
					int r = Integer.parseInt(tds.get(2).text());
					int hr = Integer.parseInt(tds.get(3).text());
					int rbi = Integer.parseInt(tds.get(4).text());
					int sb = Integer.parseInt(tds.get(5).text());
					double avg = Double.parseDouble(tds.get(6).text());
					double obp = Double.parseDouble(tds.get(7).text());
					int h = Integer.parseInt(tds.get(8).text());
					int dbl = Integer.parseInt(tds.get(9).text());
					int triple = Integer.parseInt(tds.get(10).text());
					int bb = Integer.parseInt(tds.get(11).text());
					int k = Integer.parseInt(tds.get(12).text());
					double slg = Double.parseDouble(tds.get(13).text());
					double ops = Double.parseDouble(tds.get(14).text());
					
					System.out.println(name + "," + team + "," + pos + "," + ab + "," + r + "," + hr + "," + rbi + "," + sb + "," + avg + "," + obp + "," + h + "," + dbl + "," + triple + "," + bb + "," + k + "," + slg + "," + ops);
					
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
