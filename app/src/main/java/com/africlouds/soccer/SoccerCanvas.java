package com.africlouds.soccer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by rwema on 7/4/15.
 */
public class SoccerCanvas extends View{
    Context context;
    private Path mPath;
    private Paint mPaint;

    public SoccerCanvas(Context c, AttributeSet attrs) {
        super(c, attrs);
        context = c;

        mPath = new Path();

        // and we set a new Paint with the desired attributes
        mPaint = new Paint();
        mPaint.setAntiAlias(true);




    }

    @Override
    protected void onDraw(Canvas canvas) {
        float ratio = (float)4.5;
        float area_width=800;
        float area_height = 500;
        float x_offset = 100;
        float y_offset = 10;
        float width= ratio * 120;
        float height= ratio * 90;
        float circle_radius = ratio * (float)9.15;
        float goal_circle_radius = ratio * (float)9.15;
        float width_penalty_area = ratio * (float)16.5;
        float height_penalty_area = ratio * (float)40.3;
        float width_goal_area = ratio * (float)5.5;
        float height_goal_area = ratio * (float)18.3;
        float corner_radius = ratio * (float)3;
        float team_names_size = ratio *(float)3.5;
        float penalty_spot = ratio * (float)11;
        float penalty_spot_radius = ratio * (float)1;
        float goal_width=ratio*(float)2.44;
        float goal_height=ratio*(float)7.32;



        super.onDraw(canvas);


        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, area_width, area_height, mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(4f);

        //main out rectangle
        canvas.drawRect(x_offset, y_offset, width+x_offset, height+y_offset, mPaint);

        //central circle
        canvas.drawCircle(x_offset+width/2, y_offset+height/2, circle_radius, mPaint);

        //median line
        canvas.drawLine(x_offset+width/2,y_offset,x_offset+width/2,y_offset+height,mPaint);

        //penalty area
        canvas.drawRect(x_offset, y_offset+(height-height_penalty_area)/2, x_offset+width_penalty_area, y_offset+(height-height_penalty_area)/2+height_penalty_area, mPaint);
        canvas.drawRect(width-width_penalty_area+x_offset, y_offset+(height-height_penalty_area)/2, width+x_offset, y_offset+(height-height_penalty_area)/2+height_penalty_area, mPaint);

        //goal area
        canvas.drawRect(x_offset, y_offset+(height-height_goal_area)/2, x_offset+width_goal_area, y_offset+(height-height_goal_area)/2+height_goal_area, mPaint);
        canvas.drawRect(width-width_goal_area+x_offset, y_offset+(height-height_goal_area)/2, width+x_offset, y_offset+(height-height_goal_area)/2+height_goal_area, mPaint);

        //goal
        canvas.drawRect(x_offset-goal_width, y_offset+(height-goal_height)/2, x_offset, y_offset+(height-goal_height)/2+goal_height, mPaint);
        canvas.drawRect(x_offset+width, y_offset+(height-goal_height)/2, x_offset+width+goal_width, y_offset+(height-goal_height)/2+goal_height, mPaint);


        //corners
        RectF oval = new RectF();

        //goal circles
        oval.set(x_offset+penalty_spot-goal_circle_radius,y_offset+height/2-goal_circle_radius,x_offset+penalty_spot+goal_circle_radius,y_offset+height/2+goal_circle_radius);
        canvas.drawArc(oval,310,100,false,mPaint);

        oval.set(x_offset+width-penalty_spot-goal_circle_radius,y_offset+height/2-goal_circle_radius,x_offset+width-penalty_spot+goal_circle_radius,y_offset+height/2+goal_circle_radius);
        canvas.drawArc(oval,130,100,false,mPaint);




        //corner1
        oval.set(x_offset-corner_radius,y_offset-corner_radius,x_offset+corner_radius,y_offset+corner_radius );
        canvas.drawArc(oval,0,90,false,mPaint);

        //corner2
        oval.set(x_offset+width-corner_radius,y_offset-corner_radius,x_offset+width+corner_radius,y_offset+corner_radius );
        canvas.drawArc(oval,90,90,true,mPaint);

        //corner3
        oval.set(x_offset+width-corner_radius,y_offset+height-corner_radius,x_offset+width+corner_radius,y_offset+height+corner_radius );
        canvas.drawArc(oval,180,90,true,mPaint);

        //corner4
        oval.set(x_offset-corner_radius,y_offset+height-corner_radius,x_offset+corner_radius,y_offset+height+corner_radius );
        canvas.drawArc(oval,270,90,true,mPaint);


        mPaint.setStyle(Paint.Style.FILL);
        //penalty spots
        canvas.drawCircle(x_offset+penalty_spot, y_offset+height/2, penalty_spot_radius, mPaint);
        canvas.drawCircle(x_offset+width-penalty_spot, y_offset+height/2, penalty_spot_radius, mPaint);

        //center spot
        canvas.drawCircle(x_offset+width/2, y_offset+height/2, penalty_spot_radius, mPaint);


        //team names
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(team_names_size);
        mPaint.setAntiAlias(true);
        Typeface tf = Typeface.create("Arial", Typeface.NORMAL);
        mPaint.setTypeface(tf);
        canvas.drawText("Home Team", x_offset+width/8, y_offset+height/8, mPaint);
        canvas.drawText("Away Team", x_offset+width/8+width/2, y_offset+height/8, mPaint);







    }

}
