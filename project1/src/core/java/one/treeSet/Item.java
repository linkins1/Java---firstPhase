package core.java.one.treeSet;

import java.util.Objects;

public class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    public Item(String aDescription, int aPartNumber) {
        description = aDescription;
        partNumber = aPartNumber;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "[description=" + description + ", partNumber=" + partNumber + "]";
    }

    public boolean equals(Object otherObject) {
        if (this == otherObject)
            return true;
        if (otherObject == null)
            return false;
        if (getClass() != otherObject.getClass())
            return false;
        Item item = (Item) otherObject;
        return (description.equals(((Item) otherObject).description)) && (partNumber == ((Item) otherObject).partNumber);
    }

    public int hashcode() {
        return Objects.hash(description, partNumber);
    }

    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
        //首先partNumber不相等，如果相等则description不能相等，否则认为两个Item对象是相等的
    }

}
