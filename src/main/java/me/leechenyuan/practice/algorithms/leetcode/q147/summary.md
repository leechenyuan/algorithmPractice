这道提需要理解什么是插入排序. 有时候和冒泡排序很像，很容易忘记之间的区别。
自己错过的地方:
因为插入排序涉及到交换listNode节点。 当我们把当前的节点插入到别的地方的时候，这个当前的节点可能就不再是当前的节点了。
如果我们没有注意，会把接的当前节点当做目前的当前节点，在while循环的地方很容易陷入死循环.


像这段代码，就不应该写得那么简陋。对于循环没有处理好，很容易陷入死循环。
```
            if( (p != null) && (p != cur)){
                if(beforeP != null){
                    pre.next = cur.next;
                    beforeP.next = cur;
                    cur.next = p;
                }else{
                    pre.next = cur.next;
                    head = cur;
                    beforeP = cur;
                    cur.next = p;
                }
                //下面这2个一漏掉，会导致执行 pre = cur;cur = cur.next;程序就乱掉了
                cur = pre.next;
                continue;
            }
            pre = cur;
            cur = cur.next;
```
