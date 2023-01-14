package com.job;

import com.csv.BuyerRow;

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
//        try {
//            determineBuyerWinner();
//            determineBuyerWinner();
//            determineCashboxWinner();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void determineCashboxWinner() {

    }

//    private void determineBuyerWinner() throws IOException {
//        Files.readAllLines(buyerStatsPath)
//                .stream()
//                .map(line -> line.split(SEPARATOR))
//                .map(BuyerRow::new)
//                .map(comparing(buyerRow -> buyerRow.getOrderNumber orderNumber() * buyerRow.orderPriceAvg()))
//    }


}
