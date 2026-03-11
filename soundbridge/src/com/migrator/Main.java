package com.migrator;

import com.migrator.export.MigrationReport;

public class Main {

    public static void main(String[] args) {

        System.out.println("Generating migration report...");

        MigrationReport.generateReport();

    }
}
