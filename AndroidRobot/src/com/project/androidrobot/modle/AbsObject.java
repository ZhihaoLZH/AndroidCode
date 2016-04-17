package com.project.androidrobot.modle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class AbsObject {
	
	/**
	 * 
	 * @param canvas the canvas associated with bitmap and paint
	 * @param bitmap	the bitmap in the canvas
	 * @param paint		the paint you want to draw on the canvas
	 */
	public abstract void create(final Canvas canvas,final Bitmap bitmap,final Paint paint);
}
