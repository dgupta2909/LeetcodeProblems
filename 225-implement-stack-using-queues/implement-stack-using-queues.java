class MyStack {

    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {

        // Store the number of old elements
        int size = q.size();

        // Add the new element
        q.add(x);

        // Move all old elements behind the new element
        for (int i = 0; i < size; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}