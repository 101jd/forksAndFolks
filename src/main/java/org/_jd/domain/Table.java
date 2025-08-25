package org._jd.domain;

import java.util.LinkedList;
import java.util.List;

public class Table {
    Item[] items = new Item[10];
    int frk = 0;
    int flk = 0;

    public void FillTable(){
        for (int i = 0; i < items.length-1; i+=2) {
            items[i] = new Fork(++frk);
        }

        for (int i = 1; i < items.length; i+=2) {
            if (i < items.length-1)
                items[i] = new Folk(++flk, (Fork) items[i-1], (Fork) items[i+1]);
            else items[i] = new Folk(++flk, (Fork) items[i-1], (Fork) items[0]);
        }
    }

    public Item[] getItems() {
        return items;
    }
}
