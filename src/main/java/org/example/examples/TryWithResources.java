package org.example.examples;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class TryWithResources {

    public static void main(String[] args) {

        try {
            readFirstLineFromFile("fakepath");
        } catch (IOException e) {
           // log.error("Erreur de lecture du fichier", e);
        }
    }

    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
}
