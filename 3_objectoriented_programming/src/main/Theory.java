package main;

import java.util.ArrayList;


public class Theory {

    private static class Week2 {

        private static class Car {
            public int Year;
            public String Make, Model, Color;

            Car(int Year, String Make, String Model, String Color) {
                this.Year = Year;
                this.Make = Make;
                this.Model = Model;
                this.Color = Color;
            }
        }

        public static void run() {
            ArrayList<Car> cars = new ArrayList<>();

            cars.add(new Car(2021, "Toyota", "Camry", "Champagne"));
            cars.add(new Car(2020, "Chevrolet", "Camaro", "Sapphire"));
            cars.add(new Car(2019, "Mercedes", "Benz", "Blue Ivy"));
            cars.add(new Car(2018, "Chevrolet", "Caprice", "Yellow"));
            cars.add(new Car(2017, "Hyundai", "Sonata", "Light Pink"));

            cars.forEach(x -> System.out.printf("%s %s | Warna : %s | Tahun : %d%n", x.Make, x.Model, x.Color, x.Year));
        }
    }

    public static void runWeek2() {
        Week2.run();
    }
}
