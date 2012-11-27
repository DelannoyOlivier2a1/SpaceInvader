package fr.dubois.space.invader;

import android.graphics.Bitmap;
import android.util.Property;
import android.view.View;


public class Alien extends Sprite {

	public Alien(Bitmap bitmap, float x, float y) {
		super(bitmap, x, y);
		//test
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		x=x+2;  
	}


	}







