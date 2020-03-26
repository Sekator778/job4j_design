package myio;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InteAdress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        address = InetAddress.getByName("www.job4j.ru");
        System.out.println(address);
        InetAddress[] sw = InetAddress.getAllByName("www.job4j.ru");
        System.out.println(address.isMulticastAddress());
        System.out.println(sw.length);
        for (InetAddress i : sw
             ) {
            System.out.println(i.getHostName());
        }
    }
}
