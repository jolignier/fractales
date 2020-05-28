/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractales;

import java.awt.Color;


/**
 *
 * @author jl219611
 */
public class Fractales {
    
    private double centerX;
    private double centerY;
    private double zoom;
    private int nbMaxIteration;
    private String mode;
    public Fractales(   float X, float Y,
                        double zoom, 
                        int nbMaxIteration,
                        String  mode)
    {
        this.zoom = zoom;
        this.nbMaxIteration = nbMaxIteration;
        this.mode = mode;
        
    }
    public double getCenterX(){
        return centerX;
    }
    
    public void setCenterX(double val){
        centerX = val;
    }
    
    public double getCenterY(){
        return centerY;
    }
    
    public void setCenterY(double val){
        centerY = val;
    }
    
    public double getZoom(){
        return zoom;
    }
    
    public void setZoom(double val){
        zoom = val;
    }
    
    public int getMaxIteration(){
        return nbMaxIteration;
    }
    
    public void setMaxIteration(int val){
        nbMaxIteration = val;
    }
    
    public void setMode(String mode){
        this.mode = mode;
    }
    
    public String getMode(){
        return mode;
    }
    
    Color getColor(int nbIteration, int couleurMode){
        double rangeColor = (double)nbMaxIteration/3.0; 
        double gapColor = 255.0/rangeColor; 
        double dred = (double)nbIteration*gapColor;
        double dgreen = ((double)nbIteration-rangeColor)*gapColor;
        double dblue = ((double)nbIteration-2*rangeColor)*gapColor;


        int red = (int) dred;
        int green = (int) dgreen;
        int blue = (int) dblue;


        if (red<0) {
            red = 0;
        }
        if (red>255) {
            red = 255;
        }

        if (green<0) {
            green = 0;
        }
        if (green>255) {
            green = 255;
        }

        if (blue<0) {
            blue = 0;
        }
        if (blue>255) {
            blue = 255;
        }
        switch (couleurMode){
            case 0: return new Color(red,green,blue);   // = rouge => jaune
            case 1: return new Color(blue,green,red);   // = bleu => cyan
            case 2: return new Color(green,green,red);  // = bleu => blancs
            case 3: default : return new Color(red, red, red);  // = blanc => gris
        }
        
    }
    
    public int mandelbrot(double realTestedValue, double imaginaryTestedValue, int maxNbIteration)
    {
        //Mandelbrot
        int cptIteration = 0;

        double currRealTestedValue = 0.;
        double currImaginaryTestedValue = 0.;

        double currRealTestedValue_n1 = 0.;
        double currImaginaryTestedValue_n1 = 0.;

        while ((module(currRealTestedValue_n1, currImaginaryTestedValue_n1) < 2) && (cptIteration < maxNbIteration)) {

              currRealTestedValue = currRealTestedValue_n1;
              currImaginaryTestedValue = currImaginaryTestedValue_n1;

              currRealTestedValue_n1 = currRealTestedValue*currRealTestedValue-currImaginaryTestedValue*currImaginaryTestedValue;
              currImaginaryTestedValue_n1 = 2*currRealTestedValue*currImaginaryTestedValue;

              currRealTestedValue_n1 += realTestedValue;
              currImaginaryTestedValue_n1 += imaginaryTestedValue;

              cptIteration += 1;
          }


        return cptIteration;
    }
    
    public int julia(double realTestedValue, double imaginaryTestedValue, double realSeedValue, double imaginarySeedValue,int maxNbIteration)
    {
        int cptIteration = 0;

        double currRealTestedValue = realTestedValue;
        double currImaginaryTestedValue = imaginaryTestedValue;

        double currRealTestedValue_n1 = realTestedValue;
        double currImaginaryTestedValue_n1 = imaginaryTestedValue;

        while ((module(currRealTestedValue_n1, currImaginaryTestedValue_n1) < 2) && (cptIteration < maxNbIteration)) {

              currRealTestedValue = currRealTestedValue_n1;
              currImaginaryTestedValue = currImaginaryTestedValue_n1;

              currRealTestedValue_n1 = currRealTestedValue*currRealTestedValue-currImaginaryTestedValue*currImaginaryTestedValue;
              currImaginaryTestedValue_n1 = 2*currRealTestedValue*currImaginaryTestedValue;

              currRealTestedValue_n1 += realSeedValue;
              currImaginaryTestedValue_n1 += imaginarySeedValue;

              cptIteration += 1;
          }

        return cptIteration;
    }
    
    public int checkDivergence(double realTestedValue, double imaginaryTestedValue, double realSeedValue, double imaginarySeedValue,int maxNbIteration)
    {
        if (mode=="Mandelbrot") {
            return mandelbrot(realTestedValue, imaginaryTestedValue, maxNbIteration);
        }
        else if(mode=="Douady +") {
            return julia(realTestedValue, imaginaryTestedValue, realSeedValue, imaginarySeedValue, maxNbIteration);
        }else if(mode=="Douady -") {
            return julia(realTestedValue, imaginaryTestedValue, realSeedValue, imaginarySeedValue, maxNbIteration);
        } else {
            return julia(realTestedValue, imaginaryTestedValue, realSeedValue, imaginarySeedValue, maxNbIteration);
        }
    }
    
    public double module(double realValue, double imaginaryValue)
{
    return Math.sqrt(realValue*realValue+imaginaryValue*imaginaryValue);
}
    
}
