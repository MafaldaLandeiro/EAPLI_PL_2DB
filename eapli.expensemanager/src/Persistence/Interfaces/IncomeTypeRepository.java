package Persistence.Interfaces;

import Model.IncomeType;
import eapli.exception.EmptyList;
import java.util.List;

/*
 * @autor 1110186 & 1110590
 */
public interface IncomeTypeRepository {

    void save(IncomeType intType);
    List<IncomeType> getAllIncomeType() throws EmptyList;
}
