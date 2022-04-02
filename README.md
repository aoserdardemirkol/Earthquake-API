# Earthquake-API

1. Projeyi cihazınıza kopyalayın: `git clone https://github.com/aoserdardemirkol/Earthquake-API.git`
2. Proje ana dizinine gidin: `cd Earthquake-API`
3. `mvn clean install` ile çalıştırılabilir jar dosyasını oluşturun.
4. `mvn spring-boot:run` ile projeyi çalıştırın.

|           Controller        | Metot  |      Adres     |                               Açıklama                               |        
| :-------------------------: | :----: | :------------: | :------------------------------------------------------------------: |
|  **EarthquakeController **  |  GET   | /v1/earthquake | Verilen ülke ismi ve güne göre ülkede gerçekleşen depremleri getirir.|

<h3>Request</h3>

{ <br>
&nbsp; "country": "Turkey", <br>
&nbsp; "countofDays" : 15 <br>
}

<h3>Response</h3>

[ <br>
&nbsp; { <br>
&nbsp; &nbsp; "country": "Turkey", <br>
&nbsp; &nbsp; "place": "16km NNE of Karaisal, Turkey", <br>
&nbsp; &nbsp; "magnitude" : 4.2, <br>
&nbsp; &nbsp; "earthquakeTime": "01.04.2022 08:34" <br>
&nbsp; }, <br>
&nbsp; { <br>
&nbsp; &nbsp; "country": "Turkey", <br>
&nbsp; &nbsp; "place": "18km E of Mustafakemalpaşa, Turkey", <br>
&nbsp; &nbsp; "magnitude" : 4.4, <br>
&nbsp; &nbsp; "earthquakeTime": "22.03.2022 17:10" <br>
&nbsp; } <br>
]
