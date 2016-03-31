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
    
    @Override
    public abstract float calculaMensalidade();
    
    @Override
    public abstract float calculaMensalidadeSemDesconto();
    
    public cartaoDesconto(String nome, int contribuinte, int numPecas)
    {
        super(nome, contribuinte, numPecas);
    }
    
    public cartaoDesconto()
    {
        super();
    }
   
}
