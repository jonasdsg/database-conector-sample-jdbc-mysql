package com.github.jonasdsg.app;

import com.github.jonasdsg.app.domain.service.DatabaseService;

public class DatabaseConectorSampleMysql {
    
    public static void main(String[] args) {
        DatabaseService service = DatabaseService.getService();
        service.insert("Dionatan");
        service.list();
    }
}
