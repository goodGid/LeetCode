class MinStack {
    private int size;
    private List<Node> list;

    public MinStack() {
        size = 0;
        list = new ArrayList<>();
    }

    public void push(int val) {
        int prevMin = val;
        if (size > 0) {
            prevMin = list.get(size - 1).min;
        }
        list.add(new Node(val, Math.min(prevMin, val)));
        size++;
    }

    public void pop() {
        list.remove(size - 1);
        size--;
    }

    public int top() {
        return list.get(size - 1).val;
    }

    public int getMin() {
        return list.get(size - 1).min;
    }
}

class Node {
    int val;
    int min;

    public Node(int _val, int _min) {
        this.val = _val;
        this.min = _min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */