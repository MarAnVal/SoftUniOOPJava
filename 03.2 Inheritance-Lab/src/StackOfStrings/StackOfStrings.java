package StackOfStrings;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackOfStrings {
    //Private field: data: ArrayList<String>
    private final List<String> data;
    private int topIndex;

    public StackOfStrings() {
        this.data = new ArrayList<>();
        setTopIndex();
    }

    private void setTopIndex() {
        if (this.data.size() > 0) {
            this.topIndex = this.data.size() - 1;
        } else {
            this.topIndex = 0;
        }
    }

    //· Public method: push(String item): void
    public void push(String item) {
        this.data.add(item);
        setTopIndex();
    }

    //· Public method: pop(): String
    public String pop() {
        if(this.data.isEmpty()){
            throw new EmptyStackException();
        }
        String element = this.data.remove(this.topIndex);
        setTopIndex();
        return element;
    }

    //· Public method: peek(): String
    public String peek() {
        if(this.data.isEmpty()){
            throw new EmptyStackException();
        }
        return this.data.get(topIndex);
    }

    //· Public method: isEmpty(): boolean
    public boolean isEmpty() {
        return this.data.size() == 0;
    }
    public int size(){
        return this.data.size();
    }
}