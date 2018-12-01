package image;


import util.Matrices;

import java.awt.*;

public class BruteRasterImage implements Image {

    private Color[][] pixels;
    private  int width;
    private int height;


    public BruteRasterImage(Color color, int width, int height){

        this.width=width;
        this.height=height;
        pixels=new Color[width][height];
        setPixelsColor(color);
    }



    public BruteRasterImage(Color[][] colors){
        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        Matrices.requiresRectangularMatrix(colors);

        for(int x = 0 ; x < Matrices.getRowCount(colors) ; x++){
            for(int y = 0 ; y < Matrices.getColumnCount(colors) ; y++){
                this.pixels[x][y] = colors[x][y];
            }
        }

    }


    public void createRepresentation(){

    }

    public void setPixelColor(Color color, int x, int y){
        this.pixels[x][y] = color;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return this.pixels[x][y];
    }

    private void setPixelsColor(Color[][] pixels){
        for(int x = 0 ; x<this.width ; x++ ){
            for(int y = 0 ; y<this.height ; y++){
                this.pixels[x][y] = pixels[x][y];
            }
        }
    }


    private void setPixelsColor(Color color) {
        for(int x = 0 ; x<this.width ; x++ ){
            for(int y = 0 ; y<this.height ; y++){
                pixels[x][y] = color;
            }
        }
    }


    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    protected void setWidth(int width){
        this.width = width;
    }

    protected void setHeight(int height){
        this.height = height;
    }

}
