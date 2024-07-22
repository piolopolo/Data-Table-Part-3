# MongoDB-ObjectID

## Overview
Proyek ini menunjukkan cara mengimplementasikan generator ObjectID yang digunakan pada MongoDB tanpa menggunakan MongoDB atau library pihak ketiga.

## Struktur ObjectID
ObjectID terdiri dari 12 byte dengan struktur sebagai berikut:
- **4 byte:** Unix timestamp dalam detik
- **5 byte:** Nilai acak
- **3 byte:** Counter yang meningkat, diinisialisasi dengan nilai acak

## Penggunaan
### Contoh Penggunaan
```java
public class Main {
    public static void main(String[] args) {
        String objectId = ObjectIdGenerator.generate();
        System.out.println("Generated ObjectID: " + objectId);
    }
}
```

### Penjelasan Kode
- **Timestamp**: Menggunakan timestamp Unix dalam detik.
- **Random Value**: Menghasilkan nilai acak 5 byte saat inisialisasi.
- **Counter**: Counter 3 byte yang diinisialisasi dengan nilai acak dan meningkat setiap kali ObjectID dihasilkan.

## Langkah Setup
1. Clone repository ini.
2. Tambahkan `ObjectIdGenerator.java` ke proyek Anda.
3. Gunakan metode `generate()` untuk menghasilkan ObjectID baru.

## Proof of Concept
Anda dapat membuat proyek Spring Boot dan menambahkan endpoint untuk menghasilkan ObjectID jika diinginkan.

### Menggunakan Spring Boot
Jika Anda menggunakan Spring Boot, jalankan aplikasi menggunakan perintah berikut:
```
./mvnw spring-boot:run
```

Gunakan endpoint berikut untuk menghasilkan ObjectID:
- URL: /api/generate-objectid
- Metode: `GET`
  
