package com.project.androidrobot.modle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

public class AndroidRobot extends AbsObject {
	private final String TAG = "AndroidRobot";
	private int mScreenWidth;
	private int mScreenHeight;
	
	private Canvas mCanvas;
	private Bitmap mBitmap;
	private Paint mPaint;
	
	private Antena leftAntena;
	private Antena rightAntena;
	private Head head;
	private Body body;
	private Eye leftEye;
	private Eye rightEye;
	private Arm leftArm;
	private Arm rightArm;
	private Leg leftLeg;
	private Leg rightLeg;
	
	public AndroidRobot(int screenWidth, int screenHeight){
		mScreenWidth = screenWidth;
		mScreenHeight = screenHeight;
	}
	
	@Override
	public void create(final Canvas canvas, final Bitmap bitmap, final Paint paint) {
		Organ.setCanvas(canvas);
		Organ.setBitmap(bitmap);
		Organ.setPaint(paint);
		
		calculate();	
		draw();
	}
	
	
	private void draw(){
		leftAntena.onDrawSelf();
		rightAntena.onDrawSelf();
		head.onDrawSelf();
		leftEye.onDrawSelf();
		rightEye.onDrawSelf();
		body.onDrawSelf();
		leftArm.onDrawSelf();
		rightArm.onDrawSelf();
		leftLeg.onDrawSelf();
		rightLeg.onDrawSelf();
	}
	
	private void calculate(){
		
		//leftAntena
		float startX1 = mScreenWidth/5;
		float startY1 = mScreenHeight/15;
		float stopX1 = startX1+mScreenWidth/10;
		float stopY1 = startY1+mScreenHeight/16;
		
		leftAntena = new Antena(startX1, startY1, stopX1, stopY1);
		Log.e(TAG,"[statX1="+startX1+",startY1="+startY1+"]"+"  [stopX1="+stopX1+",stopY1="+stopY1+"]");
		
		//rightAntena
		float startX2 = mScreenWidth-startX1;
		float startY2 = startY1;
		float stopX2 = mScreenWidth - stopX1;
		float stopY2 = stopY1;
		
		rightAntena = new Antena(startX2, startY2, stopX2, stopY2);
		
		//head
		float headRadius = (startX2-startX1)/2;
		float headCenterX = (startX2 + startX1)/2;
		float headCenterY = headRadius+stopY1;
		float headLeft = headCenterX - headRadius;
		float headTop = headCenterY - headRadius;
		float headRight = headCenterX + headRadius;
		float headBottom = headCenterY + headRadius;
		
		head = new Head(headLeft, headTop, headRight, headBottom);
		
		Log.e(TAG,"[startX2="+startX2+",startY2="+startY2+"]"+"  [stopX2="+stopX2+",stopY2="+stopY2+"]");
		
		
		//body
		float bodyLeft = headLeft;
		float bodyTop = headCenterY+headRadius/8;
		float bodyRight = headRight;
		float bodyBottom = (mScreenHeight/2.0f);
		Log.e(TAG,"bodyRight="+bodyRight);
		body = new Body(bodyLeft, bodyTop, bodyRight, bodyBottom);
		
		//leftArm
		float armLeft1 = bodyLeft/4;
		float armTop1 = bodyTop;
		float armRight1 = bodyLeft - armLeft1;
		float armBottom1 = bodyBottom;
		
		leftArm = new Arm(armLeft1, armTop1, armRight1, armBottom1);
		
		
		//rightArm
		float armLeft2 = armLeft1 + bodyRight;
		float armTop2 = armTop1;
		float armRight2 = bodyRight + armRight1;
		float armBottom2 = armBottom1;
		
		rightArm = new Arm(armLeft2, armTop2, armRight2, armBottom2);
		Log.e(TAG,"armLeft2="+armLeft2+",armTop2="+armTop2+",armRight2="+armRight2+",armBottom2="+armBottom2);
		
		//leftLeg
		float legLeft1 = bodyLeft + (bodyRight-bodyLeft)/8;
		float legTop1 = bodyBottom+headRadius/8;
		float legRight1 = legLeft1 + armRight1 - armLeft1;
		float legBottom1 = legTop1+armBottom1 - armTop1;
		
		leftLeg = new Leg(legLeft1, legTop1, legRight1, legBottom1);
		
		//rightLeg
		float legTop2 = legTop1;
		float legRight2 = bodyRight-(bodyRight-bodyLeft)/8;
		float legLeft2 = legRight2 - legRight1 + legLeft1;
		float legBottom2 = legBottom1;
		rightLeg = new Leg(legLeft2, legTop2, legRight2, legBottom2);
		
		
		//leftEye
		float centerX1 = headLeft+headRadius/2;
		float centerY1 = (2*headTop+headRadius)/2;
		float radius1 = (centerX1 - headLeft)/4; 
		Paint p = new Paint();
		p.setColor(Color.WHITE);
		leftEye = new Eye(centerX1, centerY1, radius1, p);
		
		//rightEye
		float centerX2 =  mScreenWidth - centerX1;
		float centerY2 = centerY1;
		float radius2 = radius1;
		
		rightEye = new Eye(centerX2, centerY2, radius2, p);
	}
	
	
}
