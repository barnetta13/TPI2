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
public abstract class cartaoOuro extends cartaoDesconto{

    
    private String cartaoOuroID = "CCD-Ouro-";
    
    private static int mensalidadeBase = 10;
    private static int saldoPecas = 25;
    
    private static float descontoPecasAdicionais = 0.2f;
    
    private int numPecasTransitar = 0;
    private int numPecasMesAnterior = 0;
    
    public cartaoOuro(String nome, int contribuinte, int numPecas)
    {
        super(nome, contribuinte, numPecas);
        this.cartaoOuroID = cartaoOuroID + super.getNumCartao();
    }
    
    public cartaoOuro()
    {
        super();
        this.cartaoOuroID = cartaoOuroID + super.getNumCartao();
        super.incrementaNumCartao();
    }
    
    @Override
    public String tostring()
    {
        return "Cartão: " + getCartaoOuroID() + "\n" + super.toString();
    }
    
    public String tostring2()
    {
        return "Cartão: " + getCartaoOuroID() + "\n" + super.toString() + "Número de peças creditadas do mês passado:" 
                + getNumPecasMesAnterior() + "Numero de peças a creditar no próximo mês:" + getNumPecasTransitar() + 
                "Mensalide S/ Desconto (em €): " + calculaMensalidadeSemDesconto() + 
                "\nMensalidade C/ Descconto (em €):" + calculaMensalidade();
    }
    
    public int getNumeroPecasAdicionais()
    {
        return super.getNumPecas() - saldoPecas; 
    }
    
    @Override
    public float calculaMensalidade()
    {
        float desconto = 1 - descontoPecasAdicionais;
        float novoPBP = cartoes.getPbp() * desconto;
        float valorAdicional = getNumeroPecasAdicionais() * novoPBP;
        return mensalidadeBase + valorAdicional;
    }

    public float calculaSaldoProxMes()
    {
        
        if (this.getNumPecas() < saldoPecas)
        {
            setNumPecasTransitar(saldoPecas - this.getNumPecas());
        }
        else 
            setNumPecasTransitar(0);  
        return getNumPecasTransitar();
    }
    
    public void mudaMes()
    {
        setNumPecasMesAnterior(getNumPecasTransitar());
        setNumPecasTransitar(0);
    }
    
    public String getCartaoOuroID() {
        return cartaoOuroID;
    }
    
    public static int getMensalidadeBase() {
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

    public int getNumPecasMesAnterior() {
        return numPecasMesAnterior;
    }

    public void setNumPecasTransitar(int numPecasTransitar) {
        this.numPecasTransitar = numPecasTransitar;
    }

    public void setNumPecasMesAnterior(int numPecasMesAnterior) {
        this.numPecasMesAnterior = numPecasMesAnterior;
    }
    
}
