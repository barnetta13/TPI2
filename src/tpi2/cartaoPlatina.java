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

    // atributo que contém ID dos cartoes platina (CCD)
    private String cartaoPlatinaID = "CCD-Platina-";
    
    //  mensalidade base do cartão platina (CCD)
    private static float mensalidadeBase = 50;
    
    // saldo de peças mensal do cartão platina (CCD)
    private static int saldoPecas = 200;
    
    // número de peças necessárias para activar nova mensalidade base
    private static int pecasNovoSaldo = 100;
    
    // variável que guarda o número total de peças
    private int totalPecas = 0;
    
    // desconto a aplicar às peças que passem para além do saldo de peças mensal
    private static float descontoPecasAdicionais = 0.2f;
    
    // desconto a aplicar à mensalidade base quando ultrapassada o número de peças
    // definido para activação da nova mensalidade base 
    private static float descontoMensalidadeBase = 0.1f;
    
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
    public cartaoPlatina(String nome, int contribuinte, int numPecas)
    {
        super(nome, contribuinte, numPecas);
        this.cartaoPlatinaID = cartaoPlatinaID + getNumCartoesDesconto();
        totalPecas += super.getNumPecas();
        calculaSaldoProxMes();
    }
    
    /**
     * Inicializa um novo cartão atribuindo o nome por omissão, o contribuinte
     * por omissão, o número de peças lavadas por omissão, o ID do cartão, 
     * calcula o total de peças lavadas e calcula o número de peças a creditar
     * no próximo mês 
     */
    public cartaoPlatina()
    {
        super();
        this.cartaoPlatinaID = cartaoPlatinaID + getNumCartoesDesconto();
        totalPecas += super.getNumPecas();
        calculaSaldoProxMes();
    }
    
    /**
     * Devolve a representação textual do cartão
     * 
     * @return representação textual do cartão
     */
    @Override
    public String toString()
    {
        return "Cartão: " + getCartaoPlatinaID() + super.tostring();
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
        return "Cartão: " + getCartaoPlatinaID() + super.tostring() + "\nNumero de peças a creditar no próximo mês: " 
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
        return "Cartão: " + getCartaoPlatinaID();
    }
    
    /**
     * Devolve o número de peças adicionais para além do crédito mencionado
     * 
     * @return número de peças adicionais
     */
    public int getNumeroPecasAdicionais()
    {
        return super.getNumPecas() - saldoPecas; 
    }
    
    /**
     * aplica o desconto mencionado à mensalidade base
     */
    public float novaMensalidadeBase()
    {
        float desconto = 1 - descontoMensalidadeBase;
        return mensalidadeBase * desconto;
    }
    
    /**
     * Devolve a mensalidade a pagar
     * 
     * @return mensalidade
     */
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

    /**
     * Calcula o número de peças a creditar no próximo mês
     */
    public void calculaSaldoProxMes()
    {
        
        if (this.getNumPecas() < saldoPecas)
        {
            setNumPecasTransitar(saldoPecas - this.getNumPecas());
        }
        else 
            setNumPecasTransitar(0);  
    }
    
    /**
     * Devolve o ID do cartão platina
     * 
     * @return ID do cartão platina
     */
    public String getCartaoPlatinaID() {
        return cartaoPlatinaID;
    }
    
    /**
     * Devolve a mensalidade base
     * 
     * @return mensalidade base
     */
    public float getMensalidadeBase() {
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
     * Modifica o número de peças a creditar no próximo mês
     * 
     * @param numPecasTransitar novo número de peças a creditar
     */
    public void setNumPecasTransitar(int numPecasTransitar) {
        this.numPecasTransitar = numPecasTransitar;
    }
    
    /**
     * Devolve o desconto adicional à mensalidade base
     * 
     * @return desconto à mensalidade base
     */
    public static float getDescontoMensalidadeBase() {
        return descontoMensalidadeBase;
    }

    /**
     * Modifica o valor do desconto à mensalidade base
     * 
     * @param novaDescontoMensalidadeBase novo valor de desconto à mensalidade base
     */
    public static void setDescontoMensalidadeBase(float novaDescontoMensalidadeBase) {
        descontoMensalidadeBase = novaDescontoMensalidadeBase;
    }
    
    /**
     * Devolve o número de peças necessárias para ativar a nova mensalidade base
     * 
     * @return número de peças necessárias para ativar a nova mensalidade base
     */
    public static int getPecasNovoSaldo() {
        return pecasNovoSaldo;
    }

    /**
     * Modifica o número de peças necessárias para ativar a nova mensalidade base
     * 
     * @param novoPecasNovoSaldo novo número de peças necessárias para ativar a nova mensalidade base
     */
    public static void setPecasNovoSaldo(int novoPecasNovoSaldo) {
        pecasNovoSaldo = novoPecasNovoSaldo;
    }

    /**
     * Devolve o total de peças lavadas
     * 
     * @return total de peças lavadas
     */
    public int getTotalPecas() {
        return totalPecas;
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
     * Modifica a mensalidade base
     * 
     * @param novaMensalidadeBase nova mensalidade base
     */
    public static void setMensalidadeBase(float novaMensalidadeBase) {
        mensalidadeBase = novaMensalidadeBase;
    }
}
