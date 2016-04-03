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
    
    // ID do cartão com desconto (CCD)
    private static int numCartoesDesconto = 0; 
            
    /**
     * Permite o cálculo da mensalidade através do polimorfismo
     * 
     * @return o valor da mensalidade
     */
    @Override
    public abstract float calculaMensalidade();
    
    /**
     * Inicializa um novo cartão atribuindo o nome, o contribuinte e o
     * número de peças lavadas e incrementa (em 1) o número de cartoes com 
     * desconto (ccd)
     * 
     * @param nome nome do cliente
     * @param contribuinte contribuinte do cliente
     * @param numPecas número de peças lavadas do cliente
     */
    public cartaoDesconto(String nome, int contribuinte, int numPecas)
    {
        super(nome, contribuinte, numPecas);
        incrementaNumCartoesDesconto();
    }
    
    /**
     * Inicializa um novo cartão atribuindo o nome por omissão, o contribuinte por omissão e o
     * número de peças lavadas por omissão e incrementa (em 1) o número de cartoes com 
     * desconto (ccd)
     */
    public cartaoDesconto()
    {
        super();
        incrementaNumCartoesDesconto();
    }
    
    /**
     * Devolve as informações do cartão, o número de peças que transitam
     * para o próximo mês ( caso aplicável) bem como o valor da mensalidade 
     * (com e sem desconto)
     * 
     * @return informações do cartão, o número de peças que transitam
     * para o próximo mês bem como o valor da mensalidade (com e sem desconto)
     */
    @Override
    public abstract String toString2();
    
    /**
     * Devolve o ID do cartao
     * 
     * @return ID do cartao
     */
    @Override
    public abstract String toString3();

    /**
     * Devolve o número de cartões com desconto (ccd)
     *
     * @return número de cartões com desconto (ccd)
     */
    public int getNumCartoesDesconto() {
        return numCartoesDesconto;
    }

    /**
     * Incrementa o número de cartões com desconto (ccd) em 1 de modo a que  
     * todos os cartões com desconto (ccd) tenham um ID único
     */
    public static void incrementaNumCartoesDesconto() {
        numCartoesDesconto++;
    }
    
    /**
     * Devolve a representação textual do cartão
     * 
     * @return representação textual do cartão
     */
    @Override
    public String toString()
    {
        return super.tostring();
    }
    
    /**
     * Modifica o número de cartões desconto
     * 
     * @param aNumCartoesDesconto novo número de cartões desconto
     */
    public static void setNumCartoesDesconto(int aNumCartoesDesconto) {
        numCartoesDesconto = aNumCartoesDesconto;
    }
   
}
