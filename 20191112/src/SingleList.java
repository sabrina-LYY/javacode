class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

class SingleList {
    public ListNode head;
    public SingleList(){
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head==null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(this.head==null){
            this.head = node;
        }else{
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //计算链表长度
    public int getLength(){
        int count = 0;
        ListNode  cur = this.head;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //任意位置插入,第一个数据节点为0号下标,插入到index位置
    public ListNode searchIndex(int index){
        ListNode prev = this.head;
        int count = 0;
        while(count<index-1){
            prev = prev.next;
            count++;
        }
        return prev;
    }
    public boolean addIndex(int index,int data){
        if(index<0||index>getLength()){
            return false;
        }
        ListNode node = new ListNode(data);
        if(index == 0){
            addFirst(data);
            return true;
        }
        //找到index-1的位置
        ListNode prev = searchIndex(index);
        //进行插入
        node.next = prev.next;
        prev.next = node;
        return true;

    }

    //查找是否包含关键字key在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        if(this.head==null){
            return false;
        }
        while(cur!=null){
            if(cur.data==key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    //找到倒数第k个结点
    public ListNode findKthToTail(int k){
       ListNode fast = this.head;
       ListNode slow = this.head;
       if(k<=0){
           return null;
       }
       while(k-1>0){
           fast = fast.next;
           k--;
       }
       while(fast.next!=null){
           fast = fast.next;
           slow = slow.next;
       }
       return slow;
    }

    //删除第一次出现关键字为key的节点

    public ListNode searchPrev(int key){
        ListNode prev = this.head;
        while(prev.next!=null){
            if(prev.next.data==key){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    public void remove(int key){
       if(this.head==null){
           return;
       }
       ListNode prev = searchPrev(key);
       if(prev==null){
           System.out.println("没有这个结点");
           return;
       }
       ListNode del = prev.next;
       prev.next = del.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(cur!=null){
            if(cur.data==key){
                prev.next = cur.next;
                cur = cur.next;
            }
            prev = cur;
            cur = cur.next;
        }
        if(this.head.data ==key){
            this.head = this.head.next;
        }
    }

    //6. 编写代码，以给定值x为基准将链表分割成两部分，
    // 所有小于x的结点排在大于或等于x的结点之前
    public ListNode  partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        if(this.head==null||this.head.next==null){
            return this.head;
        }
        while(cur != null){
            if(cur.data < x){
                if(bs == null){
                    bs = cur;
                    be = cur;
                }else{
                    be.next = cur;
                    be = be.next;
                }
            }else{
                if(as == null){
                    as = cur;
                    ae = cur;
                }else{
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs == null){
            return as;
        }
        be.next = as;
        if(as!=null){
            ae.next = null;
        }
        return bs;
    }


    //7. 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针。
    public ListNode deleteDuplication(){
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(cur!=null){
            if(cur.next!=null &&cur.data == cur.next.data){
                while(cur.next!=null && cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
            }else{
                tmp.next = cur;
                tmp = cur;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return tmp;
    }

    //8. 链表的回文结构。
    public boolean chkPalindrome() {
      if(this.head == null){
          return false;
      }
      if(this.head.next == null){
          return true;
      }
      ListNode fast = this.head;
      ListNode slow = this.head;
      while(fast != null && fast.next !=null){
          fast = fast.next.next;
          slow = slow.next;
      }
      ListNode cur = slow.next;
      while(cur != null){
          ListNode curNext = cur.next;
          cur.next = slow;
          slow = cur;
          cur = curNext;
      }
      while(slow != this.head){
          if(slow.data != this.head.data){
              return false;
          }

          if(this.head.next == slow){
              return true;
          }
          slow = slow.next;
          this.head = this.head.next;
      }
      return true;
    }


    //创造环
    public void createLoop(){
        ListNode cur = this.head;
        while(cur !=null){
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }
    //判断是否有环
    public boolean hasCycle(){
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast==null || fast.next == null){
            return false;
        }
        return true;
    }
    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public ListNode detectCycle(){
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast !=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow =this.head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

    //反转链表
    public ListNode reverseList(){
        ListNode newHead = null;
        ListNode prev = null;
        ListNode cur = this.head;
        while(cur!=null){
            ListNode curNext = cur.next;
            while(curNext != null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }



    public void display(){
        if(this.head==null){
            return;
        }
        ListNode cur = this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void display1(ListNode newHead){
        if(newHead==null){
            return;
        }
        ListNode cur = newHead;
        while(cur!=null){
            System.out.print(cur.data +" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
