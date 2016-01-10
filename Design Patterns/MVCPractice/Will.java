/*This class will represent the model part of the MVC design pattern, so the object and its states and attributes are defined here. */


class Will {
	private int age;
	private boolean awake;

	public int getAge(){
		return age;
	}
	public boolean getAwake(){
		return awake;
	}

	public void setAwake(boolean isAwake){
		this.awake = isAwake;
	}

	public void setAge(int newAge){
		age = newAge;
	}
}
	
