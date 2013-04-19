/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Expense;
import Model.ExpenseType;
import Model.PaymentMean;
import Persistence.ExpenseRepository;
import Persistence.ExpenseTypeRepository;
import Persistence.PaymentMeanRepository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/***
 *
 * @author nbento
 */
public class RegisterExpenseController extends BaseController{

    /**
     * @autor nbento
     * @return
     * @throws IllegalArgumentException
     */
    public List<ExpenseType> getExpenseType() throws IllegalArgumentException {

        List<ExpenseType> expenseTypes;

        ExpenseTypeRepository expenseTypeRepository = new ExpenseTypeRepository();

        //Lista completa dos tipos de despesas
        expenseTypes = expenseTypeRepository.getAllExpenseType();

        if (expenseTypes == null) {
            throw new IllegalArgumentException();
        }

        return expenseTypes;


    }

    /**
     * @autor nbento
     * @return
     * @throws IllegalArgumentException
     */
    public List<PaymentMean> getPaymentMean() throws IllegalArgumentException {

        List<PaymentMean> paymentMeans;

        PaymentMeanRepository payMeansRepository = new PaymentMeanRepository();

        //Lista completa dos cartões de debito
        paymentMeans = payMeansRepository.getAllPaymentMean();

        if (paymentMeans == null) {
            throw new IllegalArgumentException();
        }

        return paymentMeans;
    }
     
    public void createExpense(String what, Date date, BigDecimal amount, ExpenseType expType, PaymentMean pM) {
        
        
        // NAO GRAVAR DIRETAMENTE NO REPOSITORY. USAR O RecordExpense. ----------> RecordExpense.Register(Expense) <-----------
        
        
        Expense expense = new Expense(what, date, amount, expType, pM);
        
        ExpenseRepository repo = new ExpenseRepository();
        repo.save(expense);
    }
}
