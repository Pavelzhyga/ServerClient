package ru.dve.serverclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Данный класс реализует серверную часть приложения клиент-сервер.
 *
 * @author Дубинин 15ИТ18
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Добро пожаловать на сервер");
        BufferedReader in;
        PrintWriter out;

        ServerSocket servers = null;
        Socket fromclient = null;

        try {
            servers = new ServerSocket(4444);
        } catch (IOException e) {
            System.out.println("Не удалось прослушать порт 4444");
        }

        try {
            System.out.print("Ожидаем клиента...");
            fromclient = servers.accept();
            System.out.println("Клиент подключился");
        } catch (IOException e) {
            System.out.println("Немогу принять");
        }

        in = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
        out = new PrintWriter(fromclient.getOutputStream(), true);
        String input;

        System.out.println("Ждем сообщения");
        while ((input = in.readLine()) != null) {
            out.println("Сервер ::: " + input);
            System.out.println(input);
        }
        out.close();
        in.close();
        fromclient.close();
        servers.close();
    }
}
