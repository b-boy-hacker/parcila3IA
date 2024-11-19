/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial3;

import java.util.LinkedList;

/**
 *
 * @author daniel
 */
public class BacktrackLaberinto {
    
    /// --------- BACKTRACK LABERINTO REY ------------///
    
    public static int vueltas;

    public static boolean backtrackLaberintoRey(int m[][], int i, int j, int ifin, int jfin, int paso) {
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            return true;
        }
        LinkedList<Regla> L1 = Regla.reglasAplicablesRey(m, i, j);
//        LinkedList<Regla> L1 =
        while (!L1.isEmpty()) {
            Regla R = L1.removeFirst(); //elegir siempre el primero
            if (backtrackLaberintoRey(m, R.fil, R.col, ifin, jfin, paso + 1)) {
                return true;
            };
            vueltas++;
            m[R.fil][R.col] = 0;
        }
        return false;
    }

    /// ------------ FIN BACKTRACK LABERINTO REY --------///
    
    
    
    // ---- HEURISITCA DISTANCIA ENTRE 2 PUNTOS (Reemplazar  a Regla.reglasAplicablesRey(m, i, j)) --- ////
    public static Regla elegirRegla(LinkedList<Regla> l, int i, int j) {
        int index = 0;
        int aux = Integer.MAX_VALUE;
        for (int k = 0; k < l.size(); k++) {
            int a = (i - l.get(k).fil);
            a *= a;
            int b = (j - l.get(k).col);
            b *= b;
            if ((a + b) < aux) {
                aux = (a + b);
                index = k;
            }
        }
        return l.remove(index);     
    }
    
    
    
    
    
    public static void mostrar(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + ", ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        int x[][] = new int[m][n];
        
        vueltas = 0;
        
        if (backtrackLaberintoRey(x, 0, 0, 5, 5, 1)) {
            mostrar(x);
            System.out.println("vueltas: " + vueltas);
        } else {
            System.out.println("no hay solucion");
        }
    }
}
