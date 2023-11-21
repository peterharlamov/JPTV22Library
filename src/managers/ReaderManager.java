/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Reader;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ReaderManager {
    
    private final Scanner scanner;
    
    public ReaderManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public Reader addReader() {
        System.out.println("------- Add new Reader --------");
        Reader reader = new Reader();
        System.out.println("Firstname: ");
        reader.setFirstname(scanner.nextLine());
        System.out.println("Lastname: ");
        reader.setLastname(scanner.nextLine());
        System.out.println("Phone: ");
        reader.setPhone(scanner.nextLine());
        System.out.println("Added reader " + reader.toString());
        return reader;
    }

    public int printListReaders(List<Reader> readers) {
        int count = 0;
        System.out.println("List readers: ");
        for (int i = 0; i < readers.size(); i++) {
            System.out.printf("%d. %s. %s. %s%n",
                    i+1,
                    readers.get(i).getFirstname(),
                    readers.get(i).getLastname(),
                    readers.get(i).getPhone()
            );
            count++;
        }
        return count;
    }
}