/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Filipe
 */
public class Account {
    
    BigDecimal saldo;
    String nomeOwner;
    int nConta;
    BigDecimal bd,bD;
    
   
    List<Income> listIncome;
    private Iterable<Expense> listExpense;
   
  
    /**
     *
     */
    public Account(){
        
        
       
    }
    
    void setSaldoInicial(BigDecimal saldo){
             
       // if(re.setSaldo(saldo))
       //     this.saldo=saldo;    
        
    }
    
   
          public BigDecimal allCombined(){
            for(Expense o : listExpense){
                bd=bd.add(o.getAmount());
            } 
            for(Income i: listIncome){
                bD=bD.add(i.getAmount());
                
            }  
            bd.negate();
            return bD.add(bd);
        }
    
    
}
