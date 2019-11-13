package se.lexicon.amin.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {

    @Autowired
    private Scanner scanner;

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        int nextInt = scanner.nextInt();
        scanner.nextLine();
        return nextInt;
    }
}
