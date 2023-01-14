package com.service;

import com.job.BuyerStatsJob;
import com.job.CashboxStatsJob;
import com.job.WinnerJob;
import com.model.Order;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.util.CafeConst.*;

public class DmdevCafe extends Thread {

    private ScheduledExecutorService executorService;
    private final List<Buyer> buyers;
    private final List<CashBox> cashBoxes;
    private final BlockingQueue<Order> allOrders;

    public DmdevCafe(int buyersNumber, int cashboxesNumber) {
        this.executorService = Executors.newScheduledThreadPool(3);
        this.allOrders = new ArrayBlockingQueue<>(cashboxesNumber*10);
        this.buyers = createBuyers(buyersNumber);
        this.cashBoxes = createCashboxes(cashboxesNumber);
    }

    @Override
    public void run(){
        buyers.forEach(buyer -> new Thread(buyer).start());
        cashBoxes.forEach(cashBox -> new Thread(cashBox).start());

        var buyerStatsPath = Path.of("resources","buyers-stats.csv");
        executorService.scheduleAtFixedRate(new BuyerStatsJob(buyers, buyerStatsPath), BUYER_STATS_JOB_PERIOD,BUYER_STATS_JOB_PERIOD, TimeUnit.SECONDS);

        var cashboxStatsPath = Path.of("resources", "cashboxes-stats.csv");
        executorService.scheduleAtFixedRate(new CashboxStatsJob(cashBoxes, cashboxStatsPath), CASHBOX_STATS_JOB_PERIOD,CASHBOX_STATS_JOB_PERIOD, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(new WinnerJob(buyerStatsPath, cashboxStatsPath), WINNER_JOB_PERIOD,WINNER_JOB_PERIOD, TimeUnit.SECONDS);
    }


    private List<Buyer> createBuyers(int buyersNumber) {
        return IntStream.range(0, buyersNumber)
                .mapToObj(i ->new Buyer(allOrders))
                .collect(Collectors.toList());
    }

    private List<CashBox> createCashboxes(int cashboxesNumber) {
        return IntStream.range(0, cashboxesNumber)
                .mapToObj(i ->new CashBox(allOrders))
                .collect(Collectors.toList());
    }

}
