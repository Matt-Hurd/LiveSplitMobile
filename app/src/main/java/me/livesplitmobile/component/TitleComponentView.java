package me.livesplitmobile.component;

import static android.graphics.BitmapFactory.decodeByteArray;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import butterknife.Bind;

import butterknife.ButterKnife;

import livesplitcore.Timer;
import livesplitcore.TitleComponent;
import livesplitcore.TitleComponentState;
import livesplitcore.TitleComponentStateRef;
import me.livesplitmobile.MainActivity;
import me.livesplitmobile.R;

/**
 * Created by MidKnight on 5/15/2017.
 */

public class TitleComponentView extends LinearLayout implements IComponent {
    Handler runHandler;
    Timer timer;
    Runnable runnable;
    TitleComponent component;

    @Bind(R.id.tvSpacer)
    Space tvSpacer;

    @Bind(R.id.tvGameIcon)
    ImageView tvGameIcon;

    @Bind(R.id.tvGameLLayout)
    LinearLayout tvGameLLayout;

    @Bind(R.id.tvGameCategory)
    TextView tvGameCategory;

    @Bind(R.id.tvGameTitle)
    TextView tvGameTitle;

    @Bind(R.id.tvAttemptCount)
    TextView tvAttemptCount;

    public TitleComponentView(Context context, AttributeSet attr, final Timer timer, Handler handler) {
        super(context, attr);

        this.timer = timer;
        runHandler = handler;
        component = new TitleComponent();

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.title_view, this, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this);
        runnable = new Runnable() {
            @Override
            public void run() {
                TitleComponentState state = component.state(timer);
                update(state);
                state.close();
                runHandler.postDelayed(runnable, MainActivity.INTERVAL);
            }
        };
    }

    public void run() {
        runHandler.postDelayed(runnable, MainActivity.INTERVAL);
    }

    public void update(TitleComponentStateRef state) {
        String iconChange = state.iconChange();
        if (iconChange != null) {
            if(iconChange.isEmpty()) {
                tvGameIcon.setImageResource(0);
                tvGameIcon.setLayoutParams(new LayoutParams(0, MATCH_PARENT, 0.0f));
                tvGameLLayout.setGravity(Gravity.CENTER);

                LayoutParams lp = new LayoutParams(0, MATCH_PARENT, 0.1f);
                lp.setMargins(12,0,0,0);
                tvSpacer.setLayoutParams(lp);

                tvGameCategory.setLayoutParams(new LayoutParams(0, MATCH_PARENT, 0.8f));
                tvGameCategory.setGravity(Gravity.CENTER);

            }
            else {
                byte[] decodedString = Base64.decode(iconChange.substring(13), Base64.DEFAULT);
                Bitmap bitMap = decodeByteArray(decodedString, 0, decodedString.length);

                LayoutParams ivLayoutParams = new LayoutParams(0, MATCH_PARENT, 0.1f);
                ivLayoutParams.setMargins(18, 0, 18, 0);
                tvGameIcon.setLayoutParams(ivLayoutParams);
                tvGameIcon.setImageBitmap(bitMap);

                tvGameLLayout.setGravity(Gravity.START);

                LinearLayout.LayoutParams lp = new LayoutParams(0, MATCH_PARENT, 0.0f);
                lp.setMargins(0,0,0,0);
                tvSpacer.setLayoutParams(lp);

                tvGameCategory.setLayoutParams(new LayoutParams(0, MATCH_PARENT, 0.9f));
                tvGameCategory.setGravity(Gravity.START);
            }
        }
        tvGameTitle.setText(state.game());
        tvGameCategory.setText(state.category());
        tvAttemptCount.setText(String.valueOf(state.attempts()));
    }

    public Runnable getRunnable() {
        return runnable;
    }

}
