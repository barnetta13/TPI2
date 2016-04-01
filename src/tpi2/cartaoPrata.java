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
public class cartaoPrata extends cartoes{
    
    private String cartaoPrataID = "CSD-Prata-";
    
    private static int numCartoes = 1;
    
    public cartaoPrata(String nome, int contribuinte, int numPecas)
    {
        super(nome, contribuinte, numPecas);
        this.cartaoPrataID = cartaoPrataID + numCartoes;
        numCartoes++;
    }
    
    public cartaoPrata()
    {
        super();
        this.cartaoPrataID = cartaoPrataID + numCartoes;
        numCartoes++;
    }
    
    @Override
    public String tostring()
    {
        return "Cartão: " + getCartaoPrataID() + "\n" + super.toString();
    }
    
    @Override
    public String toString2()
    {
        return "Cartão: " + getCartaoPrataID() + super.tostring() + "\nMensalidade (em €):" + calculaMensalidade();
    }
    
    @Override
    public String toString3()
    {
        return "Cartão: " + getCartaoPrataID();
    }
    
    @Override
    public float calculaMensalidade()
    {
        return super.getNumPecas() * super.getPbp();
    }

    public String getCartaoPrataID() {
        return cartaoPrataID;
    }

    @Override
    public float calculaMensalidadeSemDesconto() {
        return getNumPecas() * getPbp();
    }
    
}
