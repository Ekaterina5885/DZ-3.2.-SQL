**Тестирование входа в систему через веб-интерфейс.**

**Начало работы**
1.	Запустить контейнер командой: **docker-compose up**
      
2.	Запустить SUT командой: **java -jar artifacts/app-deadline.jar -P:jdbc.url=jdbc:mysql://localhost:3306/app -P:jdbc.user=app -P:jdbc.password=pass**
      
**Процесс работы**
      Запустить тесты командой: **gradlew test**

**Окончание работы**
      Остановить контейнер командой docker-compose down
