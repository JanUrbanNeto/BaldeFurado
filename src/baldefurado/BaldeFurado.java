/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baldefurado;

/**
 *
 * @author JanNeto
 */
public class BaldeFurado {
    
    private int[] balde = new int[21];
    private int totalGotas = 0;
    private int gotasIn = 0;
    private int gotasNoBalde = 0;
    private int desperdicio = 0;
    private int desperdicioTotal = 0;
    private int ciclosOciosos = 0;
    private boolean cicloOcioso = false;
        
    public void encheBalde() {
    
            for(int i = 1; i <= 100; i++){
                gotasIn = 0 + (int)(4*Math.random());
                
                if(gotasNoBalde == 0 && gotasIn == 0) {
                    cicloOcioso = true;
                    ciclosOciosos++;
                
                } else if (gotasNoBalde > 0 && gotasIn == 0) {
                    balde[gotasNoBalde] = 0;
                    gotasNoBalde--;
                    cicloOcioso = false;
                
                } else if(gotasNoBalde >= 0 && gotasIn > 0) {
                    totalGotas += gotasIn;
                    if(gotasNoBalde + gotasIn < 20) {    
                        
                        for(int j = 0; j < gotasIn; j++) {
                            balde[gotasNoBalde] = 1;
                            gotasNoBalde++;
                        }
                        balde[gotasNoBalde] = 0;
                        gotasNoBalde--;
                        cicloOcioso = false;
                    
                    } else {
                        desperdicio = (gotasNoBalde + gotasIn) - 20;
                        desperdicioTotal += desperdicio;
                        
                        for(int j = 0; j < gotasIn - desperdicio; j++) {
                            balde[gotasNoBalde] = 1;
                            gotasNoBalde++;
                        }
                        balde[gotasNoBalde] = 0;
                        gotasNoBalde--;
                        cicloOcioso = false;
                    }        
                
                } else {
                    System.out.println("Erro");
                }
                
                if(!cicloOcioso) {
                    System.out.println("Ciclo " + i + ": Gotas entrando = " + gotasIn + ", Gotas desperdiçadas = " + desperdicio + ", Gotas saindo = 1, Total de gotas no Balde = " + gotasNoBalde);
                } else {
                    System.out.println("Ciclo " + i + " ocioso, balde vazio.");
                }    
            }
        }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BaldeFurado b1 = new BaldeFurado();
        b1.encheBalde();
        System.out.println("Total de gotas que pingaram no balde: " + b1.totalGotas + ", Desperdicio total: " + b1.desperdicioTotal);
    }
    
}
