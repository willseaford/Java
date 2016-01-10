public class WillMVCDemo {
	public static void main(String args[]){
		Will model = getFromDatabase();
		WillView view = new WillView();
		WillController controller = new WillController(model, view);

		controller.updateView();
		controller.setWillAge(22);
		controller.setWillAwake(true);
		controller.updateView();
	}
	public static Will getFromDatabase(){
		Will will = new Will();
		will.setAge(20);
		will.setAwake(false);
		return will;
	}

}
