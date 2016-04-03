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
public abstract class cartoes {

    /**
     * O nome do cliente.
     */
    private String nome;
    
    /**
     * O contribuinte do cliente.
     */
    private int contribuinte;
    
    /**
     * O número mensal de peças lavadasdo cliente.
     */
    private int numPecas;
    
    /**
     * Preço base por peça.
     */
    private static float pbp = 0.5f;
    
    /**
     * O nome do cliente por omissão.
     */
    private static final String NOME_POR_OMISSAO = "Consumidor Final";
    
    /**
     * O contribuinte do cliente por omissão.
     */
    private static final int CONTRIBUINTE_POR_OMISSAO = 999999990;
    
    /**
     * O número mensal de peças lavadasdo cliente por omissão.
     */
    private static final int NUMERO_PECAS_POR_OMISSAO = 0;
    
    /**
     * Inicializa um novo cartão atribuindo o nome, o contribuinte e o
     * número de peças lavadas.
     * 
     * @param nome nome do cliente
     * @param contribuinte contribuinte do cliente
     * @param numPecas número de peças lavadas do cliente
     */
    public cartoes(String nome, int contribuinte, int numPecas)
    {
        this.nome = nome;
        this.contribuinte = contribuinte;
        this.numPecas = numPecas;
    }
    
    /**
     * Inicializa um novo cartão atribuindo o nome por omissão, o contribuinte 
     * por omissão e o número de peças lavadas por omissão.
     */
    public cartoes()
    {
        this.nome = NOME_POR_OMISSAO;
        this.contribuinte = CONTRIBUINTE_POR_OMISSAO;
        this.numPecas = NUMERO_PECAS_POR_OMISSAO;
    }
    
    /**
     *Permite o cálculo da mensalidade através do polimorfismo
     * 
     * @return o valor da mensalidade
     */
    public abstract float calculaMensalidade();
    
    /**
     * Devolve as informações do cartão, o número de peças que transitam
     * para o próximo mês bem como o valor da mensalidade (com e sem desconto)
     * 
     * @return informações do cartão, o número de peças que transitam
     * para o próximo mês bem como o valor da mensalidade (com e sem desconto)
     */
    public abstract String toString2();
    
    /**
     * Devolve o ID do cartao
     * 
     * @return ID do cartao
     */
    public abstract String toString3();
    

    /**
     *Permite o cálculo da mensalidade (sem aplicar os descontos) através do
     * polimorfismo
     * 
     * @return mensalidade sem descontos
     */
    public abstract float calculaMensalidadeSemDesconto();
    
    /**
     * Devolve a representação textual do cartão
     * 
     * @return representação textual do cartão
     */
    public String tostring()
    {
        return "\nNome: " + nome + "\nContribuinte: " + contribuinte + "\nNúmero de Peças (mês actual): " + numPecas;
    }
            
    /**
     * Devolve o nome do cliente
     * 
     * @return nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve o contribuinte do cliente
     * 
     * @return contribuinte do cliente
     */
    public int getContribuinte() {
        return contribuinte;
    }

    /**
     * Devolve o número de peças lavadas no mês 
     * 
     * @return número de peças lavadas no mês
     */
    public int getNumPecas() {
        return numPecas;
    }

    /**
     * Modifica o nome do cliente
     * 
     * @param nome o novo nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica o contribuinte do cliente
     * 
     * @param contribuinte o novo contribuinte do cliente
     */
    public void setContribuinte(int contribuinte) {
        this.contribuinte = contribuinte;
    }

    /**
     * Modifica o número de peças lavadas no mês 
     * 
     * @param numPecas o novo número de peças lavadas do cliente
     */
    public void setNumPecas(int numPecas) {
        this.numPecas = numPecas;
    }
    
    /**
     * Devolve o preço base por peça
     * 
     * @return preço base por peça
     */
    public static float getPbp() {
        return pbp;
    }

    /**
     * Modifica o preço base por peça
     * 
     * @param novoPBP o novo preço base por peça
     */
    public static void setPbp(float novoPBP) {
        pbp = novoPBP;
    }
}
