package com.goodlaike.wjw.dict;

/**
 * 图片类型
 * 
 * @author Jail Hu (SE)
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 */
public enum PictureType {

	效果图((byte) 0), 实景图((byte) 1), 户型图((byte) 2), 交通配套((byte) 3);

	private final byte type;

	public byte getType() {
		return this.type;
	}

	private PictureType(byte type) {
		this.type = type;
	}
}
