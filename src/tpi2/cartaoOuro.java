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
    
    // atributo que contém ID dos cartoes ouro (CCD)
    private String cartaoOuroID = "CCD-Ouro-";
    
    //  mensalidade base do cartão ouro (CCD)
    private static float mensalidadeBase = 10;
    
    // saldo de peças mensal do cartão ouro (CCD)
    private static int saldoPecas = 25;
    
    // desconto a aplicar às peças que passem para além do saldo de peças mensal
    private static float descontoPecasAdicionais = 0.2f;
    
    // número de peças a creditar no próximo mês
    private int numPecasTransitar = 0;
    
    /**
     * Inicializa um novo cartão atribuindo o nome, o contribuinte, o
     * número de peças lavadas, o ID do cartão, calcula o total de peças lavadas
     * e calcula o número de peças a creditar no próximo mês 
     * 
     * @param nome nome do cliente
     * @param contribuinte contribuinte do cliente
     * @param numPecas número de peças lavadas do cliente
     */
    public cartaoOuro(String nome, int contribuinte, int numPecas)
    {
        super(nome, contribuinte, numPecas);
        this.cartaoOuroID = cartaoOuroID + getNumCartoesDesconto();
        insereSaldoProxMes();
    }
    
    /**
     * Inicializa um novo cartão atribuindo o nome por omissão, o contribuinte
     * por omissão, o número de peças lavadas por omissão, o ID do cartão, 
     * calcula o total de peças lavadas e calcula o número de peças a creditar
     * no próximo mês 
     */
    public cartaoOuro()
    {
        super();
        this.cartaoOuroID = cartaoOuroID + getNumCartoesDesconto();
        insereSaldoProxMes();
    }
    
    /**
     * Devolve a representação textual do cartão
     * 
     * @return representação textual do cartão
     */
    @Override
    public String tostring()
    {
        return "Cartão: " + getCartaoOuroID() + "\n" + super.toString();
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
    public String toString2()
    {
        return "Cartão: " + getCartaoOuroID() + super.tostring() + "\nNumero de peças a creditar no próximo mês: " 
                + getNumPecasTransitar() + "\nMensalide S/ Desconto: " + calculaMensalidadeSemDesconto() + 
                "€\nMensalidade C/ Descconto: " + calculaMensalidade() + "€";
    }
    
    /**
     * Devolve o ID do cartao
     * 
     * @return ID do cartao
     */
    @Override
    public String toString3()
    {
        return "Cartão: " + getCartaoOuroID();
    }
    
    /**
     * Devolve o número de peças adicionais para além do crédito mencionado
     * 
     * @return número de peças adicionais
     */
    public int getNumeroPecasAdicionais()
    {
        return getNumPecas() - saldoPecas; 
    }
    
    /**
     * Devolve a mensalidade a pagar
     * 
     * @return mensalidade
     */
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

    /**
     * Calcula o número de peças a creditar no próximo mês
     */
    public void insereSaldoProxMes()
    {
        if (this.getNumPecas() < saldoPecas)
        {
            setNumPecasTransitar(saldoPecas - this.getNumPecas());
        }
        else 
            setNumPecasTransitar(0);  
    }
    
    /**
     * Devolve o ID do cartão ouro
     * 
     * @return ID do cartão ouro
     */
    public String getCartaoOuroID() {
        return cartaoOuroID;
    }
    
    /**
     * Devolve a mensalidade base
     * 
     * @return mensalidade base
     */
    public static float getMensalidadeBase() {
        return mensalidadeBase;
    }

    /**
     * Devolve o saldo mensal de peças do cartão platina
     * 
     * @return saldo mensal
     */
    public static int getSaldoPecas() {
        return saldoPecas;
    }

    /**
     * Devolve o desconto para as peças adicionais ao valor do saldo mensal
     * 
     * @return desconto peças adicionais
     */
    public static float getDescontoPecasAdicionais() {
        return descontoPecasAdicionais;
    }

    /**
     * Modifica a mensalidade base
     * 
     * @param novaMensalidadeBase nova mensalidade base
     */
    public static void setMensalidadeBase(int novaMensalidadeBase) {
        setMensalidadeBase(novaMensalidadeBase);
    }

    /**
     * Modifica o saldo mensal de peças do cartão platina
     * 
     * @param novoSaldoPecas o novo saldo de peças mensal do cartão platina
     */
    public static void setSaldoPecas(int novoSaldoPecas) {
        saldoPecas = novoSaldoPecas;
    }

    /**
     * Modifica o valor do desconto das peças adicionais, valor divido por 100
     * pois o valor recebido por parâmetro é recebido em percentagem
     *
     * @param novoDescontoPecasAdicionais novo valor do desconto das peças adicionais
     */
    public static void setDescontoPecasAdicionais(float novoDescontoPecasAdicionais) {
        descontoPecasAdicionais = novoDescontoPecasAdicionais/100;
    }

    /**
     * Devolve o número de peças a creditar no próximo mês
     * 
     * @return número de peças a creditar
     */
    public int getNumPecasTransitar() {
        return numPecasTransitar;
    }

    /**
     * Permite o cálculo da mensalidade (sem aplicar os descontos)
     * 
     * @return mensalidade sem descontos
     */
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

    /**
     * Modifica o ID do cartão Ouro
     * 
     * @param cartaoOuroID novo ID cartão ouro
     */
    public void setCartaoOuroID(String cartaoOuroID) {
        this.cartaoOuroID = cartaoOuroID;
    }

    /**
     * Modifica o número de peças a creditar
     * 
     * @param numPecasTransitar novo número peças creditar
     */
    public void setNumPecasTransitar(int numPecasTransitar) {
        this.numPecasTransitar = numPecasTransitar;
    }
    
    
    /**
     * Modifica a mensalidade
     * 
     * @param novaMensalidadeBase nova mensalidade
     */
    public static void setMensalidadeBase(float novaMensalidadeBase) {
        mensalidadeBase = novaMensalidadeBase;
    }
}
