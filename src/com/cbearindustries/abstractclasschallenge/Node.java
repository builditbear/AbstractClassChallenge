package com.cbearindustries.abstractclasschallenge;

class Node extends ListItem{
    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        rightLink = item;
        return rightLink;
    }

    @Override
    ListItem previous() {
        return leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        leftLink = item;
        return leftLink;
    }

    @Override
    // Returns 0 if values of both nodes are equal, -1 if this node's value is less than item's value, and 1 if this node's
    // value is more than item's value.
    int compareTo(ListItem item) {
        if(item != null && this.value != null && item.value != null){
            int result = ((String) this.value).compareTo((String) item.value);
            if(result == 0){
                return result;
            }else if(result < 0){
                return -1;
            }else{
                return 1;
            }
        }
        System.out.println("Error: The object being passed in or one of the values you are attempting to compare is null.");
        return Integer.MAX_VALUE;
    }
}
