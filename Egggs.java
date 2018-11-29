import java.util.*;
import java.io.*;
import java.text.*;
import java.util.regex.*;
public class Egggs {
  public double count(int[] x, int[] y) {
    double lo = 0;
    double inc = 1000000000;
    while(lo+inc != lo){
      double t = lo+inc;
      boolean[][] g = new boolean[x.length][x.length];
      for(int i = 0; i < g.length; i++){
        for(int j = 0; j < g.length; j++){
          if((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]) <= t) g[i][j] = true;
        }
      }
      for(int k = 0; k < g.length; k++){
        for(int i = 0; i < g.length; i++){
          for(int j = 0; j < g.length; j++){
            if(g[i][k] && g[k][j]) g[i][j] = true;
          }
        }
      }
      boolean ok = true;
      for(int i = 0; i < g.length; i++){
        for(int j = 0; j < g.length; j++){
          if(!g[i][j]) ok = false;
        }
      }
      if(!ok) lo+= inc;
      inc /= 2;
    }
    return Math.sqrt(lo);
  }
  
      public static void main(String[] args) {
        int[] xArray = {3, 3, 3, 3, 3, 3, 3};
        int[] yArray = {2, 3, 4, 3, 9, 8, 1};

        System.out.println(count(xArray, yArray));
    }
}