# Задание

## Написать свой кастомный ArrayList

Обязательно реализовать следующие методы:
 - add(int index, E element)
 - addAll(Collection<? extends E> c)
 - clear()
 - get(int index)
 - isEmpty()
 - remove(int index)
 - remove(Object o)
 - sort(Comparator<? super E> c)

 Сортировка методом слияния.

## Сборка и запуск.

Для Linux.

```
cd task1
javac -d out src/task1/*.java
java -cp out task1.Main
```