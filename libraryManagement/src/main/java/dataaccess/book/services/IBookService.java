package esipe.dataaccess.account.services;



import esipe.models.*;

import java.util.List;

public interface IBookService {

	AccountDto getAccountById(String id);

	void updateBalance(String accountid, Operation o);

	List<HistoryDto> getAllOperationsHistory(String id);

	List<HistoryDto> getWeeklyOperationsHistory(String id);



}
