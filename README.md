Здесь частоты и логики не искать

Sequence - Добавил jar для мака

Инструкция по сборке(В сборке я не силен, поэтому начальные действия были в eclipse)
1. Создаем папку с этим проектом и открываем его в Eclipse
2. Жмем на папку проекта правой кнопкой -> Maven -> Update Project
3. Открываем pom.xml и жмем выполнить в высветившемся окне выбираем Maven Install
4. Проект готов в папке target лежат .jar файлы
5. Открываем консоль, переходим в папку target, выполняем следующую команду: 
jpackage --type msi --input . --name sequence --win-shortcut --main-jar sequenceApp-0.0.1-SNAPSHOT.jar --main-class ru.vk.sladkiipirojok.NewMain --verbose
6. Установщик готов
