package pa1pal.newsstand.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

/**
 * Created by pa1pal on 27/10/17.
 */

public class Tabs extends View {

    int iconColor;
    Path tabPath, iconPath;
    Paint tabPaint, iconPaint, shadowPaint, borderPaint;

    public Tabs(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Tabs,
                0, 0);
        try
        {
            iconColor = a.getColor(R.styleable.Tabs_iconColor, Color.BLACK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            a.recycle();
        }
        init();
    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setOutlineProvider(new CustomOutline());
        }

        tabPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        iconPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        shadowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        tabPath = new Path();
        iconPath = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        tabPaint.setAlpha(255);
        tabPaint.setStyle(Paint.Style.FILL);
        tabPaint.setColor(Color.WHITE);
        canvas.drawRoundRect(new RectF(0, 0, 600, 150),  100, 100, tabPaint);

        iconPaint.setColor(Color.RED);
        canvas.drawRoundRect(new RectF(0, 0, 150, 150),  100, 100, iconPaint);

        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(1);
        borderPaint.setColor(Color.BLACK);
        borderPaint.setAlpha(100);
        canvas.drawRoundRect(new RectF(0, 0, 600, 150),  100, 100, borderPaint);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private class CustomOutline extends ViewOutlineProvider {
        @Override
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(new Rect(0,0,600, 200), 50);

        }
    }
}
