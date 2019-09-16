package Service;

import model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

    Long numberOfTransaction();

    List<Transaction> findAllTransactions();
}
