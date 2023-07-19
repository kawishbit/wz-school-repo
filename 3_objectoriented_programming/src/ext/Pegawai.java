package ext;

import java.text.NumberFormat;
import java.util.Locale;

public class Pegawai {
    private final Locale indonesia = new Locale("in", "ID");
    private final NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesia);
    public String nip, nama, divisi;
    protected int hariKerja;
    protected double gajiPokok, uangMakan, uangTransport;

    public Pegawai() {

    }

    public Pegawai(String nip, String nama, String divisi, int hariKerja, double gajiPokok, double uangMakan, double uangTransport) {

        this.nip = nip;
        this.nama = nama;
        this.divisi = divisi;
        this.hariKerja = hariKerja;
        this.gajiPokok = gajiPokok;
        this.uangMakan = uangMakan;
        this.uangTransport = uangTransport;
    }

    public void setBasicData(String nip, String nama, String divisi, int hariKerja) {
        this.nip = nip;
        this.nama = nama;
        this.divisi = divisi;
        this.hariKerja = hariKerja;
    }

    public void setFinancialData(double gajiPokok, double uangMakan, double uangTransport) {
        this.gajiPokok = gajiPokok;
        this.uangMakan = uangMakan;
        this.uangTransport = uangTransport;
    }

    public double getGaji() {
        return this.gajiPokok + this.uangMakan + this.uangTransport;
    }


    public void printDetail() {
        System.out.printf("NIP Pegawai : %s%n", this.nip);
        System.out.printf("Nama Pegawai : %s%n", this.nama);
        System.out.printf("Divisi Pegawai : %s%n", this.divisi);
        System.out.printf("Gaji Pokok : %s%n", rupiahFormat.format(this.gajiPokok));
        System.out.printf("Uang Makan : %s%n", rupiahFormat.format(this.uangMakan));
        System.out.printf("Uang Transport : %s%n", rupiahFormat.format(this.uangTransport));
        System.out.printf("Total : %s%n", rupiahFormat.format(this.getGaji()));
    }


}
