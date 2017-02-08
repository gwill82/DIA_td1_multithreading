package com.company;

import java.io.*;
import java.net.Socket;

/**
 * Created by wgata on 08/02/17.
 */
public class Client {

    /** Le processus client se connecte au site fourni dans la commande
     *   d'appel en premier argument et utilise le port distant 8080.
     */
        static final int port = 6969;

        public static void main(String[] args) throws Exception {
            Socket socket;
            socket = new Socket(args[0], port);
            System.out.println("SOCKET = " + socket);

            BufferedReader plec = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter pred = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream())),
                    true);

            String str = "bonjour";
            for (int i = 0; i < 10; i++) {
                pred.println(str);          // envoi d'un message
                str = plec.readLine();      // lecture de l'écho
            }
            System.out.println("END");     // message de terminaison
            pred.println("END") ;
            plec.close();
            pred.close();
            socket.close();
        }
}

