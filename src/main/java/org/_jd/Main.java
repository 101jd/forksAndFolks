package org._jd;

import org._jd.domain.Folk;
import org._jd.domain.Item;
import org._jd.domain.Table;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Table table = new Table();
        table.FillTable();

        for (Item item : table.getItems()){
            if (item instanceof Folk){
                Thread thread = new Thread((Folk)item);
                thread.start();
            }
        }


    }
}