# Web Automation Testing With Selenium & Cucumber

## Description

Program ini merupakan program untuk melakukan functional testing dalam Fitur Login dan Logout pada halaman website [SauceDemoSwagLabs](https://www.saucedemo.com/) secara otomatis dengan menggunakan Selenium untuk mengatur interaksi secara otomatis dengan halaman browser & Cucumber sebagai framework penulisan skenario pengujian dalam syntax Gherkin.

## Technologies & Tools

- **Repository Management** : Git
- **IDE** : Visual Studio Code
- **CLI** : Command Prompt (CMD) / Powershell (Windows)
- **Build Tools** : [![Maven](https://img.shields.io/badge/Maven-3.8.3-blue)](https://maven.apache.org/)
  Kami menggunakan Apache Maven untuk mengelola proyek Java kami secara lebih efisien.
  Versi Maven yang kami gunakan adalah 3.8.3.
  Untuk informasi lebih lanjut -> [Kunjungi situs Maven](https://maven.apache.org/).
- **Programming Language** : [![Java](https://img.shields.io/badge/Java-17.0.10%202024--01--16%20LTS-red)](https://www.java.com/)
  Dalam pengembangan aplikasi ini, kami menggunakan bahasa pemrograman Java.
  Kami memilih bahasa pemrograman ini karena memudahkan dari segi pengembangan dan fungsionalitas yang diharapkan. Banyaknya referensi yang dapat kami gunakan juga menjadi faktor untuk penentuan penggunaan bahasa pemrograman ini.
  Versi java yang kami gunakan adalah Java 17.0.10 2024-01-16 LTS.
  Untuk informasi lebih lanjut -> [Kunjungi situs Java](https://www.java.com/) untuk informasi lebih lanjut.
- **Unit Testing** :
- **Automation Testing Tools** : Cucumber Java & JUnit Versi 7.17.0
- **WebDriverManager** : Versi 5.4.0
- **GlueGen** : Versi 2.3.2
- **Selenium** : Versi 4.20.0
- **SLF4J (Simple Logging Facade for Jva)** : Versi 2.0.7

## Instalasi

1. Lakukan instalasi Java JDK dengan versi minimal 17 atau versi terbaru (disarankan menggunakan versi 17 atau 21) dari [halaman resmi Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. Pastikan instalasi JDK berhasil dengan menjalankan perintah `java --version` di terminal atau command prompt Anda.
3. Lakukan instalasi Maven (versi 3.8.3) dari [situs web Maven](https://maven.apache.org/download.cgi).
4. Setelah mengunduh dan menginstal Maven, pastikan Anda menambahkan Maven ke dalam variabel lingkungan PATH Anda. Instruksi untuk melakukan hal ini dapat ditemukan di [situs web Maven](https://maven.apache.org/install.html).
5. Pastikan instalasi Maven berhasil dengan menjalankan perintah `mvn --version` di terminal atau command prompt Anda.
6. Jika sudah berhasil, clone repositori ini ke perangkat Anda dengan menjalankan perintah berikut di terminal atau command prompt:

```
git clone https://github.com/ainidr25/b11-web-automation-testing.git
```

7. Buka proyek yang telah di-clone menggunakan IDE favorit Anda. Kami merekomendasikan Visual Studio Code untuk kemudahan penggunaan.
8. Anda sekarang siap untuk mulai mengembangkan dan menjalankan pengujian pada proyek ini.

## Dependency Configuration

- **Logging** : [![SLF4J API](https://img.shields.io/badge/SLF4J%20API-1.7.5-orange)](http://www.slf4j.org/)
  SLF4J API digunakan untuk logging dalam proyek ini, dengan implementasi Logback.
  Versi SLF4J API yang digunakan adalah 2.0.7.
  Untuk informasi lebih lanjut -> [Kunjungi situs SLF4J](http://www.slf4j.org/) untuk informasi lebih lanjut.

## Project Structure

```
├── src/
│   ├── driver/
│   │   ├── chromedriver.exe
│   ├── test/
│   │   └── java/
│   │       └── actions/
│   │           ├── HomePageActions.java
│   │           ├── loginPageActions.java
│   │       └── locators/
│   │           ├── HomePageLocators.java
│   │           ├── loginPageLocators.java
│   │       └── runner/
│   │           ├── CucumberRunnerTest.java
│   │       └── stepdefinitions/
│   │           ├── Hooks.java
│   │           ├── loginSteps.java
│   │       └── utils/
│   │           ├── HelperClass.java
│   │   └── resources/
│   │       └── LoginPage.feature
├── target/
│   └── generated-test-sources/
│   └── HtmlReports/
│   │   └── report.html
│   └── JSonReports/
│   │   └── report.json
│   └── JUnitReports/
│   │   └── report.xml
│   └── maven-status
│   └── surefire-reports
│   └── test-classes
├── .gitignore
├── pom.xml
└── README.md
```

## How to Run / Test Runner

1. Buka terminal atau command prompt dan arahkan ke direktori proyek.

```
cd b11-web-automation-testing
```

2. Untuk menginstal proyek, jalankan perintah `mvn install`.
3. Jalankan perintah `mvn test` untuk menjalankan pengujian.
4. Setelah pengujian selesai, laporan pengujian akan di-generate. Untuk mengakses laporan pengujian dalam format HTML, buka file berikut menggunakan browser web (Jika menggunakan VSCode bisa memanfaatkan fitur "Open with Live Server"): `target/HtmlReports/report.html`

## Fitur Software Under Test

Proyek ini menguji API DummyAPI dengan menggunakan beberapa fitur utama, diantaranya:

| Fitur          | Deskripsi                                               | Cara Request                                        |
| -------------- | ------------------------------------------------------- | --------------------------------------------------- |
| Get User by ID | Mendapatkan informasi pengguna berdasarkan ID pengguna. | `GET /user/:id`                                     |
| Create User    | Membuat pengguna baru.                                  | `POST /user/create` dengan body data pengguna baru. |
| Update User    | Memperbarui informasi pengguna yang ada.                | `PUT /user/:id` dengan body data yang diperbarui.   |
| Delete User    | Menghapus pengguna dari sistem.                         | `DELETE /user/:id`                                  |

Dokumentasi lengkap untuk API DummyAPI dapat ditemukan di [sini](https://dummyapi.io/docs/user).

# Test Cases

| No. | Fitur Pengujian | Test Case                                                                                     | Tujuan Pengujian                                                                                                            |
| --- | --------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- |
| 1   | Login           | - TC0.0.1 Login berhasil dengan akun yang valid (PASS)                                        | Memastikan bahwa pengguna dapat melakukan Login dengan akun yang valid dan sudah terdaftar                                  |
|     |                 | - TC0.0.2 Login gagal disebabkan uusername tidak diisi (FAILED)                               | Memastikan bahwa pengguna tidak dapat melakukan Login apabila tiadk mengisikan field Username                               |
|     |                 | - TC0.0.3 Login gagal disebabkan password tidak diisi (FAILED)                                | Memastikan bahwa pengguna tidak dapat melakukan login apabila tidak mengisikan field Password                               |
|     |                 | - TC0.0.4 Login gagal disebabkan username tidak terdaftar (FAILED)                            | Memastikan bahwa pengguna tidak dapat melakukan login apabila memasukkan username yang tidak terdaftar                      |
|     |                 | - TC0.0.5 Login gagal disebabkan password tidak cocok dengan username yang terdaftar (FAILED) | Memastikan bahwa pengguna tidak dapat melakukan login dengan password yang salah atau tidak cocok dengan username yang ada. |
|     |                 | - TC0.0.6 Login gagal disebabkan username dan password tidak diisi (PASS)                     | Memastikan bahwa pengguna tidak dapat melakukan login apabila tidak mengisikan informasi pada field username dan password.  |
| 2   | Logout          | - TC0.1.1 Navigasi Fitur Menu Logout                                                          | Memastikan bahwa pengguna berhasil melakukan logout dan diarahkan menuju halaman login kembali                              |

## Author

- Aini Diah Rahmawati [211524033]
- Ghessa Theniana - [211524042]
- Mochamad Ferdy Fauzan - [211524049]
