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

    // atributo que contém ID dos cartoes prata
    private String cartaoPrataID = "CSD-Prata-";
    
    // variaável que determina o ID do cartão prata
    private static int numCartoes = 1;
    
    /**
     * Inicializa um novo cartão atribuindo o nome, o contribuinte, o
     * número de peças lavadas, o ID do cartão de Prata e incrementa em 1 o ID
     * do cartão de prata
     * 
     * @param nome nome do cliente
     * @param contribuinte contribuinte do cliente
     * @param numPecas número de peças lavadas do cliente
     */
    public cartaoPrata(String nome, int contribuinte, int numPecas)
    {
        super(nome, contribuinte, numPecas);
        this.cartaoPrataID = cartaoPrataID + numCartoes;
        numCartoes++;
    }
    
    /**
     * Inicializa um novo cartão atribuindo o nome, o contribuinte, o
     * número de peças lavadas, o ID do cartão de Prata e incrementa em 1 o ID
     * do cartão de prata
     */
    public cartaoPrata()
    {
        super();
        this.cartaoPrataID = cartaoPrataID + numCartoes;
        numCartoes++;
    }
    
    /**
     * Devolve a representação textual do cartão
     * 
     * @return representação textual do cartão
     */
    @Override
    public String tostring()
    {
        return "Cartão: " + getCartaoPrataID() + "\n" + super.toString();
    }
    
    /**
     * Devolve as informações do cartão e o valor da mensalidade (com e sem desconto)
     * 
     * @return informações do cartão, o número de peças que transitam
     * para o próximo mês bem como o valor da mensalidade (com e sem desconto)
     */
    @Override
    public String toString2()
    {
        return "Cartão: " + getCartaoPrataID() + super.tostring() + "\nMensalidade: " + calculaMensalidade() + "€";
    }
    
    /**
     * Devolve o ID do cartao
     * 
     * @return ID do cartao
     */
    @Override
    public String toString3()
    {
        return "Cartão: " + getCartaoPrataID();
    }
    
    /**
     * Permite o cálculo da mensalidade
     * 
     * @return o valor da mensalidade
     */
    @Override
    public float calculaMensalidade()
    {
        return super.getNumPecas() * super.getPbp();
    }

    /**
     * Devolve o ID do cartão de prata (CSD)
     * 
     * @return ID cartão de prata (CSD)
     */
    public String getCartaoPrataID() {
        return cartaoPrataID;
    }

    /**
     * Permite o cálculo da mensalidade (sem aplicar os descontos)
     * 
     * @return mensalidade sem descontos
     */
    @Override
    public float calculaMensalidadeSemDesconto() {
        return getNumPecas() * getPbp();
    }

    /**
     * Modifica o ID do cartão Prata
     * 
     * @param cartaoPrataID novo ID cartão prata
     */
    public void setCartaoPrataID(String cartaoPrataID) {
        this.cartaoPrataID = cartaoPrataID;
    }
    
    /**
     * Devolve o número de cartões
     * 
     * @return número de cartões
     */
    public static int getNumCartoes() {
        return numCartoes;
    }

    /**
     * Modifica o número de cartões
     * 
     * @param novoNumCartoes novo número de cartões
     */
    public static void setNumCartoes(int novoNumCartoes) {
        numCartoes = novoNumCartoes;
    }
    
}
