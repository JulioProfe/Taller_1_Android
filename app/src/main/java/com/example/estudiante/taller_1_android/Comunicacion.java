package com.example.estudiante.taller_1_android;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Observable;

/**
 * Created by estudiante on 02/03/17.
 */

public class Comunicacion extends Observable implements Runnable {

    private static Comunicacion ref;
    public static final String Adefault = "10.0.2.2";
    public static int Puerto = 5000;
    public DatagramSocket ds;

    private Comunicacion(){
        try {
            ds = new DatagramSocket();
        } catch (SocketException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){

        }
    }

    public static Comunicacion getInstance(){
        if (ref == null){
            ref = new Comunicacion();
            new Thread(ref).start();
        }
        return ref;
    }


    public void enviar(final byte[] mensaje) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (ds != null) {
                    try {
                        InetAddress ip = null;
                        ip = InetAddress.getByName("192.168.108.27");
                        DatagramPacket enviado = new DatagramPacket(mensaje, mensaje.length, ip, Puerto);
                        ds.send(enviado);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}