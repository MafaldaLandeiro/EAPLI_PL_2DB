/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.JPA;

import Model.IncomeType;
import Persistence.Interfaces.IncomeTypeRepository;
import java.util.List;

/**
 * Classe Repositorio em JPA de tipos de rendimentos
 *
 * @autor 1110186 & 1110590
 */
public class IncomeTypeRepositoryImpl extends Jpa<IncomeType,String> implements IncomeTypeRepository{
    
    
    
    @Override
    public void save(IncomeType intType) {
        super.save(intType);
    }

    @Override
    public List<IncomeType> getAllIncomeType() {
        
        return null;
    }
    
}
