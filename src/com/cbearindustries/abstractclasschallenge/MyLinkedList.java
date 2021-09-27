package com.cbearindustries.abstractclasschallenge;

class MyLinkedList implements NodeList{
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(root == null){
            root = item;
            return true;
        }
        for(ListItem current = root; current != null; current = current.next()){
            int comparisonResult = item.compareTo(current);
            switch (comparisonResult) {
                case 0:
                    // The given item's value is already in this list, so it cannot be added.
                    return false;
                case -1:
                    // The item's value is less than the current node's value, so item should be placed right before current.
                    item.setNext(current);
                    // If the current node was preceded by another node, that previous node should now point to item, else
                    // the item will become orphaned (nothing will point to it, and the list is unchanged from root's perspective).
                    if (current.previous() != null) {
                        current.previous().setNext(item);
                        item.setPrevious(current.previous());
                        // Now iterate backward through the list to find the new root.
                        while (item.previous() != null) {
                            item = item.previous();
                        }
                    }
                    // Item is now whatever item is at the beginning of the list, so assign root accordingly.
                    root = item;
                    return true;
                case 1:
                    // The item's value is more than the current node's value. If this is the last node, current
                    // must simply point to item, and we're done. Otherwise, we need to keep traversing the list.
                    if (current.next() == null){
                        current.setNext(item);
                        item.setPrevious(current);
                        return true;
                    }
                    continue;
                case Integer.MAX_VALUE:
                    // An error occurred during comparison.
                    return false;
            }
        }
        // The entire linkedList was iterated over but for some reason, the item's ordered place was not found.
        // This should not occur, as it is impossible for the item to simultaneously be neither more, less, nor equal
        // than any of the nodes in a non-empty list.
        System.out.println("Error: Reached the end of the linked list and node was not assigned." +
                           "Please review placement logic.");
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(root == null){
            return false;
        }
        for(ListItem current = root; current != null; current = current.next()){
            if(current.compareTo(item) == 0){
                // Covers the case where this is the first node in the list.
                if(current.previous() == null){
                    // If it's also a one item list, just make root null.
                    if(current.next() == null){
                        root = null;
                    }else{
                        // Orphan the current root of the list by making the next node the new root.
                        root = current.next();
                    }
                    return true;
                }
                // Covers the remaining cases, where a node in the middle or at the very end matches item's value.
                // Set previous.next() to the node after current, if such a node exists. Otherwise, the previous
                // node becomes the new end of the list.
                current.previous().setNext((current.next() == null) ? null : current.next());
                return true;
            }
        }
        System.out.println("The specified item could not be found in this list.");
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null){
            System.out.println("The list is empty");
        }else{
            for(ListItem current = root; current != null; current = current.next()){
                System.out.println((String) current.getValue());
            }
        }
    }
}
