package android.dangngocduc.anyimageview.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by DANG NGOC DUC on 6/12/2016.
 */
public class BitmapDrawableCircle  extends BitmapDrawable{private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;

  public BitmapDrawableCircle(Bitmap bitmap){
      super(bitmap);
  }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        Paint p=new Paint();
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()/2,canvas.getWidth()/2,p);
    }


}
