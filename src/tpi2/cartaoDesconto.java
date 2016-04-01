/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpi2;

/**
 *
 * @author Daniel Martins
 */
public abstract class cartaoDesconto extends cartoes{
    
    private static int numCartoesDesconto = 1; 
            
    @Override
    public abstract float calculaMensalidade();
    
    public cartaoDesconto(String nome, int contribuinte, int numPecas)
    {
        super(nome, contribuinte, numPecas);
    }
    
    public cartaoDesconto()
    {
        super();
    }
    
    @Override
    public abstract String toString2();
    
    @Override
    public abstract String toString3();

    public int getNumCartoesDesconto() {
        return numCartoesDesconto;
    }

    public static void incrementaNumCartoesDesconto() {
        numCartoesDesconto++;
    }
   
}
