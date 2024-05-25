import java.util.Scanner;

public class BST {
    Node root;

    // Konstruktor
    public BST() {
        root = null;
    }

    // Metode untuk menyisipkan data ke dalam BST
    public void insert(char data) {
        root = insertRec(root, data);
    }

    // Metode rekursif untuk menyisipkan data ke dalam BST
    private Node insertRec(Node root, char data) {
        // Jika pohon kosong, buat node baru
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Jika tidak, rekursi ke bawah pohon
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        // Mengembalikan pointer node (tidak berubah)
        return root;
    }

    // Metode untuk mencari data dalam BST
    public boolean search(char data) {
        return searchRec(root, data);
    }

    // Metode rekursif untuk mencari data dalam BST
    private boolean searchRec(Node root, char data) {
        // Kasus dasar: root null atau data ditemukan pada root
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }

        // Jika data lebih besar dari data root
        if (root.data < data) {
            return searchRec(root.right, data);
        }

        // Jika data lebih kecil dari data root
        return searchRec(root.left, data);
    }

    public static void main(String[] args) {
        BST tree = new BST();

        // Data yang diberikan
        char[] data = {'F', 'E', 'H', 'D', 'G', 'C', 'B', 'H', 'K', 'J'};

        // Membentuk BST dengan data di atas
        for (char datum : data) {
            tree.insert(datum);
        }

        // Memungkinkan pengguna untuk memasukkan karakter yang ingin dicari
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan karakter yang ingin dicari: ");
        char charToSearch = scanner.next().charAt(0);

        // Mencari karakter yang dimasukkan pengguna
        boolean found = tree.search(charToSearch);
        if (found) {
            System.out.println("Karakter '" + charToSearch + "' ditemukan di BST.");
        } else {
            System.out.println("Karakter '" + charToSearch + "' tidak ditemukan di BST.");
        }

        scanner.close();
    }
}
