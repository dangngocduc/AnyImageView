package android.dangngocduc.anyimageview;

import android.content.Context;
import android.dangngocduc.anyimageview.drawable.BitmapDrawableCircle;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by DANG NGOC DUC on 6/12/2016.
 */
public class CircleImageView  extends ImageView {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;

    public CircleImageView(Context context) {
        super(context);
        init();
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init(){




    }

    @Override
    public void draw(Canvas canvas) {
        Drawable drawable = getDrawable();

        if (drawable == null) {
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }

        Bitmap b = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                && drawable instanceof VectorDrawable) {
            ((VectorDrawable) drawable).draw(canvas);
            b = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);

        }
        else {
            b = ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmap =null;
       if(b!=null)
         bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

        int w = getWidth(), h = getHeight();
        Bitmap roundBitmap;
if(h>w)
{
    roundBitmap =  getCroppedBitmap(bitmap, w);
}
        else          {
    roundBitmap =  getCroppedBitmap(bitmap, h);
}


        if(roundBitmap==null) return;
        canvas.drawBitmap(roundBitmap, 0,0, null);
    }

    public static Bitmap getCroppedBitmap(Bitmap bmp, int radius) {
        if(bmp==null) return null;
        Bitmap sbmp;
        if(bmp.getWidth() != radius || bmp.getHeight() != radius){
            if(bmp.getWidth()<bmp.getHeight()){
                sbmp = Bitmap.createScaledBitmap(bmp, radius, radius*bmp.getHeight()/bmp.getWidth(), false);
            }  else {

                sbmp = Bitmap.createScaledBitmap(bmp,  radius*bmp.getWidth()/bmp.getHeight(),radius, false);


            }

        }

        else
            sbmp = bmp;
        if(sbmp.getHeight()>sbmp.getWidth()){
            sbmp=Bitmap.createBitmap(sbmp,0,(sbmp.getHeight()-sbmp.getWidth())/2,sbmp.getWidth(),sbmp.getWidth());
        } else{
            sbmp=Bitmap.createBitmap(sbmp,(sbmp.getWidth()-sbmp.getHeight())/2,0,sbmp.getHeight(),sbmp.getHeight());

        }

        Bitmap output = Bitmap.createBitmap(sbmp.getWidth(),
                sbmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);


        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, sbmp.getWidth(), sbmp.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BAB399"));

        if(sbmp.getHeight()>sbmp.getWidth()){
            canvas.drawCircle(sbmp.getWidth() / 2, sbmp.getHeight() ,
                    sbmp.getWidth() / 2, paint);
        } else
        canvas.drawCircle(sbmp.getWidth() /2, sbmp.getHeight() / 2,
                sbmp.getHeight() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);


        return output;
    }



}
