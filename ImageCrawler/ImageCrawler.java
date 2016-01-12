import java.io.File;
class ImageCrawler{

	private String address;
	private File folderPath; 

	public String getAddress(){
		return address;
	}

	public File getFolderPath(){
		return folderPath;
	}

	public void setAddress(String a){
		address = a;
	}

	public void setFolderPath(String fp){
		folderPath = new File(fp);
	}

}
