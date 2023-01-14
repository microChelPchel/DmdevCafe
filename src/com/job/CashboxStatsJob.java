package com.job;

import com.csv.CsvRow;
import com.mapper.CashboxMapper;
import com.service.CashBox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class CashboxStatsJob implements Runnable {

    private final CashboxMapper cashboxMapper = new CashboxMapper();
    private final List<CashBox> cashboxes;
    private final Path cashboxStatsPath;

    public CashboxStatsJob(List<CashBox> cashBoxes, Path cashboxStatsPath) {
        this.cashboxStatsPath = cashboxStatsPath;
        this.cashboxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
            var csvRow = cashboxes.stream()
                    .map(cashboxMapper::map)
                    .map(CsvRow::toCsvRow)
                    .collect(Collectors.toList());

            Files.write(cashboxStatsPath, csvRow, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
