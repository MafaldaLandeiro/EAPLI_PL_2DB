
package Persistence;

import Model.DebitCard;
import Model.ExpenseType;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe repositorio para armazenar os cartões de debito
 * 
 * @author nbento
 */
public class DebiteCardRepository {

    private static ArrayList<DebitCard> listDebitCards = new ArrayList<DebitCard>();
    
    public DebiteCardRepository(){}
    
    /**
     * Adicionar uma novo cartão de debito no repositorio
     * 
     * @param dc - Objeto cartão de debito
     */
    public void save(DebitCard dc){
        if (dc==null) throw new IllegalArgumentException();
        listDebitCards.add(dc);
    }
    
    /**
     * Devolve todos os cartões de debito do repositorio
     * 
     * @return Lista completa dos cartões de debito
     */
    public ArrayList<DebitCard> getAllDebitCard(){
        return listDebitCards;
    }
    
    
}