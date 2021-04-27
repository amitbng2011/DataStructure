package com.test.java.designpattern.structural.facadepattern;

public class Facade {

	private Shape crcle;
	private Shape triangle;
	private Shape cube;

	public Facade() {
		crcle = new Circle();
		triangle = new Triangle();
		cube = new Cube();
	}

	public void buildCircle(){
		crcle.build();
	}
	public void buildRectangle(){
		triangle.build();
	}
	public void buildSquare(){
		cube.build();
	}

}
