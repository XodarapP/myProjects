package com.bpn.handler;

import com.bpn.item.Item;

import java.time.LocalTime;
import java.util.*;

public class Handler {
    private int groupsCount;
    private SortedMap<Integer, ArrayList<Item>> sortedItemsMap;
    private int itemsCount;
    private Boolean isEmpty = false;
    private List<Item> itemArrayList;
    private List<Integer> listOfAllGroups;
    private int removingItem = 0;

    public Handler(int groupsCount, int itemsCount) {
        this.groupsCount = groupsCount;
        this.itemsCount = itemsCount;
        sortedItemsMap = new TreeMap<>();
        itemArrayList = new ArrayList<>();
        listOfAllGroups = new ArrayList<>();
    }

    // Заполняем map случайными числами
    public void fillItemsInCollections(){
        Random random = new Random();
        int group;
        for (int i = 1; i < itemsCount * groupsCount; i++){
            group = random.nextInt(groupsCount);
            Item item = new Item(random.nextInt(i) + 1, group);
            sortedItemsMap.put(group, new ArrayList<>());
            addItemToArrayList(item);
        }
    }

    // добавление items в arrayList для последующей сортировки по itemId
    public void addItemToArrayList(Item item){
        itemArrayList.add(item);
    }

    /*
         для начала сортируем itemArrayList по itemId, после чего добавляем его в
         sortedItemsMap, чтобы в map'е были отсортированны помимо групп еще и значения,
         в завершение добавляем в listOfAllGroups только уникальные значения номеров групп.
     */
    public void sortCollections(){
        Collections.sort(itemArrayList, (item1, item2) -> {
            if (item1.getItemId() < item2.getItemId()) {
                return -1;
            } else if (item1.getItemId() > item2.getItemId()) {
                return 1;
            }
            return 0;
        });

        for (Item item: itemArrayList){
            sortedItemsMap.get(item.getGroupId()).add(item);
        }
        for (Map.Entry entry: sortedItemsMap.entrySet()){
            listOfAllGroups.add((Integer) entry.getKey());
        }
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    /*
        Обеспечить равномерную обработку групп элементов: наличие в очереди групп с большим количеством элементов не
        должно приводить к длительным задержкам в обработке других групп.
        Равномерная обработка групп это дать возможность потоку взять одно значению из групппы, считать его, удалить,
        после чего следующий поток заходит в соседнюю группу и так в цикле. Для этого был создан listOfAllGroups хранящий
        уникальые номера всех групп. При удалении всех значений из группы, номер группы удаляется из listOfAllGroups,
        диапазон переходов сужается до полного опустошения sortedItemsMap и listOfAllGroups.
     */
    public synchronized void removeItemFromMap() {
        if (listOfAllGroups.size() == 0) {
            isEmpty = true;
            System.out.println(Thread.currentThread().getName() + " found empty map, and finished work.");
        }
        else {
            System.out.println(LocalTime.now() + " processing in map:" + Thread.currentThread().getName() + " [item]: " + sortedItemsMap.get(listOfAllGroups.get(removingItem)).get(0));
            sortedItemsMap.get(listOfAllGroups.get(removingItem)).remove(0);

            if (sortedItemsMap.get(listOfAllGroups.get(removingItem)).size() == 0){
                listOfAllGroups.remove(removingItem);
                removingItem--;
            }

            if (removingItem == listOfAllGroups.size()-1){
                removingItem = 0;
            } else {
                removingItem++;
            }
        }
    }

    // Печать значений map'ы до удаления элементов
    public void printItemsInMapBeforeRemoving() {
        System.out.println("SortedItemsMap before removing:");
        for (Map.Entry entry: sortedItemsMap.entrySet()){
            System.out.println("SortedItemsMap - [groups number]: " + entry.getKey() + ", [item values]: " + entry.getValue());
        }
    }

    // Печать значений map'ы после удаления элементов
    public void printAllItemsInMapAfterRemoving(){
        System.out.println("\nSortedItemsMap after removing:");
        for (Map.Entry entry: sortedItemsMap.entrySet()){
            System.out.println("SortedItemsMap - [groups number]: " + entry.getKey() + ", [item values]: " + entry.getValue());
        }
    }
}
