class ListNode1{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class MySingleList {
    public ListNode head;
    public MySingleList(){
        this.head = null;
    }
    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        //第一次插入
        if(this.head==null){//要习惯加this
            this.head = node; //node代表当前节点的地址
        }
        //第二次插入
        else{
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        //0判断是否是第一次插入
        if(this.head==null){
            this.head=node;
        }
        //找尾巴
        else{
            while(cur.next!=null){
                cur = cur.next;
            }
            //2进行插入
            cur.next=node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标,插入到index位置
    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    private ListNode searchIndex(int index) {
        ListNode prev = this.head;
        int i=0;
        while(i<index-1) {
            prev = prev.next;
            i++;
        }
        return prev;
    }
    public boolean addIndex(int index,int data){
        if(index<0||index>getLength()){
            return false;//下标不合法
        }
        if(index == 0){
            addFirst(data);
            return true;
        }
        ListNode node = new ListNode(data);
        ListNode prev = searchIndex(index);
        node.next = prev.next;
        prev.next = node;
        return false;
    }

    //  找到删除的节点的前驱  如果找不到  返回null
    private ListNode searchPrev(int key) {
        ListNode prev = this.head;
        while(prev.next!=null){
            if(prev.next.data == key){
                return prev;
            }
            prev=prev.next;
        }
        return null;
    }

    public void remove(int key){
        //1、删除的节点如果是头结点
        if(this.head.data == key){
            this.head=this.head.next;
            return;
        }
        //2、找到删除的节点的前驱  如果找不到  返回null
        ListNode prev = searchPrev(key);
        if(prev == null){
            System.out.println("没有删除节点");
            return;
        }
        ListNode del = prev.next;
        //3、进行删除
        prev.next = del.next;
    }
 //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(cur!=null){
            if(prev.next.data==key){
                prev.next = cur.next;
                cur = cur.next;
            }
            else{
                prev = cur;
                cur=cur.next;
            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }
    public void clear(){
        //this.head=null;
        if(this.head!=null){
            ListNode cur = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;
    }
    //打印单列表数据
    public void display(){
        if(this.head ==null){
            return;
        }
        ListNode cur = this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}

