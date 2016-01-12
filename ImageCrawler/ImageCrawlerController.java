import java.io.*;
class ImageCrawlerController{
	
	private ImageCrawler model;
	private ImageCrawlerView view;

	public ImageCrawlerController(ImageCrawler model, ImageCrawlerView view){
		this.model = model;
		this.view = view;
	}

	public String getAddress(){
		return model.getAddress();
	}

	public File getFolderPath(){
		return model.getFolderPath();
	}

	public void setAddress(String a){
		model.setAddress(a);
	}

	public void setFolderPath(String fp){
		model.setFolderPath(fp);
	}

	public void updateView(){
		view.printDetails(model.getAddress());
	}
}
