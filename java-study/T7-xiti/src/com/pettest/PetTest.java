package com.pettest;

import com.pet.Bird;
import com.pet.Dog;
import com.pet.Pet;

public class PetTest {
	public static void main(String[] args) {
		//����ת��
		Pet pet;    //Pet pet=new Dog();
		pet=new Dog();
		pet.toHospital();
		pet=new Bird();
		pet.toHospital();
		//����ת�� �����쳣
		/*Dog dog=(Dog)pet;
		dog.catchFly();*/
		if(pet instanceof Dog){
			Dog dog=(Dog)pet;
			dog.catchFly();
		}else if(pet instanceof Bird){
			Bird bird=(Bird)pet;
			bird.fly();
		}
		//���ö�̬
		/*Dog dog=new Dog();
		dog.toHospital();
		Bird bird=new Bird();
		bird.toHospital();*/
	}
}
