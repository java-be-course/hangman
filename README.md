## Задача
Реализовать игру “виселица” на Java. Интерфейс - консольный. Описание правил игры на [Википедии](https://ru.wikipedia.org/wiki/%D0%92%D0%B8%D1%81%D0%B5%D0%BB%D0%B8%D1%86%D0%B0_(%D0%B8%D0%B3%D1%80%D0%B0)).

## Функционал приложения и меню консольного интерфейса
1. При старте, приложение предлагает начать новую игру или выйти из приложения
2. При начале новой игры, случайным образом загадывается слово, и игрок начинает процесс по его отгадыванию
3. После каждой введенной буквы выводим в консоль счётчик ошибок, текущее состояние виселицы (нарисованное ASCII символами)
4. По завершении игры выводим результат (победа или поражение) и возвращаемся к состоянию #1 - предложение начать новую игру или выйти из приложения

## Запуск
java -jar "jar/hangman-1.0.jar"