package model;

import java.util.Iterator;
import java.util.List;

public class Hand implements Iterable {
    List<Card> hand;
    @Override
    public Iterator iterator() {
        return hand.iterator();
    }
}
