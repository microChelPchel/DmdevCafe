package com.job;

import com.csv.BuyerRow;
import com.csv.CashboxRow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.csv.CsvRow.SEPARATOR;
import static java.util.Comparator.comparing;

public class WinnerJob implements Runnable {
    private Path buyerStatsPath;
    private Path cashboxStatsPath;

    public WinnerJob(Path buyerStatsPath, Path cashboxStatsPath) {
        this.buyerStatsPath = buyerStatsPath;
        this.cashboxStatsPath = cashboxStatsPath;
    }

    @Override
    public void run() {
        try {
            determineBuyerWinner();
            determineBuyerWinner();
            determineCashboxWinner();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void determineBuyerWinner() throws IOException {
        Files.readAllLines(buyerStatsPath)
                .stream()
                .map(line -> line.split(SEPARATOR))
                .map(BuyerRow::new)
                .max(comparing(buyerRow -> buyerRow.getOrderNumber() * buyerRow.getOrderPriceAvg()))
                .ifPresent(buyerRow -> System.out.println("Buyer winner: "+ buyerRow.getId()));
    }

    private void determineCashboxWinner() throws IOException {
        Files.readAllLines(cashboxStatsPath)
                .stream()
                .map(line -> line.split(SEPARATOR))
                .map(CashboxRow::new)
                .max(comparing(cashboxRow -> cashboxRow.getOrderPriceSum() / cashboxRow.getOrderNumber() ))
                .ifPresent(cashboxRow -> System.out.println("Cashbox winner: "+ cashboxRow.getId()));
    }

}
