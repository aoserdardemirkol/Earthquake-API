# Earthquake-API

1. Projeyi cihazınıza kopyalayın: `git clone https://github.com/aoserdardemirkol/Earthquake-API.git`
2. Proje ana dizinine gidin: `cd Earthquake-API`
3. `mvn clean install` ile çalıştırılabilir jar dosyasını oluşturun.
4. `mvn spring-boot:run` ile projeyi çalıştırın.

|           Controller        | Metot  |      Adres     |                               Açıklama                               |        
| :-------------------------: | :----: | :------------: | :------------------------------------------------------------------: |
|  **EarthquakeController **  |  GET   | /v1/earthquake | Verilen ülke ismi ve güne göre ülkede gerçekleşen depremleri getirir.|
