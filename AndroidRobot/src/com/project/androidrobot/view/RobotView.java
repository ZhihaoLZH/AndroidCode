package com.project.androidrobot.view;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.project.androidrobot.R;
import com.project.androidrobot.modle.AbsObject;
import com.project.androidrobot.modle.AndroidRobot;


public class RobotView extends View {
	
	private final String TAG = "RobotView";
	private Context mContext;
	private int mScreenWidth;
	private int mScreenHeight;
	private int mWidth;
	private int mHeight;
	private final int DEFAULT_SIZE = 400;
	private Canvas mCanvas;
	private Bitmap mBitmap;
	private Paint mPaint;
	private int mColor = 0xff0a9808;
	private int DEFAULT_STROKE_WIDTH = 20;
	private int mModle = MODLE_ANDROID_ROBOT;
	private boolean firstDraw = true;
	
	public static final int MODLE_ANDROID_ROBOT = 0x01;
	
	
	public RobotView(Context context){
		super(context);
		mContext = context;
		setScreenWidthAndHeight();
		init();
	}
	
	public RobotView(Context context, AttributeSet attrs) {
		super(context,attrs);
		mContext = context;
		setScreenWidthAndHeight();
		TypedArray ta = null;
		try{
			ta = context.getTheme().obtainStyledAttributes(new int[]{R.attr.modle});
			mModle = ta.getInt(0, MODLE_ANDROID_ROBOT);
		}catch (NotFoundException e){
			e.printStackTrace();
		}finally{
			if(null!=ta){
				ta.recycle();
			}
		}
		init();
	}
	
	private void setScreenWidthAndHeight(){
		//获取屏幕的宽高
			DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
			mScreenWidth = metrics.widthPixels;
			mScreenHeight = metrics.heightPixels;
			Log.e(TAG,"screenWidth="+mScreenWidth+",screenHeight="+mScreenHeight);	
	}
	
	private void init(){
		//构建一个200px * 200px的Bitmap对象
		mBitmap = Bitmap.createBitmap(mScreenWidth, mScreenHeight,Config.ARGB_8888);
		
		//构建一个Canvas对象并将Bitmap对象赋给它
		mCanvas = new Canvas(mBitmap);
		
		mPaint = new Paint();
		mPaint.setStrokeWidth(DEFAULT_STROKE_WIDTH);
		mPaint.setColor(mColor);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		Log.e(TAG,"onMeasure");		
		
		//根据xml的layout_width和layout_height判断测量模式，确定自定义View的宽和高
		mWidth = getSuitableSize(widthMeasureSpec);
		mHeight = getSuitableSize(heightMeasureSpec);
		
		setMeasuredDimension(mWidth, mHeight);
		Log.e(TAG,"width="+mWidth+",height="+mHeight);
		
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		
		Log.e(TAG,"onSizeChanged");
		
		//开始画图
		create();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		if(action==MotionEvent.ACTION_DOWN){
			
		}else if(action==MotionEvent.ACTION_MOVE){
			
		}else if(action==MotionEvent.ACTION_UP){
			
		}
		TextView t;
		LinearGradient lg;
		
		return true;
	}
	
	private int getSuitableSize(int measureSpec){
		int result = 0;
		int mode = MeasureSpec.getMode(measureSpec);
		int size = MeasureSpec.getSize(measureSpec);
		if(mode==MeasureSpec.EXACTLY){
			result = size;
		}else{
			result = DEFAULT_SIZE;
			if(mode==MeasureSpec.AT_MOST){
				result = Math.min(result, size);
			}
		}
		return result;
	}
	
	public void create(){
		AbsObject obj;
		switch(mModle){
		case MODLE_ANDROID_ROBOT:
			obj = new AndroidRobot(mScreenWidth,mScreenHeight);
			break;
			default:
			obj = new AndroidRobot(mScreenWidth, mScreenHeight);
		}
		obj.create(mCanvas, mBitmap, mPaint);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		Log.e(TAG , "onDraw");
		super.onDraw(canvas);
		canvas.drawBitmap(mBitmap, 0, 0,null);
	}
	
	public void setModle(int modle){
		mModle = modle;
		create();
		invalidate();
	}
}
