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
public class cartaoOuro extends cartaoDesconto{
    
    private String cartaoOuroID = "CCD-Ouro-";
    
    private static float mensalidadeBase = 10;
    private static int saldoPecas = 25;
    
    private static float descontoPecasAdicionais = 0.2f;
    
    private int numPecasTransitar = 0;
    
    public cartaoOuro(String nome, int contribuinte, int numPecas)
    {
        super(nome, contribuinte, numPecas);
        this.cartaoOuroID = cartaoOuroID + getNumCartoesDesconto();
        incrementaNumCartoesDesconto();
        //super.incrementaNumCartao();
        insereSaldoProxMes();
    }
    
    public cartaoOuro()
    {
        super();
        this.cartaoOuroID = cartaoOuroID + getNumCartoesDesconto();
        incrementaNumCartoesDesconto();
        //incrementaNumCartao();
        insereSaldoProxMes();
    }
    
    @Override
    public String tostring()
    {
        return "Cartão: " + getCartaoOuroID() + "\n" + super.toString();
    }
    
    @Override
    public String toString2()
    {
        return "Cartão: " + getCartaoOuroID() + super.tostring() + "\nNumero de peças a creditar no próximo mês: " 
                + getNumPecasTransitar() + "\nMensalide S/ Desconto: " + calculaMensalidadeSemDesconto() + 
                "€\nMensalidade C/ Descconto: " + calculaMensalidade() + "€";
    }
    
    @Override
    public String toString3()
    {
        return "Cartão: " + getCartaoOuroID();
    }
    
    public int getNumeroPecasAdicionais()
    {
        return getNumPecas() - saldoPecas; 
    }
    
    @Override
    public float calculaMensalidade()
    {
        if (getNumPecas() > saldoPecas)
        {
        float desconto = 1 - descontoPecasAdicionais;
        float novoPBP = cartoes.getPbp() * desconto;
        float valorAdicional = getNumeroPecasAdicionais() * novoPBP;
        return mensalidadeBase + valorAdicional;
        }
        else
            return mensalidadeBase;
    }

    public void insereSaldoProxMes()
    {
        if (this.getNumPecas() < saldoPecas)
        {
            numPecasTransitar = saldoPecas - this.getNumPecas();
        }
        else 
            numPecasTransitar = 0;  
    }
    
    public String getCartaoOuroID() {
        return cartaoOuroID;
    }
    
    public static float getMensalidadeBase() {
        return mensalidadeBase;
    }

    public static int getSaldoPecas() {
        return saldoPecas;
    }

    public static float getDescontoPecasAdicionais() {
        return descontoPecasAdicionais;
    }

    public static void setMensalidadeBase(int novaMensalidadeBase) {
        mensalidadeBase = novaMensalidadeBase;
    }

    public static void setSaldoPecas(int novoSaldoPecas) {
        saldoPecas = novoSaldoPecas;
    }

    public static void setDescontoPecasAdicionais(float novoDescontoPecasAdicionais) {
        descontoPecasAdicionais = novoDescontoPecasAdicionais/100;
    }

    public int getNumPecasTransitar() {
        return numPecasTransitar;
    }

    @Override
    public float calculaMensalidadeSemDesconto() {
        float mensalidade = getNumPecas() * getPbp();
        if (mensalidade > mensalidadeBase)
        {
            return mensalidade;
        }
        else
            return mensalidadeBase;
    }
}
