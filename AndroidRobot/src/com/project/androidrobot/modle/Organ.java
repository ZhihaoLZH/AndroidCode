package com.project.androidrobot.modle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Organ {
	protected static Canvas mCanvas;
	protected static Bitmap mBitmap;
	protected static Paint mPaint;
	protected static final float DEFAULT_ROUND_RADIUS = 10;
	
	
	protected abstract void onDrawSelf();
	
	
	public static void setCanvas(final Canvas canvas){
		mCanvas = canvas;
	}
	
	public static void setBitmap(final Bitmap bitmap){
		mBitmap = bitmap;
	}
	
	public  static void setPaint(final Paint paint){
		mPaint = paint;
	}
}
