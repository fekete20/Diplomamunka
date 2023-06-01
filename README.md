# Diplomamunka

A UiPath-ban megvalósított folyamat futtatásához a UiPath/Diplomamunka_2023 jegyzékben lévő Main.xaml állományt kell megnyitni UiPath Studio asztali környezetben. Ezt követően a "Debug File" lehetőség alatt található "Run file" kiválasztásával indítható el a folyamat.

A folyamat hibamentes futtatásához szükséges, hogy egy Firefox böngészőben előzetesen bejelentkezzen a GitHub-ra egy olyan felhasználó, aki rendelkezik oktatói jogosultsággal az összes, diplomamunkámban érintett feladatra. Emellett az utolsó előtti "Do" utasításblokkon belüli "Assign" blokk "Value to save" mezőjében be kell állítani azt a jegyzéket, ahová a Firefox a letöltött fájlokat menti, továbbá a "Move File" blokkban a "To" mezőben meg kell adni a /csv kiegészítéssel azt a jegyzéket, ahol a webalkalmazás backend része található.


A webalkalmazás backend része bármely Maven-t támogató IDE-ból elindítható. Ehhez a backend/diplomamunka jegyzék tartalmát kell importálni.

Az alkalmazás működéséhez egy jdbc:mysql://localhost:3306/diplomamunka címen futó adatbázisszerver szükséges, amelyhez "root" felhasználónévvel és "root" jelszóval lehet hozzáférni.
A szerver futtatását openjdk-19.0.2 verzió alatt IntelliJ IDEA IDE-ben teszteltem.


A webalkalmazás frontend része parancssorból is futtatható. Ehhez a frontend/diplomamunka jegyzéket szükséges megnyitni, majd az npm install parancsot kiadni a szükséges csomagok telepítése céljából. Ezt követően az ng serve parancsot kell kiadni. Ekkor alapértelmezetten a http://localhost:4200 címen indul el az alkalmazás. Bejelentkezéshez a "root" felhasználónév és a "root" password használható.

A frontend futtatásához szükséges a számítógépre telepített Node.js, valamint amennyiben nincs az Angular keretrendszer telepítve, úgy azt is el kell végezni az npm install -g @angular/cli parancs segítségével.


Teszt adatok feltöltéséhez a backend/diplomamunka/uploads jegyzékben lévő 2 db CSV fájl használható.
