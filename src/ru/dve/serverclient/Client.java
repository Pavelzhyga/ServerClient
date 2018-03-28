package ru.dve.serverclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Данный класс реализует клиентскую часть приложения клиент-сервер.
 * @author Дубинин 15ИТ18
 */
public class Client {
    public static void main(String[] args) throws IOException {

        System.out.println("Добро пожаловать клиент");

        Socket fromserver;
        fromserver = new Socket("localhost", 4444);
        BufferedReader in = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
        PrintWriter out = new PrintWriter(fromserver.getOutputStream(), true);
        BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

        String fuser, fserver;

        while ((fuser = inu.readLine()) != null) {
            out.println(fuser);
            fserver = in.readLine();
            System.out.println(fserver);
            if (fuser.equalsIgnoreCase("close")) break;
            if (fuser.equalsIgnoreCase("exit")) break;
            if (fuser.equalsIgnoreCase("выход")) break;
        }
        out.close();
        in.close();
        inu.close();
        fromserver.close();
    }
}
