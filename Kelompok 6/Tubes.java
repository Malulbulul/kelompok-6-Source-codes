import java.util.Scanner;

public class Tubes{

    public static void tampilkanDenah(int[][] kursi) {
        System.out.println("\n DENAH KURSI LABORATORIUM ");
        System.out.print("  ");
        for (int j = 0; j < kursi[0].length; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < kursi.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < kursi[i].length; j++) {
                if (kursi[i][j] == 0) {
                    System.out.print("K ");
                } else {
                    System.out.print("P ");
                }
            }
            System.out.println();
        }
    }


    public static void pesanKursi(int[][] kursi, Scanner scanner) {
        int barisUser, kolomUser;

        while (true) {
        System.out.print("Masukkan nomor baris (1-4): ");
        barisUser = scanner.nextInt();
        System.out.print("Masukkan nomor kolom (1-5): ");
        kolomUser = scanner.nextInt();

        if (barisUser < 1 || barisUser > 4 || kolomUser < 1 || kolomUser > 5) {
            System.out.println("Posisi kursi tidak valid.");
        } else {
            break;
         }
        }

        int r = barisUser - 1;
        int c = kolomUser - 1;

        if (kursi[r][c] == 0) {
            kursi[r][c] = 1;
            System.out.println("Pemesanan berhasil.");
        } else {
            System.out.println("Kursi sudah dipesan.");
        }
    }

    public static void batalkanKursi(int[][] kursi, Scanner scanner) {
        int barisUser, kolomUser;

        while (true) {
        System.out.print("Masukkan nomor baris (1-4): ");
        barisUser = scanner.nextInt();
        System.out.print("Masukkan nomor kolom (1-5): ");
        kolomUser = scanner.nextInt();

        if (barisUser < 1 || barisUser > 4 || kolomUser < 1 || kolomUser > 5) {
            System.out.println("Posisi kursi tidak valid.");
        } else {
            break;
         }
        
        }

        int r = barisUser - 1;
        int c = kolomUser - 1;

        if (kursi[r][c] == 1) {
            kursi[r][c] = 0;
            System.out.println("Pembatalan berhasil.");
        } else {
            System.out.println("Kursi belum dipesan.");
        }
    }


    public static void tampilkanRekap(int[][] kursi) {
        int totalKursi = 20;
        int jumlahDipesan = 0;

        for (int i = 0; i < kursi.length; i++) {
            for (int j = 0; j < kursi[i].length; j++) {
                if (kursi[i][j] == 1) {
                    jumlahDipesan++;
                
                }
            }
        }

        int jumlahKosong = totalKursi - jumlahDipesan;
        double persentase = ((double) jumlahDipesan / totalKursi) * 100.0;

        System.out.println("\n--- REKAP LABORATORIUM ---");
        System.out.println("Total kursi: " + totalKursi);
        System.out.println("Jumlah dipesan: " + jumlahDipesan);
        System.out.println("Jumlah kosong: " + jumlahKosong);
        System.out.printf("Persentase keterisian: %.2f%%\n", persentase);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] kursi = new int[4][5];
        int pilihan;

        do {
            System.out.println("\n APLIKASI PEMESANAN KURSI LABORATORIUM ");
            System.out.println("1. Lihat denah");
            System.out.println("2. Pesan kursi");
            System.out.println("3. Batalkan pesanan");
            System.out.println("4. Rekap");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tampilkanDenah(kursi);
                    break;
                case 2:
                    pesanKursi(kursi, scanner);
                    break;
                case 3:
                    batalkanKursi(kursi, scanner);
                    break;
                case 4:
                    tampilkanRekap(kursi);
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
                    break;
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
