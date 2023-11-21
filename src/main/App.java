/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.List;
import managers.BookManager;
import managers.ReaderManager;
import java.util.Scanner;
import managers.HistoryManager;
import managers.SaverManager;
import tools.InputFromKeyboard;

/**
 *
 * @author pupil
 */
public class App {
    
    private List<Book> books;
    private List<Reader> readers;
    private List<History> histories;
    private final Scanner scanner;
    private final ReaderManager readerManager;
    private final BookManager bookManager;
    private final HistoryManager historyManager;
    private final SaverManager saverManager;
    
    public App() {
        this.scanner = new Scanner(System.in);
        this.saverManager = new SaverManager();
        this.books = saverManager.loadBooks();
        this.readers = saverManager.loadReaders();
        this.histories = saverManager.loadHistories();
        this.readerManager = new ReaderManager(scanner);
        this.bookManager = new BookManager(scanner);
        this.historyManager = new HistoryManager(scanner);
        
    }
    
    void run() {
        boolean repeat = true;
        System.out.println("------ Harlamov Library ------");
        do
        {
            System.out.println("Select task: ");
            System.out.println("0. Exit");
            System.out.println("1. Add new book");
            System.out.println("2. Add new reader");
            System.out.println("3. Print list books");
            System.out.println("4. Print list readers");
            System.out.println("5. Give book to the reader");
            System.out.println("6. Return book");
            System.out.println("7. Print list giving books");
            System.out.println("8. Ranking of books being read");
            System.out.println("9. Most Reading Reader");
            System.out.println("Task number: ");
            int task = InputFromKeyboard.inputNumberFromRange(0,9);
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    books.add(bookManager.addBook());
                    saverManager.saveBooks(books);
                    break;
                case 2:
                    readers.add(readerManager.addReader());
                    saverManager.saveReaders(readers);
                    break;
                case 3:
                    bookManager.printListBooks(books);
                    break;
                case 4:
                    readerManager.printListReaders(readers);
                    break;
                case 5:
                    History history = historyManager.giveBookToReader(readers, books);
                    if(history != null){
                        this.histories.add(history);
                        saverManager.saveHistories(histories);
                    }
                    break;
                case 6:
                    historyManager.returnBook(histories);
                    saverManager.saveHistories(histories);
                    break;
                case 7:
                    historyManager.printListReadingBooks(histories);
                    break;
                case 8:
                    historyManager.printRankingOfBooksBeingRead(this.histories);
                    break;
                case 9:
                    System.out.println("Implementation expected");
                    break;
                default:
                    System.out.println("Select task from tasks!");
            }
        } while(repeat);
    }
}
