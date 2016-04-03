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
public class TPI2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        cartaoPrata prata1 = new cartaoPrata("Joana",111222333,36);
        cartaoPrata prata2 = new cartaoPrata();
        
        cartaoOuro ouro1 = new cartaoOuro("Manel",222444555,17);
        cartaoOuro ouro2 = new cartaoOuro("Susana",333555777,30);
        
        cartaoPlatina platina1 = new cartaoPlatina("Matilde",444666888,78);
        cartaoPlatina platina2 = new cartaoPlatina("André",555777999,165);
        cartaoPlatina platina3 = new cartaoPlatina("Miguel",666888000,278);
 
        
        Object[] listaCartoes = new Object[10];
        
        listaCartoes[0] = prata1;
        listaCartoes[1] = prata2;
        listaCartoes[2] = ouro1;
        listaCartoes[3] = ouro2;
        listaCartoes[4] = platina1;
        listaCartoes[5] = platina2;
        listaCartoes[6] = platina3;
        
        float faturacaoMensal = 0;
        float faturacaoMensalPreDesconto = 0;
        float peso;
        float pesoPercentagem;
        for (int i = 0 ; i < listaCartoes.length ; i++)
        {
            if (listaCartoes[i] != null)
            {
                faturacaoMensal += ((cartoes)listaCartoes[i]).calculaMensalidade();
                faturacaoMensalPreDesconto += ((cartoes)listaCartoes[i]).calculaMensalidadeSemDesconto();
            }
        }
        
        for (int i = 0 ; i < listaCartoes.length ; i++)
        {
            if (listaCartoes[i] != null)
            {
                System.out.println(((cartoes)listaCartoes[i]).toString2());
                peso = ((cartoes)listaCartoes[i]).calculaMensalidade() / faturacaoMensal;
                pesoPercentagem = peso * 100;
                System.out.println("Percentagem na faturação total: " + pesoPercentagem + "%");
                System.out.println();
            }
        }
        
        System.out.println("Total faturado este mês (antes de aplicar os descontos): " + faturacaoMensalPreDesconto + "€");
        System.out.println("Total faturado este mês: "+ faturacaoMensal + "€");
        
        System.out.println();
        System.out.println("Percentagem na faturação total por cartão:");
        System.out.println();
        
        for (int i = 0 ; i < listaCartoes.length ; i++)
        {
            if (listaCartoes[i] != null)
            {
                System.out.println(((cartoes)listaCartoes[i]).toString3());
                peso = ((cartoes)listaCartoes[i]).calculaMensalidade() / faturacaoMensal;
                pesoPercentagem = peso * 100;
                System.out.println("Percentagem na faturação total: " + pesoPercentagem + "%");
                System.out.println();
            }
        }
    }
    
}
