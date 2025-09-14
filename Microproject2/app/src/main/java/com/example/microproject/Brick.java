package com.example.microproject;

public class Brick {
    private boolean isVisible;
    public int row,width,column,height;

    public Brick(int row,int column,int width,int height){
        isVisible=true;
        this.row=row;
        this.column=column;
        this.height=height;
        this.width=width;
    }
    public void setInvisiable(){
        isVisible=false;
    }
    public boolean getVisibility(){
        return isVisible;
    }
}
