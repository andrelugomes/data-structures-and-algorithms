<?php

namespace DataStructures;

use DataStructures\Node;

class LinkedList
{
    /**
     * @var int
     */
    private $size;
    /**
     * @var Node|null
     */
    private $head;

    /**
     * LinkedList constructor.
     */
    public function __construct()
    {
        $this->size = 0;
        $this->head = null;
    }

    /**
     * @param mixed $data
     */
    public function addFront($data): void
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

    /**
     * @param mixed $data
     */
    public function addBack($data): void
    {
        $newTail = new Node($data);

        $tail = $this->goToTail();

        if ($tail != null) {
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

    /**
     * @return mixed|null
     */
    public function getFirst()
    {
        //Not identical
        if ($this->head !== null) {
            return $this->head->getData();
        }
        return null;
    }

    /**
     * @return mixed|null
     */
    public function getLast()
    {
        //Cannot call method getData() on DataStructures\Node|null.
        //return $this->goToTail()->getData() ?? null;
        // PHPStan problem : Cannot call method getData() on DataStructures\Node|null.
        //https://github.com/phpstan/phpstan/issues/1157

        //Not identical
        if ($this->goToTail() !== null) {
            return $this->goToTail()->getData();
        }
        return null;
    }

    /**
     * @param mixed $value
     */
    public function delete($value): void
    {
        if ($this->head == null) {
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
            if ($current->next->getData() == $value) {
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
