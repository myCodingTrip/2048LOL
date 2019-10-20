package com.my.game2048;


import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Card extends FrameLayout {
	//卡片显示的数字
	private int num = 0;
	private ImageView img;
	public Card(Context context) {
		super(context);
		img = new ImageView(getContext());
		//设置背景色为半透明白色
		img.setBackgroundColor(0x33ffffff);
		// LayoutParams相当于一个Layout的信息包，它封装了Layout的位置、高、宽等信息
		LayoutParams lp = new LayoutParams(-1, -1);
		//使卡片之间有10像素的间距
		lp.setMargins(10, 10, 0, 0);
		addView(img, lp);
		setNum(0);
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
		if(num<=0){
			//空卡片
			img.setImageResource(0);
		}else{
			//非空的卡片（必须转化成字符串）
			//label.setText(num+"");
			//setVisibility(img.VISIBLE);
			switch(num){
			case 2:
				img.setImageResource(R.drawable.l2);
				break;
			case 4:
				img.setImageResource(R.drawable.l4);
				break;
			case 8:
				img.setImageResource(R.drawable.l8);
				break;
			case 16:
				img.setImageResource(R.drawable.l16);
				break;
			case 32:
				img.setImageResource(R.drawable.l32);
				break;
			case 64:
				img.setImageResource(R.drawable.l64);
				break;
			case 128:
				img.setImageResource(R.drawable.l128);
				break;
			case 256:
				img.setImageResource(R.drawable.l256);
				break;
			case 512:
				img.setImageResource(R.drawable.l512);
				break;
			case 1024:
				img.setImageResource(R.drawable.l1024);
				break;
			case 2048:
				img.setImageResource(R.drawable.l2048);
				break;
			case 4096:
				img.setImageResource(R.drawable.l4096);
				break;
			case 8192:
				img.setImageResource(R.drawable.l8192);
				break;
			}			
		}		
	}
	//判断两张卡片是否相等合并
	public boolean equals(Card o) {
		return (getNum()==o.getNum());
	}
	protected Card clone(){
		Card c= new Card(getContext());
		c.setNum(getNum());
		return c;
	}
	public ImageView getImg() {
		return img;
	}
}
