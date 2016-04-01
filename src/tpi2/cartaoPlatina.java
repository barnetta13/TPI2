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
public class cartaoPlatina extends cartaoDesconto{

    private String cartaoPlatinaID = "CCD-Platina-";
    
    private float mensalidadeBase = 50;
    private static int saldoPecas = 200;
    private static int pecasNovoSaldo = 100;
    private int totalPecas = 0;
    
    private static float descontoPecasAdicionais = 0.2f;
    private static float descontoMensalidadeBase = 0.1f;
    
    private int numPecasTransitar = 0;
    
    public cartaoPlatina(String nome, int contribuinte, int numPecas)
    {
        super(nome, contribuinte, numPecas);
        this.cartaoPlatinaID = cartaoPlatinaID + getNumCartoesDesconto();
        incrementaNumCartoesDesconto();
        //super.incrementaNumCartao();
        totalPecas += super.getNumPecas();
        calculaSaldoProxMes();
    }
    
    public cartaoPlatina()
    {
        super();
        this.cartaoPlatinaID = cartaoPlatinaID + getNumCartoesDesconto();
        incrementaNumCartoesDesconto();
        //super.incrementaNumCartao();
        calculaSaldoProxMes();
    }
    
    @Override
    public String tostring()
    {
        return "Cartão: " + cartaoPlatinaID + "\n" + super.toString();
    }
    
    @Override
    public String toString2()
    {
        return "Cartão: " + getCartaoPlatinaID() + super.tostring() + "\nNumero de peças a creditar no próximo mês: " 
                + getNumPecasTransitar() + "\nMensalide S/ Desconto: " + calculaMensalidadeSemDesconto() + 
                "€\nMensalidade C/ Descconto: " + calculaMensalidade() + "€";
    }
    
    @Override
    public String toString3()
    {
        return "Cartão: " + getCartaoPlatinaID();
    }
    
    public void ativaNovaMensalidade()
    {
        float desconto = 1 - descontoMensalidadeBase;
        mensalidadeBase = mensalidadeBase * desconto;
    }
    
    public int getNumeroPecasAdicionais()
    {
        return super.getNumPecas() - saldoPecas; 
    }
    
    public float novaMensalidadeBase()
    {
        float desconto = 1 - descontoMensalidadeBase;
        return mensalidadeBase * desconto;
    }
    
    @Override
    public float calculaMensalidade()
    {
        float novaMensalidade = novaMensalidadeBase();
        if (totalPecas > 100 && getNumPecas() <= 200)
        {
            return novaMensalidade;
        }
        else if (getNumPecas() <= 100 && totalPecas <= 100)
        {
            return mensalidadeBase;
        }
        else
        {
        float desconto = 1 - descontoPecasAdicionais;
        float novoPBP = cartoes.getPbp() * desconto;
        float valorAdicional = getNumeroPecasAdicionais() * novoPBP;
        return novaMensalidade + valorAdicional;
        }
    }

    public void calculaSaldoProxMes()
    {
        
        if (this.getNumPecas() < saldoPecas)
        {
            setNumPecasTransitar(saldoPecas - this.getNumPecas());
        }
        else 
            setNumPecasTransitar(0);  
    }
    
    public String getCartaoPlatinaID() {
        return cartaoPlatinaID;
    }
    
    public float getMensalidadeBase() {
        return mensalidadeBase;
    }

    public static int getSaldoPecas() {
        return saldoPecas;
    }

    public static float getDescontoPecasAdicionais() {
        return descontoPecasAdicionais;
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

    public void setNumPecasTransitar(int numPecasTransitar) {
        this.numPecasTransitar = numPecasTransitar;
    }
    
    public static float getDescontoMensalidadeBase() {
        return descontoMensalidadeBase;
    }

    public static void setDescontoMensalidadeBase(float novaDescontoMensalidadeBase) {
        descontoMensalidadeBase = novaDescontoMensalidadeBase;
    }
    
        public static int getPecasNovoSaldo() {
        return pecasNovoSaldo;
    }

    public static void setPecasNovoSaldo(int aPecasNovoSaldo) {
        pecasNovoSaldo = aPecasNovoSaldo;
    }

    public int getTotalPecas() {
        return totalPecas;
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
