package com.bpn.item;

public class Item {
    private int itemId;
    private int groupId;

    public Item (int itemId, int groupId) {
        this.itemId = itemId;
        this.groupId = groupId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getGroupId() {
        return groupId;
    }

    @Override
    public String toString() {
        return " Item{" +
                "itemId: = " + itemId +
                ", groupId: = " + groupId +
                '}';
    }
}
