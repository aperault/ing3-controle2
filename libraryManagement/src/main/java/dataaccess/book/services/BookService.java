package dataaccess.book.services;

import esipe.dataaccess.history.entities.HistoryEntity;
import esipe.dataaccess.history.repositories.HistoryRepository;
import esipe.dataaccess.utils.Mapper;

import esipe.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements esipe.dataaccess.account.services.IBookService {

    private final esipe.dataaccess.account.repositories.BookRepository bookRepository;
    private final HistoryRepository historyRepository;



    @Autowired
    private Mapper mapper;

    @Autowired
    public BookService(esipe.dataaccess.account.repositories.BookRepository bookRepository, HistoryRepository historyRepository) {


        this.bookRepository = bookRepository;
        this.historyRepository = historyRepository;
    }


    @Override
    public AccountDto getBookById(String id) {
        return mapper.BooEntityToDto(bookRepository.findOne(Long.parseLong(id)));
    }

    @Override
    public void updateBalance(String accountid, Operation o) {

        List<HistoryDto> weeklyHistory =getWeeklyOperationsHistory(accountid);
        int sum =0;
        for(HistoryDto h : weeklyHistory){
            if(h.getOperation().getAmount() < 0)
                sum += h.getOperation().getAmount();
        }

        if(sum > Math.abs(800) || o.getAmount() < -800)
            throw new GenericException("Plafond de 800€ dépassé");
        else {


            esipe.dataaccess.account.entities.BookEntity bookEntity = bookRepository.findOne(Long.parseLong(accountid));
            bookEntity.setId(Long.parseLong(accountid));
            bookEntity.setBalance(o.getAmount() + bookEntity.getBalance());

            HistoryEntity historyEntity = new HistoryEntity();
            historyEntity.setAmount(o.getAmount());
            historyEntity.setAccount(bookEntity);


            bookRepository.save(bookEntity);
            historyRepository.save(historyEntity);

        }

    }

    @Override
    public List<HistoryDto> getAllOperationsHistory(String id){
        List<HistoryDto> historyDtoList = mapper.historyEntitiesToHistoryDtoList(historyRepository.getAllByAccount(bookRepository.findOne(Long.parseLong(id))));

        return historyDtoList ;

    }

    @Override
    public List<HistoryDto> getWeeklyOperationsHistory(String id) {

        List<HistoryDto> historyDtoList = getAllOperationsHistory(id);
        List<HistoryDto> weeklyHistory = new ArrayList<HistoryDto>();
        historyDtoList.forEach(historyDto -> {
                    if (historyDto.getDate().isBefore( LocalDate.now()) && historyDto.getDate().isAfter(LocalDate.now().minusWeeks(1))){
                        weeklyHistory.add(historyDto);
                    }
                }

        );
        return (weeklyHistory);

    }


    }



