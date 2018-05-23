/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisnum;
import java.math.*;
import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.Stack;


/**
 *
 * @author alejandro
 */
public class AnalisisNum {

    /**
     * @param args the command line arguments
     */

    public static float distancia( float a, float b){

        return Math.abs(b - a);
    }
    public static List<Float> puntos( float a, float b, float cantidadPuntos){
        
        List<Float> listA = new ArrayList<>();
        float n = distancia(a ,b);
        float n2 = n / cantidadPuntos;
        float n3 = n2;
        listA.add(a);
        
        for(int i = 0; i < cantidadPuntos; i++){
            listA.add(a + n2);
            n2 = n3 + n2;
        }
        return listA;
    }
    public static List<Float>  puntosY(List<Float> x){

        List<Float> listY = new ArrayList<>();
        for(Float f : x){
            //System.out.println("x:       y:");
            //System.out.println(f + "   " + (float)Math.sin(f));
            listY.add((float)Math.sin(f)); 
        }
        return listY;
    }
    
    
        public static float areaRectangular(float a, float b,  List<Float> x, List<Float> y){

        int i = 0;
        float area = 0;
        for(Float f : x){
            if(i == 0){
                area += y.get(i) * (distancia(a, f));
                i++;
            }else{
                area += y.get(i) * (distancia(x.get(i - 1), f));
                //System.out.println( "abs " + y.get(i) * Math.abs(distancia(x.get(i - 1), f)));
                i++;
            }
        }
        return area;
    }
        
    public static float areaTrapezoidal(float a, float b,  List<Float> x, List<Float> y){

        int i = 0;
        float area = 0;
        for(Float f : x){
         
            if(( i + 1) < x.size()){
                area += y.get(i) * distancia(x.get(i), x.get(i + 1));
                area += ((y.get(i + 1) - y.get(i)) * (distancia(x.get(i), x.get(i + 1)))) / 2;
                i++;
            }
           
        }
        return area;
    }
    
    public static float areaSemicircular(float a, float b,  List<Float> x, List<Float> y){

        int i = 0;
        float area = 0;
        float pi = (float)3.1415926;
        int signo = 1;
        for(Float f : x){
            if(i == 0){
                area += y.get(i) * distancia(a, f);
                if(y.get(i) >= 0)
                    signo = 1;
                else signo = -1;
                area += signo * (pi * Math.pow(distancia(a, f), 2));
                i++;
            }else{
                if(y.get(i) >= 0)
                    signo = 1;
                else signo = -1;
                area += y.get(i) * distancia(x.get(i - 1), f);
                area += signo * (pi * Math.abs(Math.pow(distancia(x.get(i - 1), f), 2)));
                i++;
            }
        }
        return area;
    }
    public static List<Float>  particionSin(List<Float> x){

        
        List<Float> listY = new ArrayList<>();
        List<Float> listY2 = new ArrayList<>();
        for(Float f : x){
            listY.add((float)Math.sin(f)); 
        }
        for(int i = 0; i < x.size(); i++){
            listY2.add(listY.get(i) * x.get(i)); 
        }
        return listY2;
    }
        public static List<Float>  xMasUno(List<Float> x){

        
        List<Float> listY = new ArrayList<>();
        List<Float> listY2 = new ArrayList<>();
        for(Float f : x){
            listY.add(f + 1); 
        }
        for(int i = 0; i < x.size(); i++){
            listY2.add(listY.get(i) * x.get(i)); 
        }
        return listY2;
    }
            public static List<Float>  xALa2(List<Float> x){

        
        List<Float> listY = new ArrayList<>();
        List<Float> listY2 = new ArrayList<>();
        for(Float f : x){
            listY.add((float)Math.pow(f,2)); 
        }
        for(int i = 0; i < x.size(); i++){
            listY2.add(listY.get(i) * x.get(i)); 
        }
        return listY2;
    }
            
}




