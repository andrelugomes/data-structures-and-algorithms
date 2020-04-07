<?php


namespace DataStructures;


class LinkedList
{
    private $size;
    private $head;

    /**
     * LinkedList constructor.
     */
    public function __construct()
    {
        $this->size = 0;
        $this->head =  null;
    }


    function addFront($data): void
    {
        $node = new Node($data);

        //For the first data
        if ($this->head != null) {
            $node->next = $this->head;

        }

        //Head is now the new node
        $this->head = $node;
        $this->increaseSize();
    }


    public function addBack($data): void
    {
        $newTail = new Node($data);

        $tail = $this->goToTail();

        if ($tail != null){
            $tail->next = $newTail;
        } else {
            $this->head = $newTail;
        }

        $this->increaseSize();
    }

    /**
     * @return int
     */
    public function size(): int
    {
        return $this->size;
    }

    public function getFirst()
    {
        return $this->head->getData();
    }

    public function getLast()
    {
        return $this->goToTail()->getData();

    }

    public function delete($value): void
    {
        if ($this->head == null){
            return;
        }

        $current = $this->head;

        //if head
        if ($current->getData() == $value) {
            $this->head = $current->next;
            $this->size--;
            return;
        }

        while ($current->next != null) {
            if ($current->next->getData() == $value){
                $current->next = $current->next->next;
                $this->size--;
                break;
            }
            $current = $current->next;
        }
    }

    private function increaseSize(): void
    {
        $this->size++;
    }

    private function goToTail(): ?Node
    {
        $node = $this->head;

        while ($node != null && $node->next != null) {
            $node = $node->next;
        }

        return $node;
    }

}

class Node
{
    private $data;
    public $next;

    /**
     * Node constructor.
     * @param mixed $data
     */
    public function __construct($data)
    {
        $this->data = $data;
    }

    /**
     * @return mixed
     */
    public function getData()
    {
        return $this->data;
    }
}