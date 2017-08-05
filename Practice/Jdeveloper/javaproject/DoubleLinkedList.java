package javaproject;

public     class DoubleLinkedList{
        Node head;
        Node tail;
        int size;
        
        class Node{
            Node previous;
            Node next;
            int value;
            
            public Node(int value){
                this.value = value;
            }
        }
        
        public boolean isEmpty(){
            return size == 0;
        }
        
        public void addNode(Node node){
            if(head == null && tail == null){
                head = node;
                tail = node;
            }
            else{
                node.next = head;
                head.previous = node;
                head = node;
            }
        }
        
        public void removeNode(Node node){
            
        }
    }
