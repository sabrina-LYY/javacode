

public class ArrayList<T> {
        public T[] elem;
        public int usedSized;
        public ArrayList(){
            this.elem = (T[]) new Object[20];
            this.usedSized = 0;
        }
        public void add(T data){
            this.elem[this.usedSized] = data;
            this.usedSized++;
        }
        public T get() {
            return this.elem[this.usedSized-1];
        }

}


