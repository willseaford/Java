class WillController{
	private Will model;
	private WillView view;

	public WillController(Will model, WillView view){
		this.model = model;
		this.view = view;	
	}	
	
	public void setWillAge(int age){
		model.setAge(age);
	}

	public void setWillAwake(boolean awake){
		model.setAwake(awake);
	}

	public int getAge(){
		return model.getAge();
	}

	public boolean getAwake(){
		return model.getAwake();
	}

	public void updateView(){
		view.printWillDetails(model.getAge(), model.getAwake());
	}

}
