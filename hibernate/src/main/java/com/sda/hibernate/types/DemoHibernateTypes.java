package com.sda.hibernate.types;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DemoHibernateTypes {

    public static void main(String[] args) {
        PlayerDao dao = new PlayerDao();

        Address address = createAddress();
        Player player = createPlayer(address);

        dao.create(player);
    }

    private static Player createPlayer(Address address) {
        Player player = new Player();
        player.setUsername("jonsnow");
        player.setBirthDate(LocalDate.of(1988, 7, 21));
        player.setRegistrationTime(LocalDateTime.now());
        player.setAge(21);
        player.setStatus(Status.ACTIVE);
        player.setAddress(address);
        return player;
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setAddressLine1("test");
        address.setAddressLine2("test");
        address.setCity("bucharest");
        address.setCounty("bucharest");
        address.setCountry("ro");
        return address;
    }
}
