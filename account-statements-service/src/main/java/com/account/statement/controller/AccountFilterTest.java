package com.account.statement.controller;

public class AccountFilterTest {

   /* @Test
    public void testFilter_Accounts_between_dates(){
        Date startDate = getDate("8-Jun-2013");
        Date endDate = getDate("7-Jun-2015");
        Predicate<Account> checkDateBetween = (account) -> {
            Date accountDate = account.getDate();
            return accountDate.getTime() >= startDate.getTime() &&
                    accountDate.getTime() <= endDate.getTime();
        };

        List<Account> filteredAccounts = getAccounts().stream()
                .filter(checkDateBetween)
                .collect(Collectors.toList());
        System.out.println(filteredAccounts);
    }

    private List<Account> getAccounts() {
      return  List.of(
                new Account(111,getDate("7-Jun-2013")),
                new Account(111,getDate("7-Jun-2014")),
                new Account(111,getDate("7-Jun-2015"))
        );

    }

    @SneakyThrows
    private Date getDate(String dtStr){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return formatter.parse(dtStr);
    }*/
}