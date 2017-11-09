package esipe.dataaccess.account.controllers;


import esipe.dataaccess.account.services.BookService;

import esipe.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    private final BookService bookService;

    @Autowired
    public AccountController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Operation o) {
        bookService.updateBalance(id,o);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(path = "/{id}/history", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOperationsHistory(@PathVariable String id) {
        List<HistoryDto> historyDtoList = bookService.getAllOperationsHistory(id);

        return (!historyDtoList.isEmpty()) ?
                new ResponseEntity<>(historyDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/{id}/weeklyhistory", method = RequestMethod.GET)
    public ResponseEntity<?> getWeeklyOperationsHistory(@PathVariable String id) {

        List<HistoryDto> weeklyHistoryDtoList = bookService.getWeeklyOperationsHistory(id);

        return (!weeklyHistoryDtoList.isEmpty()) ?
                new ResponseEntity<>(weeklyHistoryDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountById(@PathVariable String id) {
    return new ResponseEntity<>(bookService.getAccountById(id),HttpStatus.OK);
    }

}
