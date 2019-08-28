
package juegocontorres;
/**
 *
 * @author yeisonfernando
 */

import java.util.Scanner;

public class JuegoConTorres {

    public static void main(String[] args) {
        
         
        Scanner sc = new Scanner(System.in);
        int R, C, N;
        
        System.out.println("DIGITE TAMAÑO FILAS:");
        R = sc.nextInt();
        R = validarRC(R);

        System.out.println("DIGITE TAMAÑO COLUMNAS:");
        C = sc.nextInt();
        C = validarRC(C);
        
        System.out.println("DIGITE NUMEROS DE TORRES SIN COLOR:");
        N = sc.nextInt();
        int maxTorres = R*C ;
        N = validarN(N, maxTorres);
        
        System.out.println("Filas: "+R +"\nColumnas:"+C + "\nTorres"+ N);
        
        String tablero [][];
        tablero = construir ( R, C, N );
        
        mostrarTablero(tablero);
    }


    public static int validarRC (int num){
        
        Scanner sc = new Scanner(System.in);
        do{
                       
            if (num < 1 || num > 50){
                System.out.println("El tamaño debe ser entre 1 y 50 inclusive");
                System.out.println("VUELVA A DIGITAR EL TAMAÑO:");
                num = sc.nextInt();                
                }             
                       
        } while(num < 1 || num > 50);
        return num;
    }
        
    
    public static int validarN (int num, int maxTorres){
        
        Scanner sc = new Scanner(System.in);
        do{
                       
            if (num < 1 || num > maxTorres){
                System.out.println("El tamaño debe ser entre 1 y "+ maxTorres +" inclusive");
                System.out.println("VUELVA A DIGITAR EL TAMAÑO:");
                num = sc.nextInt();                
                }             
                       
        } while(num < 1 || num > maxTorres);
        return num;
    }
    
    public static String[][] construir (int R, int C, int N){
        
        String[][] tablero = new String[R][C]; 

        int cont = 0;
        for(int i = 0; i < R; ++i){
            for (int j = 0; j < C; ++j){
                int mod = (i + j) % 2;
                if (cont < N){
                    if (i == 0) {
                        ubicarTorres(tablero, mod, i, j);
                    } else if (i != 0) {
                        ubicarTorres(tablero, mod, i, j);
                    }

                }else {
                    tablero[i][j] = ".";
                }
                cont++;
            }
        }
            
        return tablero; 
    }
 
    public static void ubicarTorres(String[][] tablero, int mod, int i, int j) {
        if (mod == 0) {
            tablero[i][j] = "W";
        } else {
            tablero[i][j] = "B";
        }
    }
    
    private static void mostrarTablero(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.printf(tablero[i][j] + "       ");
            }
        System.out.println("");
        }
    }

}
