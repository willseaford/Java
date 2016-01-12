import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements; 
import java.net.URL;
import java.io.*;

class ImageCrawlerMain{

	public static void main(String args[]) throws IOException {
		ImageCrawlerView view = new ImageCrawlerView();
		ImageCrawler crawler = makeCrawler();
		ImageCrawlerController controller = new ImageCrawlerController(crawler, view);
		connect(controller);
    	} 


	
	public static ImageCrawler makeCrawler() throws IOException {
		ImageCrawler crawler = new ImageCrawler();
		crawler.setAddress("INSERT HTML LINK HERE");
		crawler.setFolderPath("images");
		return crawler;
	}

	public static void connect(ImageCrawlerController controller) throws IOException{
		//System.out.println("Downloading to " + controller.getFolderPath());
		Document doc = Jsoup.connect(controller.getAddress()).get();  
            	Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");  
            	for (Element image : images) {  
			String src = image.absUrl("src");
			controller.updateView();
			downloadImg(controller, src);
            	}  
	}

	private static void downloadImg(ImageCrawlerController controller, String src) throws IOException {
		int indexname = src.lastIndexOf("/");
		String name = src.substring(indexname + 1, src.length());
		URL url = new URL(src);
		InputStream in = url.openStream();
		OutputStream out = new BufferedOutputStream(new FileOutputStream(controller.getFolderPath() + "/" + name));
		for (int i; (i = in.read()) != -1;){
			out.write(i);
		}
		out.close();
		in.close();
    }
}
