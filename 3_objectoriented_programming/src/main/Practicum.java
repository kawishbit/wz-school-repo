package main;

import ext.Pegawai;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.NumberFormat;
import java.util.stream.Collectors;

public class Practicum {

    private static class Week2 {
        private static class Mahasiswa {
            public String id, name, major;
            public int semester, score1, score2, score3;


            void print() {
                double finalScore = this.calculateScore();
                System.out.printf("Id :%s%nName : %s%nMajor : %s%nSemester : %d%nAverage Score : %.2f%n", this.id, this.name, this.major, this.semester, finalScore);
            }

            double calculateScore() {
                return (score1 + score2 + score3) / 3d;
            }
        }

        public static void run() {
            Mahasiswa user = new Mahasiswa() {
                {
                    id = "200401075";
                    name = "Kawish Behzad Mazhar";
                    major = "Teknik Informatika";
                    semester = 3;
                    score1 = 75;
                    score2 = 50;
                    score3 = 95;
                }
            };
            user.print();
        }
    }

    private static class Week2AssignmentOne {
        private static class MobilePhone {
            String companyName, modelName, color, storage;

            MobilePhone(String companyName, String modelName, String color, String storage) {
                this.companyName = companyName;
                this.modelName = modelName;
                this.color = color;
                this.storage = storage;
            }

            void displayData() {
                System.out.println("============================================");
                System.out.printf("Company Name : %s %n", this.companyName);
                System.out.printf("Model Name : %s %n", this.modelName);
                System.out.printf("Color : %s %n", this.color);
                System.out.printf("Storage : %s %n", this.storage);
                System.out.println("============================================");
            }

        }

        public static void run() {
            MobilePhone nokia = new MobilePhone("Nokia", "3310", "Black", "100MB");
            nokia.displayData();
            MobilePhone iPhone = new MobilePhone("Apple", "iPhone 11", "Gray", "128GB");
            iPhone.displayData();
            MobilePhone samsung = new MobilePhone("Samsung", "Galaxy S22", "Black", "1TB");
            samsung.displayData();

        }
    }

    private static class Week3 {

        private static class Employee {
            public String name, position;
            public int age;
            public double salary;

            Employee(String name, String position, int age, double salary) {
                this.name = name;
                this.age = age;
                this.position = position;
                this.salary = salary;
            }
        }

        private static class EmployeeGroup {
            private final ArrayList<Employee> employees = new ArrayList<>();
            private final double tax = 10;

            public void addEmployee(Employee employee) {
                this.employees.add(employee);
            }

            public double calculateOutcome() {
                double sum = 0;
                for (Employee employee : this.employees) {
                    sum += employee.salary;
                }

                return sum + (sum * this.tax / 100);
            }

            public void printEmployeeData() {
                System.out.println("====== EMPLOYEE LIST ======");
                for (Employee employee : this.employees) {
                    double salaryTax = employee.salary - (employee.salary * this.tax / 100);
                    System.out.println("-------------------------------------");
                    System.out.printf("Name : %s%nPosition : %s%nAge : %d%nSalary : %.2f%nAfter Tax : %.2f%n", employee.name, employee.position, employee.age, employee.salary, salaryTax);
                }
                System.out.println("-------------------------------------");
                System.out.println("=========================");
                System.out.printf("Total Outcome : %.2f%n", this.calculateOutcome());
                System.out.println("=========================");

            }
        }

        public static void run() {
            EmployeeGroup group = new EmployeeGroup();
            group.addEmployee(new Employee("Kawish Behzad Mazhar", "Fullstack Developer", 23, 2000));
            group.addEmployee(new Employee("Steven Smith", "Web Developer", 21, 2000));
            group.addEmployee(new Employee("Noam Chomsky", "UX Designer", 21, 1500));

            group.printEmployeeData();
        }
    }

    private static class Week4 {
        private static class Mahasiswa {
            String nim, nama, jurusan;
            int semester, abs, tgs, uts, uas;
            double na;

            Mahasiswa() {
                System.out.println("Ini adalah constructor default");
            }

            Mahasiswa(String nim, String nama, String jurusan, int semester) {
                this.nim = nim;
                this.nama = nama;
                this.jurusan = jurusan;
                this.semester = semester;
                System.out.printf("NIM Mahasiswa : %s%n", this.nim);
                System.out.printf("Nama Mahasiswa : %s%n", this.nama);
                System.out.printf("Jurusan Mahasiswa : %s%n", this.jurusan);
            }

            Mahasiswa(int abs, int tgs, int uts, int uas) {
                this.abs = abs;
                this.tgs = tgs;
                this.uts = uts;
                this.uas = uas;
                this.na = (abs + tgs + uts + uas) / 4d;
                System.out.printf("Nilai absen : %d%n", this.abs);
                System.out.printf("Nilai tugas : %d%n", this.tgs);
                System.out.printf("Nilai UTS : %d%n", this.uts);
                System.out.printf("Nilai UAS : %d%n", this.uas);
                System.out.printf("Nilai Akhir : %.2f%n", this.na);
            }
        }

        public static void run() {
            Mahasiswa mahasiswa1 = new Mahasiswa();
            Mahasiswa mahasiswa2 = new Mahasiswa("200401075", "Kawish Behzad Mazhar", "Teknik Informatika", 3);
            Mahasiswa mahasiswa3 = new Mahasiswa(90, 96, 92, 96);
        }
    }

    private static class Week4Assignment {
        private static class Employee {
            final Locale indonesia = new Locale("in", "ID");
            final NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesia);
            String nip, nama, divisi;
            double gapok, uMakan, uTransport, total;
            final int durasi = 24;

            Employee() {
                System.out.println("Pemrosesan data karyawan dimulai.");
            }

            Employee(String nip, String nama, String divisi) {
                this.nip = nip;
                this.nama = nama;
                this.divisi = divisi;
            }

            void setFinance(double gapok, double uMakan, double uTransport) {
                this.gapok = gapok;
                this.uMakan = uMakan;
                this.uTransport = uTransport;
            }

            void printData() {

                System.out.printf("NIP Pegawai : %s%n", this.nip);
                System.out.printf("Nama Pegawai : %s%n", this.nama);
                System.out.printf("Divisi Pegawai : %s%n", this.divisi);
                System.out.printf("Gaji Pokok : %s%n", rupiahFormat.format(this.gapok));
                System.out.printf("Uang Makan : %s%n", rupiahFormat.format(this.uMakan));
                System.out.printf("Uang Transport : %s%n", rupiahFormat.format(this.uTransport));
            }

            void calculateTotal() {
                this.total = this.gapok + (this.durasi * this.uMakan) + (this.durasi * uTransport);
                System.out.printf("Total : %s", rupiahFormat.format(this.total));
            }


        }

