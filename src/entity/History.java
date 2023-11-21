/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author pupil
 */
public class History implements Serializable {
    private Book book;
    private Reader reader;
    private Date giveBookToReader;
    private Date returnBook;
    
    public History() {}

    public History(Book book, Reader reader, Date giveBookToReaderDate, Date returnBook) {
        this.book = book;
        this.reader = reader;
        this.giveBookToReader = giveBookToReader;
        this.returnBook = returnBook;
    }

    public Date getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(Date returnBook) {
        this.returnBook = returnBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getGiveBookToReaderDate() {
        return giveBookToReader;
    }

    public void setGiveBookToReaderDate(Date giveBookToReaderDate) {
        this.giveBookToReader = giveBookToReaderDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.book);
        hash = 13 * hash + Objects.hashCode(this.reader);
        hash = 13 * hash + Objects.hashCode(this.giveBookToReader);
        hash = 13 * hash + Objects.hashCode(this.returnBook);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final History other = (History) obj;
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        if (!Objects.equals(this.giveBookToReader, other.giveBookToReader)) {
            return false;
        }
        if (!Objects.equals(this.returnBook, other.returnBook)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "History{" 
                + "book=" + book 
                + ", reader=" + reader 
                + ", giveBookToReaderDate=" + giveBookToReader 
                + ", returnBook=" + returnBook + '}';
    }
}
