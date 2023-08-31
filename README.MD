[![Build status](https://ci.appveyor.com/api/projects/status/4ikddmsc980tevv5?svg=true)](https://ci.appveyor.com/project/Aliaksandr-Zuyeuski/saucedemotests)
# Opis productu


Sklep internetowy z zakupami dla testerów.

https://www.saucedemo.com

## Opis Uruchamiania Testów

Ten plik README zawiera informacje na temat sposobu uruchamiania testów w projekcie przy użyciu narzędzia Gradle.

## Użycie

#### Aby uruchomić testy projektu, możesz użyć poniższych poleceń, uwzględniając różne użytkowniki:

### Standardowy użytkownik (`standard_user`):

```
./gradlew -test
```
## Użytkownik mający problemy (`problem_user`):

```
./gradlew test "-PuserName=problem_user"
```

## Użytkownik o wydajnościowym problemie (`performance_glitch_user`):

```
./gradlew test "-PuserName=performance_glitch_user"
```