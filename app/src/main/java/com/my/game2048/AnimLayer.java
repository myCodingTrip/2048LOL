package com.my.game2048;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

public class AnimLayer extends FrameLayout {

	public AnimLayer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public AnimLayer(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AnimLayer(Context context) {
		super(context);
	}
	

	
	public void createMoveAnim(final Card from,final Card to,int fromX,int toX,int fromY,int toY){
		
		final Card c = getCard(from.getNum());
		
		LayoutParams lp = new LayoutParams(DATA.CARD_WIDTH, DATA.CARD_WIDTH);
		lp.leftMargin = fromX*DATA.CARD_WIDTH;
		lp.topMargin = fromY*DATA.CARD_WIDTH;
		c.setLayoutParams(lp);
		
		if (to.getNum()<=0) {
			//此处防止动画还未结束卡片就显示出来
			to.getImg().setVisibility(View.INVISIBLE);
		}
		TranslateAnimation ta = new TranslateAnimation(0, DATA.CARD_WIDTH*(toX-fromX), 0, DATA.CARD_WIDTH*(toY-fromY));
		//移动时间为100s
		ta.setDuration(100);
		ta.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {}
			@Override
			public void onAnimationRepeat(Animation animation) {}
			@Override
			public void onAnimationEnd(Animation animation) {
				to.getImg().setVisibility(View.VISIBLE);
				recycleCard(c);
			}
		});
		c.startAnimation(ta);
	}
	
	private Card getCard(int num){
		Card c;
		if (cards.size()>0) {
			c = cards.remove(0);
			//不断复用一个对象
		}else{
			c = new Card(getContext());
			addView(c);
		}
		c.setVisibility(View.VISIBLE);
		c.setNum(num);
		return c;
	}
	private void recycleCard(Card c){
		c.setVisibility(View.INVISIBLE);
		c.setNum(0);
		c.setAnimation(null);
		cards.add(c);
	}
	private List<Card> cards = new ArrayList<Card>();
	
	public void createScaleAnim(Card target){
		ScaleAnimation sa = new ScaleAnimation(0.1f, 1, 0.1f, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(100);
		target.setAnimation(null);
		target.getImg().startAnimation(sa);
	}
}
