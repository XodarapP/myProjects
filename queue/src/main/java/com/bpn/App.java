package com.bpn;

import com.bpn.handler.Handler;
import com.bpn.threads.GroupThreads;

import java.util.ArrayList;
import java.util.List;

/*
    Имеется очередь элементов на обработку.
    Каждый элемент имеет собственный идентификатор (itemId) и принадлежит к некоторой группе (groupId).
    Внутри группы элементы должны обрабатываться строго последовательно, в порядке увеличения идентификаторов элементов.
    Элементы разных групп могут обрабатываться параллельно.
    Обработка элемента производится путем вызова некоторого метода с
    параметрами itemId и groupId, который печатает полученные идентификаторы элементов.
    Элементы в очередь добавляются асинхронно внешним процессом.
    После обработки элемент должен быть удален из очереди.

    Написать обработчик очереди, работающий в несколько потоков.
    Максимальное количество потоков ограничено, задается при старте обработчика и в общем случае меньше числа групп.
    Обеспечить равномерную обработку групп элементов: наличие в очереди групп с большим количеством элементов не
    должно приводить к длительным задержкам в обработке других групп.
    Приветствуется следование принципам DRY, KISS и YAGNI, а также
    использование современных подходов и среды исполнения кода.

    Параметры запуска: в качестве аргументов передать через пробел:
        - число групп
        - число значений
        - количество потоков

 */

public class App {

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();

        int groupsCount = Integer.parseInt(args[0]);
        int itemsCount = Integer.parseInt(args[1]);
        int threadsCount = Integer.parseInt(args[2]);

        Handler handler = new Handler(groupsCount, itemsCount);

        handler.fillItemsInCollections();
        handler.sortCollections();
        handler.printItemsInMapBeforeRemoving();

        List<GroupThreads> groupThreadsList = new ArrayList<>();

        for (int i = 0; i < threadsCount; i++)
            groupThreadsList.add(new GroupThreads(handler));

        groupThreadsList.parallelStream().forEach(Thread::start);

        for (GroupThreads groupThreads: groupThreadsList){
            try {
                groupThreads.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        handler.printAllItemsInMapAfterRemoving();

        System.out.println("\n" + "Time remaining: " + (System.currentTimeMillis() - timeStart) + "ms.");
        System.out.println("main thread is finished");
    }
}
