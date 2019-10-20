package com.my.game2048;

import java.util.List;

import android.graphics.Point;

public class DATA {

	public static final int LINES = 4;
	//CARD_WIDTH为小格子的边长，在onSizeChanged方法中赋值。
	public static int CARD_WIDTH = 0;
	public static Card[][] cardsMap = new Card[4][4];;
	public static List<Point> emptyPoints;
	public static boolean win;
}
