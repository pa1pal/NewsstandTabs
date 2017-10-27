package pa1pal.newsstand.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by pa1pal on 27/10/17.
 */

public class Tabs extends View {

    int iconColor;
    Path tabPath, iconPath;
    Paint tabPaint, iconPaint;

    public Tabs(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Tabs,
                0, 0);
        try
        {
            iconColor = a.getColor(R.styleable.Tabs_iconColor, Color.WHITE);
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
        tabPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        iconPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
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
        tabPaint.setColor(Color.WHITE);
        tabPaint.setStyle(Paint.Style.FILL);

        tabPath.addRoundRect(new RectF(0, 0, 600, 150),  100, 100, Path.Direction.CCW);
        canvas.drawPath(tabPath, tabPaint);
        canvas.clipPath(tabPath);

        iconPaint.setColor(Color.RED);
        iconPath.addRoundRect(new RectF(0, 0, 150, 150),  100, 100, Path.Direction.CCW);
        canvas.drawPath(iconPath, iconPaint);
        canvas.clipPath(iconPath);

    }
}
