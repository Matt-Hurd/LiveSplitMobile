package me.livesplitmobile.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import livesplitcore.Timer;
import livesplitcore.TimerComponent;
import livesplitcore.TimerComponentState;
import me.livesplitmobile.Colors;
import me.livesplitmobile.MainActivity;
import me.livesplitmobile.R;

/**
 * Created by MidKnight on 5/14/2017.
 */

public class TimerComponentView extends LinearLayout implements IComponent {
    Timer timer;
    TimerComponent component;
    Handler timerHandler;
    Runnable runnable;

    public TimerComponentView(Context context, AttributeSet attr, final Timer timer, Handler handler){
        super(context, attr);
        TypedArray a = context.obtainStyledAttributes(
                attr,
                R.styleable.TimerComponentView, 0, 0
        );

        a.recycle();

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.timer_component, this, true);

        this.timer = timer;
        timerHandler = handler;
        component = new TimerComponent();
        runnable = new Runnable() {
            @Override
            public void run() {
                TimerComponentState state = component.state(timer);
                String t = state.time();
                String f = state.fraction();
                String colorName = state.color();
                update(t, f, colorName);
                state.close();
                timerHandler.postDelayed(runnable, MainActivity.Companion.getINTERVAL());
            }
        };
    }

    public void run() {
        timerHandler.postDelayed(runnable, MainActivity.Companion.getINTERVAL());
    }
    public Runnable getRunnable() {
        return runnable;
    }

    public void update(String t, String f, String colorName) {
        LinearLayout ll = (LinearLayout)getChildAt(0);
        TextView time = (TextView)ll.findViewById(R.id.timeTime);
        time.setText(t);
        time.setTextColor(Colors.INSTANCE.colorFromString(colorName));
        TextView frac = (TextView)ll.findViewById(R.id.timeFrac);
        frac.setText(f);
        frac.setTextColor(Colors.INSTANCE.colorFromString(colorName));
    }
}
