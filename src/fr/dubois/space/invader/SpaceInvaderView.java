package fr.dubois.space.invader;





import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class SpaceInvaderView extends View {

	// Dimensions souhaitées
	private static final int TARGET_HEIGHT = 800;
	private static final int TARGET_WIDTH = 600;

	private Bitmap  alienbitmap;
	Matrix transform;

	private Paint paint; // Style pour le texte	
	private String text; // texte à afficher
	private Alien alien;

	public SpaceInvaderView(Context context) {
		super(context);
		init();
	}

	public SpaceInvaderView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public SpaceInvaderView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}




	void init(){
		paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.YELLOW);
		paint.setTypeface(Typeface.SANS_SERIF);
		paint.setTextSize(36);
		paint.setTextAlign(Paint.Align.CENTER);
		text = "Texte";
		alienbitmap = loadImage(R.drawable.alien1);
		alien = new Alien(alienbitmap, 0, 0);


	}







	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRGB(0, 0, 0);
		canvas.drawRect(0, 0, TARGET_WIDTH-1, TARGET_HEIGHT-1, paint);
		if (text != null){

			canvas.drawText(text, canvas.getWidth()/2,canvas.getHeight()/2, paint);
		}
		alien.draw(canvas);
	}


	private int computeSize(int spec,int def){
		int mode = View.MeasureSpec.getMode(spec);
		if (mode == View.MeasureSpec.UNSPECIFIED) return def;
		int size = View.MeasureSpec.getSize(spec);
		if (mode == View.MeasureSpec.EXACTLY) {
			return size;
		}
		//		MeasureSpec.AT_MOST
		if (size < def ) return size;
		return def;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int x = computeSize(widthMeasureSpec,TARGET_WIDTH);
		int y = computeSize(heightMeasureSpec,TARGET_HEIGHT);
		this.setMeasuredDimension(x,y);
	}



	/*
    private void initSnakeView() {
        setFocusable(true);

        Resources r = this.getContext().getResources();

        resetTiles(4);
        loadTile(alien1, r.getDrawable(R.drawable.alien1));
        loadTile(ic_launcher, r.getDrawable(R.drawable.ic_launcher));
        loadTile(missile, r.getDrawable(R.drawable.missile));
        loadTile(missile2, r.getDrawable(R.drawable.missile2));
        loadTile(ship, r.getDrawable(R.drawable.ship));

    }*/

	public Bitmap loadImage(int res) {
		Drawable drawable = this.getContext().getResources().getDrawable(res);
		int x=drawable.getIntrinsicWidth();
		int y=drawable.getIntrinsicHeight();

		Bitmap bitmap = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap); 


		drawable.setBounds(0, 0, x, y);
		drawable.draw(canvas);


		return bitmap;
	}

}

