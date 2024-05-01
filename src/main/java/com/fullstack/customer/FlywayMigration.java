//package com.fullstack.customer;
//
//
//    import org.flywaydb.core.Flyway;
//
//    public class FlywayMigration {
//        public static void main(String[] args) {
//            // Replace url, user, and password with your actual database connection details
//            String url =  "jdbc:postgresql://localhost:5332/customer";
//            String user = "postgres";
//            String password = "postgres";
//
//            // Choose your preferred option and configure Flyway accordingly
//            Flyway flyway = Flyway.configure()
//                    .dataSource(url, user, password)
//                    //.baseline() // Uncomment this line if you want to baseline the existing schema
//                    .baselineOnMigrate(true) // Uncomment this line if you want to set baselineOnMigrate to true
//                    .load();
//
//            // Start the migration process
//            flyway.migrate();
//        }
//    }