        public static void run() {
            Employee employee = new Employee("200401075", "Kawish Behzad Mazhar", "Finance");
            employee.setFinance(1000000, 30000, 40000);
            employee.printData();
            employee.calculateTotal();
        }
    }

    private static class Week5 {
        private static class Nilai {
            int nilaiAbsen, semester;
            String nim, nama, jurusan;
            double nilaiTugas, nilaiAkhir;

            void nilai() {
                System.out.printf("NIM Mahasiswa : %s%n", this.nim);
                System.out.printf("Nama Mahasiswa : %s%n", this.nama);
                System.out.printf("Jurusan Mahasiswa : %s%n", this.jurusan);
                System.out.printf("Semester: %d%n", this.semester);
            }

            void nilai(int nilai1, int nilai2, int nilai3) {
                this.nilaiTugas = (nilai1 + nilai2 + nilai3) / 3d;
                System.out.printf("Nilai Tugas: %.2f%n", this.nilaiTugas);
            }

            void nilai(int nilaiAbsen) {
                this.nilaiAbsen = nilaiAbsen;
                System.out.printf("Nilai Absen: %d%n", this.nilaiAbsen);

            }

            void nilai(int nilaiUts, int nilaiUas) {
                nilaiAkhir = nilaiUts * 0.30d + nilaiUas * 0.40d + this.nilaiTugas * 0.40d + nilaiAbsen * 0.15d;
                System.out.printf("Nilai Akhir: %.2f%n", this.nilaiTugas);

            }
        }

        public static void run() {
            Nilai testInstance = new Nilai() {
                {
                    nim = "200401075";
                    nama = "Kawish Behzad Mazhar";
                    jurusan = "Teknik Informatika";
                    semester = 3;
                    nilaiAbsen = 100;
                    nilaiTugas = 90;
                    nilaiAkhir = 100;
                }
            };
            testInstance.nilai();
            testInstance.nilai(90, 95, 97);
            testInstance.nilai(100);
            testInstance.nilai(97, 97);


        }

    }

    private static class Week5Assignment {
        private static class Employee {
            final Locale indonesia = new Locale("in", "ID");
            final NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesia);
            String nip, nama, divisi;
            double gapok, uMakan, uTransport, total;
            final int durasi = 24;

            void employee(String nip, String nama, String divisi) {
                this.nip = nip;
                this.nama = nama;
                this.divisi = divisi;
                System.out.printf("NIP Pegawai : %s%n", this.nip);
                System.out.printf("Nama Pegawai : %s%n", this.nama);
                System.out.printf("Divisi Pegawai : %s%n", this.divisi);
            }

            void employee(double gapok, double uMakan, double uTransport) {
                this.gapok = gapok;
                this.uMakan = uMakan;
                this.uTransport = uTransport;
                this.total = this.gapok + (this.durasi * this.uMakan) + (this.durasi * uTransport);
                System.out.printf("Gaji Pokok : %s%n", rupiahFormat.format(this.gapok));
                System.out.printf("Uang Makan : %s%n", rupiahFormat.format(this.uMakan));
                System.out.printf("Uang Transport : %s%n", rupiahFormat.format(this.uTransport));
                System.out.printf("Total : %s", rupiahFormat.format(this.total));
            }


        }

        public static void run() {
            Employee employee = new Employee();
            employee.employee("200401075", "Kawish Behzad Mazhar", "Divisi 2");
            employee.employee(1000000, 30000, 40000);
        }
    }

    private static class Week6 {
        private static class Employee {
            String nip, nama, divisi;
            static final Locale indonesia = new Locale("in", "ID");
            static final NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesia);
            static final int durasi = 24;

            void setData(String nip, String nama, String divisi) {
                this.nip = nip;
                this.nama = nama;
                this.divisi = divisi;
                System.out.printf("NIP Pegawai : %s%n", this.nip);
                System.out.printf("Nama Pegawai : %s%n", this.nama);
                System.out.printf("Divisi Pegawai : %s%n", this.divisi);
            }

            static void financialReport(double gapok, double uMakan, double uTransport) {
                double total = gapok + (durasi * uMakan) + (durasi * uTransport);
                System.out.printf("Gaji Pokok : %s%n", rupiahFormat.format(gapok));
                System.out.printf("Uang Makan : %s%n", rupiahFormat.format(uMakan));
                System.out.printf("Uang Transport : %s%n", rupiahFormat.format(uTransport));
                System.out.printf("Total : %s", rupiahFormat.format(total));
            }
        }

        public static void run() {
            Employee employee = new Employee();
            employee.setData("200401075", "Kawish Behzad Mazhar", "Divisi 2");
            Employee.financialReport(1000000, 30000, 40000);
        }
    }


    private static class Week7SingleInheritance {
        private static class Jurusan {
            String namaJurusan, namaFakultas, kodeJurusan;
            Year tahun;

            Jurusan(String namaJurusan, String kodeJurusan) {
                this.namaJurusan = namaJurusan;
                this.kodeJurusan = kodeJurusan;
            }

            void setYear(Year tahun) {
                this.tahun = tahun;
            }

            void setFakultas(String namaFakultas) {
                this.namaFakultas = namaFakultas;
            }
        }

        private static class MataKuliah extends Jurusan {
            String namaMk, kodeMk, hariMk, namaDosen;
            LocalTime startTime, endTime;
            int nilaiSks;
            static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            MataKuliah(String namaJurusan, String kodeJurusan, String namaMk, String kodeMk) {
                super(namaJurusan, kodeJurusan);

                this.namaMk = namaMk;
                this.kodeMk = kodeMk;
            }

            void setAdditionalInfo(int nilaiSks, String hariMk, String namaDosen) {

                this.nilaiSks = nilaiSks;
                this.hariMk = hariMk;
                this.namaDosen = namaDosen;
            }

            void setJadwal(LocalTime startTime, LocalTime endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }

            void printData() {
                System.out.printf("Nama Fakultas : %s%n", this.namaFakultas);
                System.out.printf("Nama Jurusan : %s%n", this.namaJurusan);
                System.out.printf("Kode Jurusan : %s%n", this.kodeJurusan);
                System.out.printf("Tahun : %s%n", this.tahun.toString());
                System.out.printf("Nama Matakuliah : %s%n", this.namaMk);
                System.out.printf("Kode Matakuliah : %s%n", this.kodeMk);
                System.out.printf("Hari : %s%n", this.hariMk);
                System.out.printf("Jam Mulai : %s%n", this.startTime.format(formatter));
                System.out.printf("Jam Akhir : %s%n", this.endTime.format(formatter));
                System.out.printf("SKS : %d%n", this.nilaiSks);
                System.out.printf("Dosen : %s%n", this.namaDosen);
            }
        }

        public static void run() {
            MataKuliah matkul = new MataKuliah("Teknik Informatika", "TIK", "Pemrograman Berorientasi Objek", "PBO");
            matkul.setYear(Year.now());
            matkul.setFakultas("Ilmu Komputer");
            matkul.setAdditionalInfo(3, "Rabu", "Darmanta Sukrianto, M.Kom");
            matkul.setJadwal(LocalTime.of(20, 35), LocalTime.of(22, 0));
            matkul.printData();
        }
    }

    private static class Week7MultipleInheritance {

        private static class Mahasiswa {
            String nim, nama, jurusan;
            int semester;


            void setMahasiswa(String nim, String nama, String jurusan, int semester) {
                this.nim = nim;
                this.nama = nama;
                this.jurusan = jurusan;
                this.semester = semester;
            }

            void printData() {

                System.out.printf("NIM Mahasiswa : %s%n", this.nim);
                System.out.printf("Nama Mahasiswa : %s%n", this.nama);
                System.out.printf("Jurusan Mahasiswa : %s%n", this.jurusan);
                System.out.printf("Semester : %d%n", this.semester);
            }

        }

        private static class AsistenDosen extends Mahasiswa {
            String namaDosen, namaMk;
            double gaji;
            LocalTime startTime, endTime;
            static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            AsistenDosen(String namaDosen, String namaMk) {
                super();
                this.namaDosen = namaDosen;
                this.namaMk = namaMk;
            }

            void setGaji(double gaji) {
                this.gaji = gaji;
            }

            void setJadwal(LocalTime startTime, LocalTime endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }

            void printData() {
                super.printData();
                System.out.printf("Dosen : %s%n", this.namaDosen);
                System.out.printf("Nama Matakuliah : %s%n", this.namaMk);
                System.out.printf("Gaji : %.2f%n", this.gaji);
                System.out.printf("Jam Mulai : %s%n", this.startTime.format(formatter));
                System.out.printf("Jam Akhir : %s%n", this.endTime.format(formatter));
            }

        }

        private static class VerifikasiMataKuliah extends Mahasiswa {
            String namaMk, kodeMk;
            LocalDateTime waktuVerifikasi;
            static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            String komentar;

            VerifikasiMataKuliah(String namaMk, String kodeMk) {
                super();
                this.namaMk = namaMk;
                this.kodeMk = kodeMk;
            }

            void verifikasi(String komentar) {
                this.komentar = komentar;
                this.waktuVerifikasi = LocalDateTime.now();
            }

            void printData() {
                super.printData();
                System.out.printf("Nama Matakuliah : %s%n", this.namaMk);
                System.out.printf("Kode Matakuliah  : %s%n", this.kodeMk);
                System.out.printf("Komentar : %s%n", this.komentar);
                System.out.printf("Waktu Verifikasi : %s%n", this.waktuVerifikasi.format(formatter));
            }
        }

        public static void run() {
            System.out.println("=============== ASISTEN DOSEN ==============");
            AsistenDosen asdos = new AsistenDosen("Darmanta Sukrianto, M.Kom", "Pemrograman Berorientasi Objek");
            asdos.setMahasiswa("200401075", "Kawish Behzad Mazhar", "Teknik Informatika", 3);
            asdos.setGaji(10000000);
            asdos.setJadwal(LocalTime.of(20, 35), LocalTime.of(22, 0));
            asdos.printData();
            System.out.println("=============== VERIFIKASI MATKUL ==============");
            VerifikasiMataKuliah verif = new VerifikasiMataKuliah("Pemrograman Berorientasi Objek", "PBO");
            verif.setMahasiswa("200401075", "Kawish Behzad Mazhar", "Teknik Informatika", 3);
            verif.verifikasi("Pembelajaran sesuai dengan modul");
            verif.printData();
        }
    }

    private static class Week7HierarchicalInheritance {
        private static class Jurusan {
            String namaJurusan, namaFakultas, kodeJurusan;
            Year tahun;

            Jurusan(String namaJurusan, String kodeJurusan) {
                this.namaJurusan = namaJurusan;
                this.kodeJurusan = kodeJurusan;
            }

            void setYear(Year tahun) {
                this.tahun = tahun;
            }

            void setFakultas(String namaFakultas) {
                this.namaFakultas = namaFakultas;
            }

            void printData() {
                System.out.printf("Nama Fakultas : %s%n", this.namaFakultas);
                System.out.printf("Nama Jurusan : %s%n", this.namaJurusan);
                System.out.printf("Kode Jurusan : %s%n", this.kodeJurusan);
                System.out.printf("Tahun : %s%n", this.tahun.toString());
            }
        }

        private static class MataKuliah extends Jurusan {
            String namaMk, kodeMk, hariMk, namaDosen;
            LocalTime startTime, endTime;
            int nilaiSks;
            static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            MataKuliah(String namaJurusan, String kodeJurusan, String namaMk, String kodeMk) {
                super(namaJurusan, kodeJurusan);

                this.namaMk = namaMk;
                this.kodeMk = kodeMk;
            }

            void setAdditionalInfo(int nilaiSks, String hariMk, String namaDosen) {

                this.nilaiSks = nilaiSks;
                this.hariMk = hariMk;
                this.namaDosen = namaDosen;
            }

            void setJadwal(LocalTime startTime, LocalTime endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }

            void printData() {
                super.printData();

                System.out.printf("Kode Matakuliah : %s%n", this.kodeMk);
                System.out.printf("Nama Matakuliah : %s%n", this.namaMk);
                System.out.printf("Jam Mulai : %s%n", this.startTime.format(formatter));
                System.out.printf("Jam Akhir : %s%n", this.endTime.format(formatter));
                System.out.printf("Hari : %s%n", this.hariMk);
                System.out.printf("SKS : %d%n", this.nilaiSks);
                System.out.printf("Dosen : %s%n", this.namaDosen);
            }
        }

        private static class Mahasiswa extends MataKuliah {
            String nim, nama;
            int semester;

            Mahasiswa(String namaJurusan, String kodeJurusan, String namaMk, String kodeMk, String nama, String nim, int semester) {
                super(namaJurusan, kodeJurusan, namaMk, kodeMk);

                this.nama = nama;
                this.nim = nim;
                this.semester = semester;
            }

            void printData() {
                super.printData();
                System.out.printf("NIM Mahasiswa : %s%n", this.nim);
                System.out.printf("Nama Mahasiswa : %s%n", this.nama);
                System.out.printf("Semester : %d%n", this.semester);
            }

        }

        public static void run() {
            Mahasiswa mahasiswa = new Mahasiswa("Teknik Informatika", "TIK", "Pemrograman Berorientasi Objek", "PBO", "Kawish Behzad Mazhar", "200401075", 3);
            mahasiswa.setYear(Year.now());
            mahasiswa.setFakultas("Ilmu Komputer");
            mahasiswa.setAdditionalInfo(3, "Rabu", "Darmanta Sukrianto, M.Kom");
            mahasiswa.setJadwal(LocalTime.of(20, 35), LocalTime.of(22, 0));
            mahasiswa.printData();
        }
    }


    private static class Week8 {
        private static class Dosen {
            String nama, nik, jurusan;

            void Dosen(String nama, String nik, String jurusan) {
                this.nama = nama;
                this.nik = nik;
                this.jurusan = jurusan;
            }

            void view() {
                System.out.println("Nama = " + nama);
                System.out.println("Nik = " + nik);
                System.out.println("Jurusan = " + jurusan);
            }
        }

        private static class Rektor extends Dosen {
            int th_mulai, jabatan_ke;

            Rektor(String nama, String nik, String jurusan, int th_mulai, int jabatan_ke) {
                this.nama = nama;
                this.nik = nik;
                this.jurusan = jurusan;
                this.th_mulai = th_mulai;
                this.jabatan_ke = jabatan_ke;
            }


            @Override
            public void view() {
                System.out.println("Nama = " + nama);
                System.out.println("Nik = " + nik);
                System.out.println("Jurusan = " + jurusan);
                System.out.println("Tahun Mulai Jabatan = " + th_mulai);
                System.out.println("Jabatan Rektor ke = " + jabatan_ke);
            }
        }

        private static class Dekan extends Dosen {
            String fakultas;

            Dekan(String nama, String nik, String jurusan, String fakultas) {
                this.nama = nama;
                this.nik = nik;
                this.jurusan = jurusan;
                this.fakultas = fakultas;
            }

            @Override
            void view() {
                System.out.println("Nama = " + nama);
                System.out.println("Nik = " + nik);
                System.out.println("Jurusan = " + jurusan);
                System.out.println("Fakultas = " + fakultas);
            }
        }


        private static class Kelab extends Dosen {
            String laboratorium;

            Kelab(String nama, String nik, String jurusan,String laboratorium) {
                this.nama = nama;
                this.nik = nik;
                this.jurusan = jurusan;
                this.laboratorium = laboratorium;
            }

            @Override
            void view() {
                System.out.println("Nama = " + nama);
                System.out.println("Nik = " + nik);
                System.out.println("Jurusan = " + jurusan);
                System.out.println("Laboratorium = " + laboratorium);
            }
        }

        public static void run() {
            Rektor rektor = new Rektor("Kawish", "200401075", "TI", 2000, 3);
            Dekan dekan = new Dekan("Kawish", "200401075", "TI","Ilmu Komputer");
            Kelab kelab = new Kelab("Kawish", "200401075", "TI","Lab 2");

            rektor.view();
            System.out.println("=================================");
            dekan.view();
            System.out.println("=================================");
            kelab.view();
        }
    }

    private static class Week9Experiment {
        private static abstract class Nilai {
            abstract void viewData();

            abstract void nilaiAkhir();
        }

        private static class DataMahasiswa extends Nilai {
            String nim, nama, jurusan;
            int nab, nt, nuts, nuas, na;

            @Override
            void viewData() {
                System.out.printf("NIM Mahasiswa : %s%n", this.nim);
                System.out.printf("Nama Mahasiswa : %s%n", this.nama);
                System.out.printf("Jurusan Mahasiswa : %s%n", this.jurusan);
                System.out.println("==================================");
            }

            @Override
            void nilaiAkhir() {
                System.out.printf("Nilai Absen : %d%n", this.nab);
                System.out.printf("Nilai Tugas : %d%n", this.nt);
                System.out.printf("Nilai UTS : %d%n", this.nuts);
                System.out.printf("Nilai UAS : %d%n", this.nuas);
                System.out.println("==================================");
                this.na = (int) ((nab * 0.1) + (nt * 0.20) + (nuts * 0.30) + (nuas * 0.40));
                System.out.printf("Nilai Akhir : %s%n", this.na);
            }


        }

        public static void run() {

            DataMahasiswa siswa = new DataMahasiswa();
            siswa.nim = "200401075";
            siswa.nama = "Kawish Behzad Mazhar";
            siswa.jurusan = "TI";
            siswa.nab = 80;
            siswa.nt = 80;
            siswa.nuts = 80;
            siswa.nuas = 80;
            siswa.viewData();
            siswa.nilaiAkhir();
        }
    }


    private static class Week9Assignment {
        private static abstract class Employee {
            String name, id, position;
            double monthlySalary, raiseRate;

            abstract double countRaiseByYear(Year year);

            abstract void showDetail();
        }

        private static abstract class Sector {
            String sectorName;
            Employee sectorLeader;
            Employee[] sectorMembers;
            Building sectorBuilding;

            abstract void showDetail();

            abstract Employee[] showMembers();
        }

        private static abstract class Building {
            final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            String buildingName;
            LocalDate lastInspectionDate;
            final int ptoExpiry = 2;
            Boolean status;

            abstract void showStatus();

            abstract void showDetail();

            abstract LocalDate showNextInspection();
        }

        private static class CompSciEmployee extends Employee {

            CompSciEmployee(String name, String id, String position, double monthlySalary, double raiseRate) {
                this.name = name;
                this.id = id;
                this.position = position;
                this.monthlySalary = monthlySalary;
                this.raiseRate = raiseRate;
            }

            @Override
            public double countRaiseByYear(Year year) {
                int range = year.compareTo(Year.now());
                if (range < 0) {
                    return 0;
                }

                double raise = this.monthlySalary * this.raiseRate;
                if (range == 0) {
                    return raise;
                }


                return raise * range;
            }

            @Override
            void showDetail() {
                System.out.printf("Name : %s%n", this.name);
                System.out.printf("ID : %s%n", this.id);
                System.out.printf("Position : %s%n", this.position);
                System.out.printf("Monthly Salary : %.2f%n", this.monthlySalary);
                System.out.printf("Raise Rate : %.2f%n", this.raiseRate);
            }
        }

        private static class SciDepartmentSector extends Sector {

            SciDepartmentSector(String sectorName, Employee sectorLeader, Employee[] sectorMembers, Building sectorBuilding) {
                this.sectorName = sectorName;
                this.sectorLeader = sectorLeader;
                this.sectorMembers = sectorMembers;
                this.sectorBuilding = sectorBuilding;
            }

            @Override
            void showDetail() {
                System.out.printf("Sector Name : %s%n", this.sectorName);
                System.out.println("======= Building ======= ");
                this.sectorBuilding.showDetail();
                System.out.println("======= Sector Leader ======= ");
                this.sectorLeader.showDetail();


                for (int i = 0; i < this.sectorMembers.length; i++) {
                    System.out.printf("======= Member %d ======= %n", i);
                    this.sectorMembers[i].showDetail();
                }

            }

            @Override
            Employee[] showMembers() {
                return this.sectorMembers;
            }
        }

        private static class NetworkInfraBuilding extends Building {

            NetworkInfraBuilding(String buildingName, Boolean status, LocalDate lastInspectionDate) {
                this.buildingName = buildingName;
                this.status = status;
                this.lastInspectionDate = lastInspectionDate;
            }

            @Override
            void showStatus() {
                if (!this.status) System.out.println("Building is not ready for operation");

                System.out.println("Building is ready for operation");
            }

            @Override
            void showDetail() {
                System.out.printf("Building Name : %s%n", this.buildingName);
                System.out.printf("Building Status : %s%n", this.status ? "Ready" : "Not Ready");
                System.out.printf("Last Inspection : %s%n", this.lastInspectionDate.format(this.formatter));
            }

            @Override
            LocalDate showNextInspection() {
                return this.lastInspectionDate.plusYears(this.ptoExpiry);
            }
        }

        public static void run() {
            CompSciEmployee emp1 = new CompSciEmployee("Kawish Behzad Mazhar", "1", "Software Engineer", 1800, 0.3);
            CompSciEmployee emp2 = new CompSciEmployee("M Ibnu", "2", "Software Engineer", 1800, 0.3);

            NetworkInfraBuilding building = new NetworkInfraBuilding("Building 1", true, LocalDate.now());

            SciDepartmentSector sector = new SciDepartmentSector("Sector 1", emp1, new CompSciEmployee[]{emp1, emp2}, building);

            emp1.showDetail();
            System.out.println("=====================================");
            emp2.showDetail();
            System.out.println("=====================================");
            building.showDetail();
            System.out.println("=====================================");
            sector.showDetail();
            System.out.println("=====================================");
        }
    }

    private static class Week10Experiment {
        private static class Jadwal {
            private String kodeMatkul;
            private String namaMatkul;
            protected String semester;

            public void jadwal(String kodeMatkul, String namaMatkul) {
                this.kodeMatkul = kodeMatkul;
                this.namaMatkul = namaMatkul;
                System.out.println("Kode Matakuliah = " + kodeMatkul);
                System.out.println("Nama Matakuliah = " + namaMatkul);
            }

        }

        private static class Dosen extends Jadwal {
            String nidn, namaDosen;

            void display(String nidn, String namaDosen) {
                this.nidn = nidn;
                this.namaDosen = namaDosen;
                System.out.println("NIDN = " + this.nidn);
                System.out.println("Nama Dosen = " + this.namaDosen);
            }
        }

        private static class Mahasiswa extends Jadwal {
            String nim, namaMahasiswa, jurusan;

            void display() {
                System.out.println("NIM = " + this.nim);
                System.out.println("Nama Mahasiswa = " + this.namaMahasiswa);
                System.out.println("Semester = " + this.semester);
            }
        }

        public static void run() {
            Dosen dosen = new Dosen();
            dosen.jadwal("1111", "PBO");
            dosen.display("123123123", "Darmanto");

            Mahasiswa mahasiswa1 = new Mahasiswa();
            mahasiswa1.nim = "11111111";
            mahasiswa1.namaMahasiswa = "Kawish";
            mahasiswa1.semester = "3";
            mahasiswa1.display();

            Mahasiswa mahasiswa2 = new Mahasiswa();
            mahasiswa2.nim = "11111112";
            mahasiswa2.namaMahasiswa = "John";
            mahasiswa2.semester = "3";
            mahasiswa2.display();

        }
    }

    private static class Week10Assignment {
        private static class Direktur extends Pegawai {
            private final ArrayList<Pegawai> bawahan = new ArrayList<>();
            private final ArrayList<String> agenda = new ArrayList<>();
            private final ArrayList<String> notes = new ArrayList<>();

            public void tambahBawahan(Pegawai bawahan) {
                this.bawahan.add(bawahan);
            }

            public void tambahAgenda(String agenda) {
                this.agenda.add(agenda);
            }

            public void tambahNote(String note) {
                this.notes.add(note);
            }

            public void hapusBawahan(Pegawai bawahan) {
                this.bawahan.remove(bawahan);
            }

            public void hapusAgenda(String agenda) {
                this.agenda.remove(agenda);
            }

            public void hapusNote(String note) {
                this.notes.remove(note);
            }

            public void printBawahan() {

                for (int i = 0; i < this.bawahan.size(); i++) {
                    Pegawai p = this.bawahan.get(i);

                    System.out.printf("----------BAWAHAN %d-----------%n", i + 1);
                    p.printDetail();
                    System.out.println("---------------------------------");

                }
            }

            public void printAgenda() {

                System.out.println("----------AGENDA-----------");
                for (int i = 0; i < this.agenda.size(); i++) {
                    String n = this.agenda.get(i);
                    System.out.printf("%d. %s%n", i + 1, n);
                }
                System.out.println("---------------------------");
            }

            public void printNotes() {

                System.out.println("----------NOTES-----------");
                for (int i = 0; i < this.notes.size(); i++) {
                    String n = this.notes.get(i);
                    System.out.printf("%d. %s%n", i + 1, n);
                }
                System.out.println("--------------------------");
            }

        }

        private static class Manajer extends Pegawai {
            private final ArrayList<Pegawai> bawahan = new ArrayList<>();
            private final ArrayList<String> laporan = new ArrayList<>();

            public void tambahBawahan(Pegawai bawahan) {
                this.bawahan.add(bawahan);
            }

            public void tambahLaporan(String laporan) {
                this.laporan.add(laporan);
            }

            public void hapusBawahan(Pegawai bawahan) {
                this.bawahan.remove(bawahan);
            }

            public void hapusLaporan(String laporan) {
                this.laporan.remove(laporan);
            }

            public void printBawahan() {

                for (int i = 0; i < this.bawahan.size(); i++) {
                    Pegawai p = this.bawahan.get(i);

                    System.out.printf("----------BAWAHAN %d-----------%n", i + 1);
                    p.printDetail();
                    System.out.println("---------------------------------");

                }
            }

            public void printLaporan() {

                System.out.println("----------LAPORAN-----------");
                for (int i = 0; i < this.laporan.size(); i++) {
                    String n = this.laporan.get(i);
                    System.out.printf("%d. %s%n", i + 1, n);
                }
                System.out.println("--------------------------");
            }
        }

        public static void run() {
            Direktur direktur = new Direktur();
            direktur.setBasicData("200401075", "KAWISH BEHZAD MAZHAR", "IT", 20);
            direktur.setFinancialData(20500000d, 500000d, 600000d);
            direktur.tambahBawahan(new Pegawai("200401001", "BEN DOVER", "IT", 20, 10500000d, 300000d, 400000d));
            direktur.tambahBawahan(new Pegawai("200401002", "HUGH JASS", "IT", 20, 10500000d, 300000d, 400000d));
            direktur.tambahBawahan(new Pegawai("200401002", "MIKE HAWK", "IT", 20, 10500000d, 300000d, 400000d));
            direktur.tambahAgenda("Test Agenda 1");
            direktur.tambahNote("Test Note 1");

            System.out.println("==================DIREKTOR=====================");
            direktur.printDetail();
            direktur.printBawahan();
            direktur.printAgenda();
            direktur.printNotes();
            System.out.println("===============================================");

            Manajer manager = new Manajer();
            manager.setBasicData("200401067", "M IBNU LUTHFI AZHAR", "IT", 20);
            manager.setFinancialData(20400000d, 500000d, 600000d);
            manager.tambahBawahan(new Pegawai("200401004", "ANITA HAWK", "IT", 20, 10500000d, 300000d, 400000d));
            manager.tambahBawahan(new Pegawai("200401005", "CONNIE LINGUS", "IT", 20, 10500000d, 300000d, 400000d));
            manager.tambahBawahan(new Pegawai("200401007", "MIKE OXLONG", "IT", 20, 10500000d, 300000d, 400000d));
            manager.tambahLaporan("Test Laporan 1");

            System.out.println("==================MANAJER=====================");
            manager.printDetail();
            manager.printBawahan();
            manager.printLaporan();
            System.out.println("===============================================");


        }
    }

    private static class Week11 {
        private static class Vaksin {
            private String nik, noVaksin;
            private double biayaVaksin;
            private LocalDateTime jadwalVaksin;
            public String namaLengkap, alamatLengkap;

            void tampil() {
                System.out.println("Data Vaksinasi Pekanbaru");
            }

            void setNik(String nik) {
                this.nik = nik;
            }

            String getNik() {
                return this.nik;
            }

            void setNoVaksin(String noVaksin) {
                this.noVaksin = noVaksin;
            }

            String getNoVaksin() {
                return this.noVaksin;
            }

            void setBiayaVaksin(double biayaVaksin) {
                this.biayaVaksin = biayaVaksin;
            }

            double getBiayaVaksin() {
                return this.biayaVaksin;
            }

            void setJadwalVaksin(LocalDateTime jadwalVaksin) {
                this.jadwalVaksin = jadwalVaksin;
            }

            LocalDateTime getJadwalVaksin() {
                return this.jadwalVaksin;
            }

        }

        private static class RSMadani extends Vaksin {
            String ruangan;

            void tampilData() {
                System.out.println("===================================");
                System.out.println("Nama Lengkap : " + this.namaLengkap);
                System.out.println("Alamat Lengkap : " + this.alamatLengkap);
                System.out.println("Ruangan Vaksin: " + this.ruangan);


            }
        }

        private static class Farmasi extends Vaksin {
            String namaFarmasi;
            int stock;


            void tampilData() {
                System.out.println("===================================");
                System.out.println("Nama Lengkap : " + this.namaLengkap);
                System.out.println("Alamat Lengkap : " + this.alamatLengkap);
                System.out.println("Nama Farmasi: " + this.namaFarmasi);
                System.out.println("Stock: " + this.stock);
                System.out.println("===================================");
            }
        }

        public static void run() {
            RSMadani rs = new RSMadani();
            rs.setNik("testNIK");
            rs.setNoVaksin("Blabla");
            System.out.println("NIK = " + rs.getNik());
            System.out.println("No Vaksin = " + rs.getNoVaksin());
            rs.namaLengkap = "Sherlock Holmes";
            rs.alamatLengkap = "Baker St.";
            rs.ruangan = "221B";
            rs.tampilData();
            System.out.println("==============================");
            rs.setBiayaVaksin(500000);
            rs.setJadwalVaksin(LocalDateTime.of(2022, 1, 2, 0, 0, 0));

            System.out.printf("Jadwal Vaksin : %s%n", rs.getJadwalVaksin().format(DateTimeFormatter.ISO_LOCAL_DATE));
            System.out.printf("Biaya Vaksin : %.2f%n", rs.getBiayaVaksin());

        }
    }

    private static class Week12 {
        private static class Kampus {
            String namaKampus, jurusan, akreditasi, wilayah = "x";

            Kampus(String jumlahDosen) {
                System.out.printf("Jumlah Dosen = %s%n", jumlahDosen);
            }

            void kota(String kota) {
                System.out.printf("Nama Kota = %s%n", kota);
            }
        }

        private static class Umri extends Kampus {
            String wilayah = "I";

            Umri(String jumlahDosen) {
                super(jumlahDosen);
            }

            void kampus(String namaKampus) {
                super.kota("blyatown");
                this.namaKampus = namaKampus;
                System.out.printf("Nama Kampus: %s%n", this.namaKampus);
                System.out.printf("Wilayah: %s%n", super.wilayah);
            }

            void kampus2(String namaKampus) {
                super.kota("blyatown2");
                this.namaKampus = namaKampus;
                System.out.printf("Nama Kampus: %s%n", this.namaKampus);
                System.out.printf("Wilayah: %s%n", this.wilayah);
            }
        }

        public static void run() {
            Umri umri = new Umri("5");
            umri.kampus("Blyat 1");
            umri.kampus2("Blyat 2");
        }
    }


    private static class Week12Assignment {

        private static class Mahasiswa {
            String nim, nama, jurusan;
            int semester;

            Mahasiswa(String nim, String nama, String jurusan, int semester) {
                this.nim = nim;
                this.nama = nama;
                this.jurusan = jurusan;
                this.semester = semester;
            }

            void printData() {

                System.out.printf("NIM Mahasiswa : %s%n", this.nim);
                System.out.printf("Nama Mahasiswa : %s%n", this.nama);
                System.out.printf("Jurusan Mahasiswa : %s%n", this.jurusan);
                System.out.printf("Semester : %d%n", this.semester);
            }

        }

        private static class AsistenDosen extends Mahasiswa {
            String namaDosen, namaMk;
            double gaji;
            LocalTime startTime, endTime;
            static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            AsistenDosen(String nim, String nama, String jurusan, int semester, String namaDosen, String namaMk) {
                super(nim, nama, jurusan, semester);
                this.namaDosen = namaDosen;
                this.namaMk = namaMk;
            }

            void setGaji(double gaji) {
                this.gaji = gaji;
            }

            void setJadwal(LocalTime startTime, LocalTime endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }

            void printData() {
                super.printData();
                System.out.printf("Dosen : %s%n", this.namaDosen);
                System.out.printf("Nama Matakuliah : %s%n", this.namaMk);
                System.out.printf("Gaji : %.2f%n", this.gaji);
                System.out.printf("Jam Mulai : %s%n", this.startTime.format(formatter));
                System.out.printf("Jam Akhir : %s%n", this.endTime.format(formatter));
            }

        }

        private static class VerifikasiMataKuliah extends Mahasiswa {
            String namaMk, kodeMk;
            LocalDateTime waktuVerifikasi;
            static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            String komentar;

            VerifikasiMataKuliah(String nim, String nama, String jurusan, int semester, String namaMk, String kodeMk) {
                super(nim, nama, jurusan, semester);
                this.namaMk = namaMk;
                this.kodeMk = kodeMk;
            }

            void verifikasi(String komentar) {
                this.komentar = komentar;
                this.waktuVerifikasi = LocalDateTime.now();
            }

            void printData() {
                super.printData();
                System.out.printf("Nama Matakuliah : %s%n", this.namaMk);
                System.out.printf("Kode Matakuliah  : %s%n", this.kodeMk);
                System.out.printf("Komentar : %s%n", this.komentar);
                System.out.printf("Waktu Verifikasi : %s%n", this.waktuVerifikasi.format(formatter));
            }
        }

        public static void run() {

            System.out.println("=============== ASISTEN DOSEN ==============");
            AsistenDosen asdos = new AsistenDosen("200401075", "Kawish Behzad Mazhar", "Teknik Informatika", 3, "Darmanta Sukrianto, M.Kom", "Pemrograman Berorientasi Objek");
            asdos.setGaji(10000000);
            asdos.setJadwal(LocalTime.of(20, 35), LocalTime.of(22, 0));
            asdos.printData();


            System.out.println("=============== VERIFIKASI MATKUL ==============");
            VerifikasiMataKuliah verif = new VerifikasiMataKuliah("200401075", "Kawish Behzad Mazhar", "Teknik Informatika", 3, "Pemrograman Berorientasi Objek", "PBO");
            verif.verifikasi("Pembelajaran sesuai dengan modul");
            verif.printData();

        }
    }


    private static class Week13 {
        private interface IPegawai {
            String divisi = "Akademik";

            float uangTransport(int gaji);

            float uangMakan(int gaji);

            float tunjangan(int gaji);

            float totalGaji(int gaji, float tunjangan, float makan, float transport);
        }

        private static class Direktur implements IPegawai {
            public String idPegawai;
            public String nama;
            public int gapok;

            void namaDivisi() {
                System.out.printf("Nama Divisi = Divisi %s%n", this.divisi);
            }

            @Override
            public float uangTransport(int gaji) {
                return gaji / 100f * 10;
            }

            @Override
            public float uangMakan(int gaji) {
                return gaji / 100f * 10;
            }

            @Override
            public float tunjangan(int gaji) {
                return gaji / 100f * 10;
            }

            @Override
            public float totalGaji(int gaji, float jaga, float tunjangan, float praktek) {
                return gaji + jaga + tunjangan + praktek;
            }
        }

        public static void run() {
            Scanner input = new Scanner(System.in);
            Direktur direktur = new Direktur();
            System.out.println("Input Data");
            System.out.print("Input ID Pegawai : ");
            direktur.idPegawai = input.nextLine();
            System.out.print("Input Nama Pegawai : ");
            direktur.nama = input.nextLine();
            System.out.print("Input Gaji Pegawai : ");
            direktur.gapok = input.nextInt();
            System.out.println("-");
            direktur.namaDivisi();
            System.out.println("CETAK DATA");
            System.out.printf("ID Dokter : %s%n", direktur.idPegawai);
            System.out.printf("Nama : %s%n", direktur.nama);
            System.out.printf("Gaji : %d%n", direktur.gapok);
            System.out.printf("Uang Praktek : %.2f%n", direktur.uangTransport(direktur.gapok));
            System.out.printf("Uang Jaga : %.2f%n", direktur.uangMakan(direktur.gapok));
            System.out.printf("Uang Tunjangan : %.2f%n", direktur.tunjangan(direktur.gapok));
            System.out.printf("Total Gaji : %.2f%n", direktur.totalGaji(direktur.gapok, direktur.uangTransport(direktur.gapok), direktur.uangMakan(direktur.gapok), direktur.tunjangan(direktur.gapok)));
        }
    }

    private static class Week14 {
        private static class Pelanggan {
            double diskon, hargaJual, hargaBeli;

            protected double getPotonganHarga(double hargaJual) {
                this.hargaJual = hargaJual;
                this.diskon = 0.05;
                this.hargaBeli = this.hargaJual - (this.diskon * this.hargaJual);

                return this.hargaBeli;
            }
        }

        private static class PelangganSilver extends Pelanggan {
            double potonganHarga;

            @Override

            protected double getPotonganHarga(double hargaJual) {
                this.hargaJual = hargaJual;
                this.diskon = 0.05;
                this.hargaBeli = this.hargaJual - (this.diskon * this.hargaJual);

                return this.hargaBeli;
            }

            protected double getPotonganHarga(double hargaJual, double potonganHarga) {
                this.potonganHarga = potonganHarga;
                this.hargaJual = hargaJual;
                this.diskon = 0.10;
                this.hargaBeli = this.hargaJual - ((this.diskon * this.hargaJual) + potonganHarga);
                return this.hargaBeli;
            }
        }


        public static void run() {
            Scanner input = new Scanner(System.in);
            Pelanggan p = new Pelanggan();
            PelangganSilver ps = new PelangganSilver();
            System.out.println("Masukkan total belanja pelanggan : ");
            double total = input.nextDouble();
            double potongan = 10000;
            System.out.println("============================================");
            System.out.println("Total Belanja pelanggan biasa = " + p.getPotonganHarga(total));
            System.out.println("============================================");
            System.out.println("Total belanja pelanggan silver di weekday = " + ps.getPotonganHarga(total));
            System.out.println("total belanja pelanggan silver di weekend = " + ps.getPotonganHarga(total, potongan));
            System.out.println("============================================");
        }
    }

    private static class Week14Assignment {
        private static class Pelanggan {
            double diskon, hargaJual, hargaBeli;

            protected double getPotonganHarga(double hargaJual) {
                this.hargaJual = hargaJual;
                this.diskon = 0.05;
                this.hargaBeli = this.hargaJual - (this.diskon * this.hargaJual);

                return this.hargaBeli;
            }
        }

        private static class PelangganSilver extends Pelanggan {
            double potonganHarga;

            @Override

            protected double getPotonganHarga(double hargaJual) {
                this.hargaJual = hargaJual;
                this.diskon = 0.05;
                this.hargaBeli = this.hargaJual - (this.diskon * this.hargaJual);

                return this.hargaBeli;
            }

            protected double getPotonganHarga(double hargaJual, double potonganHarga) {
                this.potonganHarga = potonganHarga;
                this.hargaJual = hargaJual;
                this.diskon = 0.10;
                this.hargaBeli = this.hargaJual - ((this.diskon * this.hargaJual) + potonganHarga);
                return this.hargaBeli;
            }
        }

        private static class PelangganGold extends Pelanggan {
            double potonganHarga;

            @Override
            protected double getPotonganHarga(double hargaJual) {
                this.hargaJual = hargaJual;
                this.diskon = 0.05;
                this.hargaBeli = this.hargaJual - (this.diskon * this.hargaJual);

                return this.hargaBeli;
            }

            protected double getPotonganHarga(double hargaJual, double potonganHarga) {
                this.potonganHarga = potonganHarga;
                this.hargaJual = hargaJual;
                this.diskon = 0.15;
                this.hargaBeli = this.hargaJual - ((this.diskon * this.hargaJual) + potonganHarga);
                return this.hargaBeli;
            }
        }


        public static void run() {
            Scanner input = new Scanner(System.in);
            Pelanggan p = new Pelanggan();
            PelangganGold ps = new PelangganGold();
            System.out.println("Masukkan total belanja pelanggan : ");
            double total = input.nextDouble();
            double potongan = 10000;
            System.out.println("============================================");
            System.out.println("Total Belanja pelanggan biasa = " + p.getPotonganHarga(total));
            System.out.println("============================================");
            System.out.println("Total belanja pelanggan gold di weekday = " + ps.getPotonganHarga(total));
            System.out.println("total belanja pelanggan gold di weekend = " + ps.getPotonganHarga(total, potongan));
            System.out.println("============================================");
        }
    }

    private static class Week15First {

        private static abstract class Pegawai {

            private String nip, nama;
            private final ArrayList<String> laporan = new ArrayList<>();
            private String blockNumber, streetName, unit, floor, buildingName, postalCode;

            Pegawai(String nama, String nip) {
                this.nip = nip;
                this.nama = nama;
            }

            public void setNama(String nama) {
                this.nama = nama;
            }

            public String getNama() {
                return this.nama;
            }

            public void setNip(String nip) {
                this.nip = nip;
            }

            public String getNip() {
                return this.nip;
            }

            public void tambahLaporan(String laporan) {
                this.laporan.add(laporan);
            }


            public void hapusLaporan(String laporan) {
                this.laporan.remove(laporan);
            }

            public void setAddress(String blockNumber, String streetName, String unit, String floor, String buildingName, String postalCode) {
                this.blockNumber = blockNumber;
                this.streetName = streetName;
                this.unit = unit;
                this.floor = floor;
                this.buildingName = buildingName;
                this.postalCode = postalCode;
            }

            String getAddress() {
                return combineAddress(this.blockNumber, this.streetName, this.unit, this.floor, this.buildingName, this.postalCode);
            }

            public static Boolean isStringEmpty(String str) {
                return str == null || str.equals("");
            }

            public static String combineAddress(String blockNumber, String streetName, String unit, String floor, String buildingName, String postalCode) {
                ArrayList<String> addresses = new ArrayList<>();

                if (!isStringEmpty(blockNumber)) addresses.add("BLK " + blockNumber);

                if (!isStringEmpty(streetName)) addresses.add(streetName);

                if (!isStringEmpty(buildingName)) addresses.add(buildingName);

                if (!isStringEmpty(floor) || !isStringEmpty(unit)) {
                    String temp = "";

                    if (!isStringEmpty(floor)) {
                        temp += floor;
                        if (!isStringEmpty(unit)) temp += " - ";
                    }

                    if (!isStringEmpty(unit)) temp += unit;

                    addresses.add(temp);
                }

                if (!isStringEmpty(postalCode)) addresses.add(postalCode);

                return String.join(", ", addresses);
            }

            public void printData() {
                System.out.printf("NIP : %s%n", this.getNip());
                System.out.printf("Nama : %s%n", this.getNama());
                System.out.printf("Alamat : %s%n", this.getAddress());
            }


            abstract void sendEmail(String to, String subject, String content);

        }

        private static class Staff extends Week15First.Pegawai {
            private String bagian;

            Staff(String nama, String nip, String bagian) {
                super(nama, nip);
                this.bagian = bagian;
            }

            void setBagian(String bagian) {
                this.bagian = bagian;
            }

            String getBagian() {
                return this.bagian;
            }

            @Override
            void sendEmail(String to, String subject, String content) {
                System.out.printf("Subject : %s%n", subject);
                System.out.printf("Content : %s%n", content);
                System.out.printf("Sending Email to %s .... %n", to);
            }

            public void printData() {
                super.printData();
                System.out.printf("Bagian : %s%n", this.getBagian());
            }
        }

        private static class Security extends Week15First.Pegawai {
            private String bagian;
            LocalTime startTime, endTime;
            static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            Security(String nama, String nip, String bagian) {
                super(nama, nip);
                this.bagian = bagian;
            }


            @Override
            void sendEmail(String to, String subject, String content) {
                System.out.printf("Subject : %s%n", subject);
                System.out.printf("Content : %s%n", content);
                System.out.printf("Sending Email to %s .... %n", to);
            }

            void setJadwal(LocalTime startTime, LocalTime endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }

            public void printData() {
                super.printData();
                System.out.printf("Jam Mulai : %s%n", this.startTime.format(formatter));
                System.out.printf("Jam Akhir : %s%n", this.endTime.format(formatter));
            }
        }

        public static void run() {
            System.out.println("=====================STAFF=====================");
            Staff staff = new Staff("Hugh Jass", "123123123", "Software");
            staff.setAddress("KE2", "1 Rochor Road #03-640 RochorCentre", "20", "3", "9a7ba", "123123");
            staff.sendEmail("test@asd.dev", "Hello World", "<h1>Hello world</h1>");
            staff.printData();

            System.out.println("==================SECURITY=====================");
            Security security = new Security("Ben Dover", "456456456", "Hardware");
            security.setAddress("RE1", " 30 Raffles PL #01-37", "20", "3", "Attans Bananer", "123123");
            security.setJadwal(LocalTime.of(20, 35), LocalTime.of(22, 0));
            security.sendEmail("sec@asd.dev", "Hello World", "<h1>Hello world</h1>");
            security.printData();
        }
    }

    private static class Week15Second {

        // Nama interface saya ganti menjadi MataKuliah,
        // karena menurut saya lebih masuk akal jika interface nya nama kuliah
        private interface MataKuliah {
            String universitas = "UMRI";

            void semester();

            void angkatan();

            void nilaiAkhir(double uas, double uts, double tugas, double absen);
        }

        private static class Mahasiswa {
            String nama, nim;
            int semester, angkatan;
            double uas, uts, tugas, absen;

            Mahasiswa(String nama, String nim, int semester, int angkatan, double uas, double uts, double tugas, double absen) {
                this.nama = nama;
                this.nim = nim;
                this.semester = semester;
                this.angkatan = angkatan;
                this.uas = uas;
                this.uts = uts;
                this.tugas = tugas;
                this.absen = absen;
            }
        }

        private static class TeknikInformatika implements MataKuliah {
            public static final ArrayList<Mahasiswa> mahasiswa = new ArrayList<>(Arrays.asList(
                    new Mahasiswa("Kawish Behzad Mazhar", "200401075", 3, 2020, 100, 100, 100, 100),
                    new Mahasiswa("Hermia Kenen", "2004010952", 2, 2019, 83.55, 96.98, 78.52, 90.53),
                    new Mahasiswa("Cyndi Klamman", "2004010771", 6, 2017, 81.91, 78.53, 90.85, 93.0),
                    new Mahasiswa("Noah Habbema", "2004010013", 1, 2017, 89.89, 80.06, 83.86, 90.15),
                    new Mahasiswa("Devina Merrgan", "2004010861", 4, 2021, 78.36, 96.74, 81.56, 96.97),
                    new Mahasiswa("Josh Kenryd", "2004010797", 3, 2017, 90.55, 72.59, 99.25, 79.64),
                    new Mahasiswa("Alys Althorp", "2004010940", 1, 2019, 91.11, 75.81, 89.41, 73.62),
                    new Mahasiswa("Kirk O'Hanlon", "2004010391", 4, 2018, 70.54, 76.17, 92.91, 79.34),
                    new Mahasiswa("Ines Broose", "2004010381", 2, 2017, 75.7, 80.55, 92.11, 85.81),
                    new Mahasiswa("Dewain Duchenne", "2004010223", 6, 2020, 99.61, 82.19, 96.96, 99.43),
                    new Mahasiswa("Deedee Episcopi", "2004010020", 5, 2020, 97.29, 86.39, 72.25, 88.03)
            ));

            @Override
            public void semester() {
                Scanner input = new Scanner(System.in);
                System.out.println("Masukkan semester : ");
                int semester = input.nextInt();

                System.out.printf("=================== %s =================== %n", this.universitas);
                System.out.println("================ MATA KULIAH - Teknik Informatika ==================");
                System.out.printf("Mahasiswa Semester %d : %n", semester);

                List<Mahasiswa> filtered = mahasiswa.stream().filter(x -> x.semester == semester).collect(Collectors.toList());

                if (filtered.size() > 0) {
                    int i = 1;
                    for (Mahasiswa m : filtered) {
                        System.out.printf("%n");
                        System.out.printf("============= MAHASISWA %d ============= %n", i);
                        System.out.printf("Nama = %s %n", m.nama);
                        System.out.printf("NIM = %s %n", m.nim);
                        System.out.printf("Semester = %d %n", m.semester);
                        System.out.printf("Angkatan = %d %n", m.angkatan);
                        System.out.printf("UAS = %.2f %n", m.uas);
                        System.out.printf("UTS = %.2f %n", m.uts);
                        System.out.printf("Tugas = %.2f %n", m.tugas);
                        System.out.printf("Absen = %.2f %n", m.absen);
                        this.nilaiAkhir(m.uas, m.uts, m.tugas, m.absen);
                        i++;
                    }
                } else {
                    System.out.println("NO USERS FOUND");
                }
            }

            @Override
            public void angkatan() {
                Scanner input = new Scanner(System.in);
                System.out.println("Masukkan angkatan : ");
                int angkatan = input.nextInt();

                System.out.printf("=================== %s =================== %n", this.universitas);
                System.out.println("================ MATA KULIAH - Teknik Informatika ==================");
                System.out.printf("Mahasiswa Angkatan %d : %n", angkatan);

                List<Mahasiswa> filtered = mahasiswa.stream().filter(x -> x.angkatan == angkatan).collect(Collectors.toList());

                if (filtered.size() > 0) {
                    int i = 1;
                    for (Mahasiswa m : filtered) {
                        System.out.printf("%n");
                        System.out.printf("============= MAHASISWA %d ============= %n", i);
                        System.out.printf("Nama = %s %n", m.nama);
                        System.out.printf("NIM = %s %n", m.nim);
                        System.out.printf("Semester = %d %n", m.semester);
                        System.out.printf("Angkatan = %d %n", m.angkatan);
                        System.out.printf("UAS = %.2f %n", m.uas);
                        System.out.printf("UTS = %.2f %n", m.uts);
                        System.out.printf("Tugas = %.2f %n", m.tugas);
                        System.out.printf("Absen = %.2f %n", m.absen);
                        this.nilaiAkhir(m.uas, m.uts, m.tugas, m.absen);
                        i++;
                    }
                } else {
                    System.out.println("NO USERS FOUND");
                }
            }

            @Override
            public void nilaiAkhir(double uas, double uts, double tugas, double absen) {
                double nilai = (uas + uts + tugas + absen) / 4d;

                System.out.printf("Nilai = %.2f%n", nilai);

            }
        }

        private static class SistemInformasi implements MataKuliah {
            public static final ArrayList<Mahasiswa> mahasiswa = new ArrayList<>(Arrays.asList(
                    new Mahasiswa("Alidia Czapla", "2004010365", 3, 2021, 77.07, 74.74, 92.32, 94.11),
                    new Mahasiswa("Gabriel Baytrop", "2004010969", 4, 2019, 92.6, 87.46, 94.65, 79.97),
                    new Mahasiswa("Art Garbott", "2004010073", 4, 2020, 73.95, 71.02, 96.81, 90.98),
                    new Mahasiswa("Matilda Vallis", "2004010476", 5, 2017, 88.1, 98.96, 95.64, 76.03),
                    new Mahasiswa("Shelden Clendinning", "2004010387", 4, 2018, 79.46, 81.51, 98.15, 82.31),
                    new Mahasiswa("Donica D'Antuoni", "2004010438", 3, 2020, 88.9, 86.63, 80.08, 93.43),
                    new Mahasiswa("Russ Dunridge", "2004010527", 6, 2019, 74.3, 97.34, 86.19, 90.52),
                    new Mahasiswa("Kaia Aslie", "2004010951", 7, 2018, 75.32, 96.23, 77.54, 99.25),
                    new Mahasiswa("Jacob Kerrey", "2004010082", 5, 2020, 78.58, 75.2, 70.31, 91.49),
                    new Mahasiswa("Sherrie Kunes", "2004010025", 7, 2020, 73.6, 74.05, 99.37, 71.37)
            ));

            @Override
            public void semester() {
                Scanner input = new Scanner(System.in);
                System.out.println("Masukkan semester : ");
                int semester = input.nextInt();

                System.out.printf("=================== %s =================== %n", this.universitas);
                System.out.println("================ MATA KULIAH - Sistem Informasi ==================");
                System.out.printf("Mahasiswa Semester %d : %n", semester);

                List<Mahasiswa> filtered = mahasiswa.stream().filter(x -> x.semester == semester).collect(Collectors.toList());

                if (filtered.size() > 0) {
                    int i = 1;
                    for (Mahasiswa m : filtered) {
                        System.out.printf("%n");
                        System.out.printf("============= MAHASISWA %d ============= %n", i);
                        System.out.printf("Nama = %s %n", m.nama);
                        System.out.printf("NIM = %s %n", m.nim);
                        System.out.printf("Semester = %d %n", m.semester);
                        System.out.printf("Angkatan = %d %n", m.angkatan);
                        System.out.printf("UAS = %.2f %n", m.uas);
                        System.out.printf("UTS = %.2f %n", m.uts);
                        System.out.printf("Tugas = %.2f %n", m.tugas);
                        System.out.printf("Absen = %.2f %n", m.absen);
                        this.nilaiAkhir(m.uas, m.uts, m.tugas, m.absen);
                        i++;
                    }
                } else {
                    System.out.println("NO USERS FOUND");
                }
            }

            @Override
            public void angkatan() {
                Scanner input = new Scanner(System.in);
                System.out.println("Masukkan angkatan : ");
                int angkatan = input.nextInt();

                System.out.printf("=================== %s =================== %n", this.universitas);
                System.out.println("================ MATA KULIAH - Teknik Informatika ==================");
                System.out.printf("Mahasiswa Angkatan %d : %n", angkatan);

                List<Mahasiswa> filtered = mahasiswa.stream().filter(x -> x.angkatan == angkatan).collect(Collectors.toList());

                if (filtered.size() > 0) {
                    int i = 1;
                    for (Mahasiswa m : filtered) {
                        System.out.printf("%n");
                        System.out.printf("============= MAHASISWA %d ============= %n", i);
                        System.out.printf("Nama = %s %n", m.nama);
                        System.out.printf("NIM = %s %n", m.nim);
                        System.out.printf("Semester = %d %n", m.semester);
                        System.out.printf("Angkatan = %d %n", m.angkatan);
                        System.out.printf("UAS = %.2f %n", m.uas);
                        System.out.printf("UTS = %.2f %n", m.uts);
                        System.out.printf("Tugas = %.2f %n", m.tugas);
                        System.out.printf("Absen = %.2f %n", m.absen);
                        this.nilaiAkhir(m.uas, m.uts, m.tugas, m.absen);
                        i++;
                    }
                } else {
                    System.out.println("NO USERS FOUND");
                }
            }

            @Override
            public void nilaiAkhir(double uas, double uts, double tugas, double absen) {
                double nilai = (uas + uts + tugas + absen) / 4d;

                System.out.printf("Nilai = %.2f%n", nilai);

            }
        }

        public static void run() {
            TeknikInformatika tik = new TeknikInformatika();

            tik.semester();
            System.out.printf("%n %n %n3");
            SistemInformasi inf = new SistemInformasi();

            inf.semester();
        }
    }

    private static class Week15Third {
        private static class Animal {
            void sound() {
                System.out.println("Animal Sound = Yeet");
            }
        }

        private static class Eagle extends Animal {

            @Override
            void sound() {
                sound("Wee woo");
            }

            void sound(String sound) {
                System.out.println("Eagle sound = " + sound);
            }
        }

        private static class Elephant extends Animal {

            @Override
            void sound() {
                sound("Wee woo");
            }

            void sound(String sound) {
                System.out.println("Elephant sound = " + sound);
            }

            void sound(int sound) {
                for (int i = 0; i < sound; i++) {
                    sound();
                }
            }

            void sound(String sound, int count) {
                for (int i = 0; i < count; i++) {
                    sound(sound);
                }
            }
        }

        public static void run() {
            Eagle eagle = new Eagle();

            eagle.sound("AArrrrkk");

            Elephant elephant = new Elephant();

            elephant.sound("Weeeaaaaow", 5);
        }
    }

    public static void runWeek2() {
        Week2.run();
    }

    public static void runWeek2AssignmentOne() {
        Week2AssignmentOne.run();
    }

    public static void runWeek3() {
        Week3.run();
    }

    public static void runWeek4() {
        Week4.run();
    }

    public static void runWeek4Assigment() {
        Week4Assignment.run();
    }

    public static void runWeek5() {
        Week5.run();
    }

    public static void runWeek5Assignment() {
        Week5Assignment.run();
    }

    public static void runWeek6() {
        Week6.run();
    }

    public static void runWeek7SingleInheritance() {
        Week7SingleInheritance.run();
    }

    public static void runWeek7MultipleInheritance() {
        Week7MultipleInheritance.run();
    }

    public static void runWeek7HierarchicalInheritance() {
        Week7HierarchicalInheritance.run();
    }

    public static void runWeek8() {
        Week8.run();
    }

    public static void runWeek9Experiment() {
        Week9Experiment.run();
    }

    public static void runWeek9Assignment() {
        Week9Assignment.run();
    }

    public static void runWeek10Experiment() {
        Week10Experiment.run();
    }

    public static void runWeek10Assignment() {
        Week10Assignment.run();
    }

    public static void runWeek11() {
        Week11.run();
    }

    public static void runWeek12() {
        Week12.run();
    }

    public static void runWeek12Assignment() {
        Week12Assignment.run();
    }

    public static void runWeek13() {
        Week13.run();
    }

    public static void runWeek14() {
        Week14.run();
    }

    public static void runWeek14Assignment() {
        Week14Assignment.run();
    }

    public static void runWeek15First() {
        Week15First.run();
    }

    public static void runWeek15Second() {
        Week15Second.run();
    }

    public static void runWeek15Third() {
        Week15Third.run();
    }
}
