package com.sda.hibernate.association.one_to_one;

import java.time.LocalDate;

public class DemoOneToOne {

    public static void main(String[] args) {
        // create employee
        Employee employee = new Employee();
        employee.setFirstName("jon");
        employee.setLastName("snow");
        employee.setEmail("jonsnow@gmail.com");

        // create account
        Account account = new Account();
        account.setAccountNumber("12");
        account.setEmploymentDate(LocalDate.now());

        // set employee
        account.setEmployee(employee);

        // save
        AccountDao accountDao = new AccountDao();
        accountDao.create(account);
    }
}
