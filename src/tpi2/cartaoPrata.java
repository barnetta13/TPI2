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
public abstract class cartaoPrata extends cartoes{
    
    private String cartaoPrataID = "CSD-Prata-";
    
    public cartaoPrata(String nome, int contribuinte, int numPecas)
    {
        super(nome, contribuinte, numPecas);
        this.cartaoPrataID = cartaoPrataID + super.getNumCartao();
    }
    
    public cartaoPrata()
    {
        super();
        this.cartaoPrataID = cartaoPrataID + super.getNumCartao();
        super.incrementaNumCartao();
    }
    
    @Override
    public String tostring()
    {
        return "Cartão: " + cartaoPrataID + "\n" + super.toString();
    }
    
    public String tostring2()
    {
        return "Cartão: " + cartaoPrataID + "\n" + super.toString() + "\nMensalidade:" + calculaMensalidade();
    }
    
    @Override
    public float calculaMensalidade()
    {
        return super.getNumPecas() * super.getPbp();
    }
    
}
