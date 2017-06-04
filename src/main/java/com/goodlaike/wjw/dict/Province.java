package com.goodlaike.wjw.dict;

public enum Province {

  上海("上海市",310000),江苏("江苏省",320000);

  private final String displayName;

  private final int id;
  
  public String getDisplayName(){
    return this.displayName;
  }
  
  public int getId(){
    return this.id;
  }

  private Province(String displayName, int id) {
    this.displayName = displayName;
    this.id = id;
  }
}
