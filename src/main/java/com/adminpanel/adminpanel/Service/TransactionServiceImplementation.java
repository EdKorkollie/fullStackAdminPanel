package Service;

import Repository.TransactionRepository;
import model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImplementation implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(final Transaction transaction) {
        return transactionRepository.save(transaction);

    }

    @Override
    public Long numberOfTransaction() {
        return transactionRepository.count();
    }

    @Override
    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }
}
