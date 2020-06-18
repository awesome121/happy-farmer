package main;
public class Person{
	private String name;
	private float weight;
	private int age;
	
	public Person(String inputName, float inputWeight, int inputAge) {
		name = inputName;
		weight = inputWeight;
		age = inputAge;
	}
	
	
	public String getName() {
		return name;
	}
	public float getWeight() {
		return weight;
	}
	public int getAge() {
		return age;
	}
	public String getMessage() {
		return "A person named " + name + ", who is " + age + " years old.";
	}
}
