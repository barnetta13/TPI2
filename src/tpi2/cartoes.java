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

    
    private int numCartao = 1;
    private String nome;
    private int contribuinte;
    private int numPecas;
    
    private static float pbp = 0.5f;
    
    private static final String NOME_POR_OMISSAO = "N/A";
    private static final int CONTRIBUINTE_POR_OMISSAO = 999999990;
    private static final int NUMERO_PECAS_POR_OMISSAO = 0;
    
    public cartoes(String nome, int contribuinte, int numPecas)
    {
        this.nome = nome;
        this.contribuinte = contribuinte;
        this.numPecas = numPecas;
    }
    
    public cartoes()
    {
        this.nome = NOME_POR_OMISSAO;
        this.contribuinte = CONTRIBUINTE_POR_OMISSAO;
        this.numPecas = NUMERO_PECAS_POR_OMISSAO;
    }
    
    public abstract float calculaMensalidade();
    
    public float calculaMensalidadeSemDesconto()
    {
        return getNumPecas() * getPbp();
    }
    
    public float calculaPeso()
    {
        return 
    }
    
    public String tostring()
    {
        return "\nNome: " + nome + "\nContribuinte: " + contribuinte + "Número de Peças (mês actual): " + numPecas;
    }
    
    public void incrementaNumCartao()
    {
        numCartao++;
    }
            
    public String getNome() {
        return nome;
    }

    public int getContribuinte() {
        return contribuinte;
    }

    public int getNumPecas() {
        return numPecas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContribuinte(int contribuinte) {
        this.contribuinte = contribuinte;
    }

    public void setNumPecas(int numPecas) {
        this.numPecas = numPecas;
    }

    public int getNumCartao() {
        return numCartao;
    }
    
    public static float getPbp() {
        return pbp;
    }

    public static void setPbp(float novoPBP) {
        pbp = novoPBP;
    }
}
