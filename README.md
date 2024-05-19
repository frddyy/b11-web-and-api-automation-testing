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

## :ledger: Table Of Content
- [Web Automation Testing](#web-automation-testing)
  - [:ledger: Table Of Content](#ledger-table-of-content)
  - [:beginner: About](#beginner-about)
    - [👩‍💻 Author](#-author)
    - [:dart: Tujuan](#dart-tujuan)
    - [:mag_right: Test Case](#mag_right-test-case)
  - [:gear: Tools](#gear-tools)
    - [Java 11](#java-11)
    - [JUnit 4](#junit-4)
    - [Cucumber](#cucumber)
    - [Selenium](#selenium)
    - [WebDriver Chrome](#webdriver-chrome)
  - [:electric_plug: Installation](#electric_plug-installation)
    - [Prasyarat](#prasyarat)
    - [Panduan Instalasi Langkah-demi-Langkah](#panduan-instalasi-langkah-demi-langkah)
      - [Untuk Windows:](#untuk-windows)
  - [:wrench: Development](#wrench-development)
    - [:file_folder: Project Structure](#file_folder-file-structure)
    - [:file_folder: Menambahkan Test Script](#file_folder-menambahkan-test-script)

##  :beginner: About
Proyek ini merupakan pengujian fungsionalitas Login dan Logout pada website [SauceDemo](https://www.saucedemo.com/). Pengujian dilakukan secara otomatis menggunakan Selenium untuk mengotomatisasi interaksi dengan browser, Cucumber untuk penulisan skenario pengujian dalam bahasa Gherkin, JUnit untuk menjalankan dan mengelola unit test, dan Maven sebagai build tools proyek dan pengelolaan dependency. Proyek ini dibuat menggunakan bahasa pemrograman Java.

### 👩‍💻 Author
- Aini Diah Rahmawati [211524033]
- Ghessa Theniana - [211524042]
- Mochamad Ferdy Fauzan - [211524049]

### :dart: Tujuan
Tujuan utama dari proyek ini adalah untuk memenuhi tugas mata kuliah Pengujian Perangkat Lunak Praktikum mengenai Pemahaman Automation Testing Web Application dengan Cucumber dan Selenium

### :mag_right: Test Case
| Test Case ID | Module (Feature)   | Case (-/+/edge) | Test Case Name (Scenario) | Precondition (GIVEN) | Steps to execute (WHEN) | Test Data | Expected Result (THEN) | As Expected | Result (PASS/FAIL) | Remark |
|--------------|--------------------|-----------------|---------------------------|-----------------------|-------------------------|-----------|------------------------|-------------|--------------------|--------|
| 0.0          | Login Functionality |                 |                           |                       |                         |           |                        |             |                    |        |
| 0.0.1        |                    | Positif         | Login berhasil dengan akun yang valid | - User sudah membuka halaman website Swag Labs - User sudah berada pada halaman login | 1. Masukkan username pada formulir 2. Masukkan password pada formulir 3. Klik tombol Login | username: standard_user password: secret_sauce | 1. Berhasil melakukan login 2. User diarahkan ke halaman dashboard |             |                    |        |
| 0.0.2        |                    | Negatif         | Login gagal disebabkan username tidak diisi | - User sudah membuka halaman website Swag Labs - User sudah berada pada halaman login | 1. Masukkan password pada formulir 2. Klik tombol Login | username:  password: secret_sauce | 1. Gagal melakukan login 2. Menampilkan pesan "You need Username !" 3. User tetap berada pada halaman login |             |                    |        |
| 0.0.3        |                    | Negatif         | Login gagal disebabkan password tidak diisi | - User sudah membuka halaman website Swag Labs - User sudah berada pada halaman login | 1. Masukkan username pada formulir 2. Klik tombol Login | username: standard_user password:  | 1. Gagal melakukan login 2. Menampilkan pesan "You need Password !" 3. User tetap berada pada halaman login |             |                    |        |
| 0.0.4        |                    | Negatif         | Login gagal disebabkan username tidak terdaftar | - User sudah membuka halaman website Swag Labs - User sudah berada pada halaman login | 1. Masukkan username pada formulir 2. Masukkan password pada formulir 3. Klik tombol Login | username: super_user password: secret_sauce | 1. Gagal melakukan login 2. Menampilkan pesan "Username and password do not match any user in this service !" 3. User tetap berada pada halaman login |             |                    |        |
| 0.0.5        |                    | Negatif         | Login gagal disebabkan password tidak cocok dengan username yang terdaftar | - User sudah membuka halaman website Swag Labs - User sudah berada pada halaman login | 1. Masukkan username pada formulir 2. Masukkan password pada formulir 3. Klik tombol Login | username: standard_user password: admin123 | 1. Gagal melakukan login 2. Menampilkan pesan "Username and password do not match any user in this service !" 3. User tetap berada pada halaman login |             |                    |        |
| 0.0.6        |                    | Negatif         | Login gagal disebabkan username dan password tidak diisi | - User sudah membuka halaman website Swag Labs - User sudah berada pada halaman login | 1. Klik tombol Login | username:  password:  | 1. Gagal melakukan login 2. Menampilkan pesan "You need Username & Password !" 3. User tetap berada pada halaman login |             |                    |        |
| 0.1          | Logout Functionality|                 |                           |                       |                         |           |                        |             |                    |        |
| 0.1.1        |                    | Positif         | Navigasi Fitur Menu Logout | - User sudah membuka halaman website Swag Labs - User sudah melakukan login pada website Swag Labs | 1. Klik sidebar Menu 2. Klik button Logout | -         | 1. Pengguna diarahkan untuk keluar dari aplikasi 2. Aplikasi menampilkan halaman login |             |                    |        |


## :gear: Tools
Proyek ini menggunakan beberapa teknologi utama:

### Java 11
[![Java](https://img.shields.io/badge/Java-11-blue?logo=java)](https://www.oracle.com/java/)

Bahasa pemrograman Java versi 11 digunakan dalam proyek ini untuk mengembangkan skrip otomatisasi.

### JUnit 4
[![JUnit](https://img.shields.io/badge/JUnit-4-green?logo=junit)](https://junit.org/junit4/)

JUnit 4 digunakan untuk menjalankan dan mengelola unit test dalam proyek ini.

### Cucumber
[![Cucumber](https://img.shields.io/badge/Cucumber-BDD-orange?logo=cucumber)](https://cucumber.io/)

Cucumber digunakan untuk menulis skenario pengujian dalam bahasa Gherkin agar lebih mudah dipahami dan terstruktur.

### Selenium
[![Selenium](https://img.shields.io/badge/Selenium-Automation-blueviolet?logo=selenium)](https://www.selenium.dev/)

Selenium digunakan untuk mengotomatisasi interaksi dengan browser web dalam pengujian otomatis.

### WebDriver Chrome 
[![Chrome Driver](https://img.shields.io/badge/Chrome%20Driver-Latest-yellow?logo=googlechrome)](https://chromedriver.chromium.org/)

WebDriver Chrome versi 1.24 digunakan sebagai driver untuk mengontrol browser Google Chrome dalam pengujian.

## :electric_plug: Installation
Berikut adalah langkah-langkah detail untuk menginstal dan menjalankan proyek ini berdasarkan sistem operasi yang Anda gunakan.

### Prasyarat
1. **Java Development Kit (JDK)**
   - Pastikan Anda memiliki JDK terinstal. Anda dapat mengunduhnya dari [situs resmi Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   
2. **Maven**
   - Pastikan Anda memiliki Apache Maven terinstal. Anda dapat mengunduhnya dari [situs resmi Maven](https://maven.apache.org/download.cgi).
   
3. **Cucumber**
   - Jika Anda menggunakan Eclipse, Anda perlu menginstal plugin Cucumber.

### Panduan Instalasi Langkah-demi-Langkah

#### Untuk Windows:

1. **Clone Repository**
   - Buka Command Prompt dan navigasikan ke direktori tempat Anda ingin meng-clone repository.
   - Jalankan perintah berikut:
     ```sh
     git clone https://github.com/ainidr25/b11-web-automation-testing.git
     ```

2. **Install Plugin Cucumber di Eclipse**
   - Buka Eclipse.
   - Pergi ke `Help` > `Eclipse Marketplace`.
   - Di kolom `Find`, ketik `Cucumber`.
   - Klik `Go`, dan dari hasil pencarian, klik `Install` di sebelah `Cucumber Eclipse Plugin`.
   - Ikuti petunjuk untuk menyelesaikan instalasi dan restart Eclipse jika diperlukan.

3. **Navigasikan ke Direktori Proyek**
   - Di Command Prompt, navigasikan ke direktori repository yang telah di-clone:
     ```sh
     cd b11-web-automation-testing
     ```

4. **Jalankan Proyek**
   - Jalankan perintah berikut untuk menjalankan pengujian menggunakan Maven:
     ```sh
     mvn test
     ```

##  :wrench: Development

### :file_folder: Project Structure

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

### :file_folder: Menambahkan Test Script

1. **Buat File Cucumber**
   - Buat file fitur Cucumber pada direktori `src\test\resources`.
   - Contoh: `LoginPage.feature` dan `LogoutPage.feature`.

2. **Buat Class Locator**
   - Buat class locator dari elemen pada halaman yang akan diuji dan simpan di direktori `src\test\java\locators`.
   - Contoh:
     ```java
     package locators;

     import org.openqa.selenium.WebElement;
     import org.openqa.selenium.support.FindBy;
     import org.openqa.selenium.support.PageFactory;

     public class LoginPageLocators {
         @FindBy(id = "user-name")
         public WebElement usernameField;

     }
     ```

3. **Buat Class Actions**
   - Buat class actions yang menggunakan locator pada file locator yang telah dibuat sebelumnya dan simpan di direktori `src\test\java\actions`.
   - Pada file ini, jangan lupa untuk menginisiasi driver dengan menambahkan kode berikut:
     ```java
        nama_kelas_locators nama_variabel = null;

            public nama_kelas_actions() {
                this.nama_variabel = new nama_kelas_locators();
                PageFactory.initElements(HelperClass.getDriver(), nama_variabel);
            }
     ```

4. **Buat Step Definitions**
   - Buat step definitions berdasarkan file Gherkin yang telah dibuat dan simpan di direktori `src\test\java\stepdefinitions`.
   - Contoh:
     ```java
     package stepdefinitions;

     import actions.LoginPageActions;
     import io.cucumber.java.en.When;
     import io.cucumber.java.en.Then;

     public class LoginSteps {
         LoginPageActions loginPageActions = new LoginPageActions();

         @When("^user enters username \"([^\"]*)\"$")
         public void user_enters_username(String username) {
             loginPageActions.enterUsername(username);
         }

     }
     ```

Dengan mengikuti langkah-langkah di atas, script pengujian dapat ditambahkan

## How to Run / Test Runner

1. Buka terminal atau command prompt dan arahkan ke direktori proyek.

```
cd b11-web-automation-testing
```

2. Untuk menginstal proyek, jalankan perintah `mvn install`.
3. Jalankan perintah `mvn test` untuk menjalankan pengujian.
4. Setelah pengujian selesai, laporan pengujian akan di-generate. Untuk mengakses laporan pengujian dalam format HTML, buka file berikut menggunakan browser web (Jika menggunakan VSCode bisa memanfaatkan fitur "Open with Live Server"): `target/HtmlReports/report.html`

## Test Cases

| No. | Fitur Pengujian | Test Case                                                                                     | Tujuan Pengujian                                                                                                            |
| --- | --------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- |
| 1   | Login           | - TC0.0.1 Login berhasil dengan akun yang valid (PASS)                                        | Memastikan bahwa pengguna dapat melakukan Login dengan akun yang valid dan sudah terdaftar                                  |
|     |                 | - TC0.0.2 Login gagal disebabkan uusername tidak diisi (FAILED)                               | Memastikan bahwa pengguna tidak dapat melakukan Login apabila tiadk mengisikan field Username                               |
|     |                 | - TC0.0.3 Login gagal disebabkan password tidak diisi (FAILED)                                | Memastikan bahwa pengguna tidak dapat melakukan login apabila tidak mengisikan field Password                               |
|     |                 | - TC0.0.4 Login gagal disebabkan username tidak terdaftar (FAILED)                            | Memastikan bahwa pengguna tidak dapat melakukan login apabila memasukkan username yang tidak terdaftar                      |
|     |                 | - TC0.0.5 Login gagal disebabkan password tidak cocok dengan username yang terdaftar (FAILED) | Memastikan bahwa pengguna tidak dapat melakukan login dengan password yang salah atau tidak cocok dengan username yang ada. |
|     |                 | - TC0.0.6 Login gagal disebabkan username dan password tidak diisi (PASS)                     | Mem

astikan bahwa pengguna tidak dapat melakukan login apabila tidak mengisikan informasi pada field username dan password.  |
| 2   | Logout          | - TC0.1.1 Navigasi Fitur Menu Logout                                                          | Memastikan bahwa pengguna berhasil melakukan logout dan diarahkan menuju halaman login kembali                              |
