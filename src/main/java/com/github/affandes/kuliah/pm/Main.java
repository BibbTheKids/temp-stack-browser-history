package com.github.affandes.kuliah.pm;
import java.util.ArrayList;
import java.util.Scanner;

class BrowserHistory {
    private final ArrayList<String> history;

    public BrowserHistory() {
        history = new ArrayList<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
            return;
        }
        System.out.println("History Browser:");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
    }

    public void browse(String url) {
        history.add(url);
        System.out.println("Menambahkan '" + url + "' ke history.");
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk kembali.");
            return;
        }
        String lastUrl = history.remove(history.size() - 1);
        System.out.println("Kembali dari '" + lastUrl + "'. Website terakhir telah dihapus dari history.");
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View History");
            System.out.println("2. Browse Website");
            System.out.println("3. Back to Previous Website");
            System.out.println("4. Exit");

            System.out.print("Pilih opsi (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi newline

            switch (choice) {
                case 1:
                    browserHistory.view();
                    break;
                case 2:
                    System.out.print("Masukkan URL website: ");
                    String url = scanner.nextLine();
                    browserHistory.browse(url);
                    break;
                case 3:
                    browserHistory.back();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid, silakan coba lagi.");
            }
        }
    }
}
