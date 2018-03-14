package com.pettest;

import com.pet.Bird;
import com.pet.Dog;
import com.pet.Pet;

public class PetTest {
	public static void main(String[] args) {
		//向上转型
		Pet pet;    //Pet pet=new Dog();
		pet=new Dog();
		pet.toHospital();
		pet=new Bird();
		pet.toHospital();
		//向下转型 出现异常
		/*Dog dog=(Dog)pet;
		dog.catchFly();*/
		if(pet instanceof Dog){
			Dog dog=(Dog)pet;
			dog.catchFly();
		}else if(pet instanceof Bird){
			Bird bird=(Bird)pet;
			bird.fly();
		}
		//不用多态
		/*Dog dog=new Dog();
		dog.toHospital();
		Bird bird=new Bird();
		bird.toHospital();*/
	}
}
