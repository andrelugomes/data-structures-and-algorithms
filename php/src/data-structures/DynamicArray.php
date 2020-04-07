<?php

namespace DataStructures;

use SplFixedArray;

class DynamicArray
{

    /** @var int $size */
    private $size;

    /** @var int $initialCapacity */
    private $initialCapacity;

    /** @var mixed SplFixedArray */
    private $data;

    /**
     * DynamicClass constructor.
     * @param int $initialCapacity
     */
    public function __construct(int $initialCapacity)
    {
        $this->initialCapacity = $initialCapacity;
        //$this->data = []; //Dynamic by nature
        $this->data = new SplFixedArray($initialCapacity);
        $this->size = 0;
    }

    /**
     * @param int $index
     * @param mixed $value
     */
    public function set(int $index, $value): void
    {
        $this->data[$index] = $value;
        $this->size++;
    }

    /**
     * @param int $index
     * @return mixed
     */
    public function get(int $index)
    {
        return $this->data[$index];
    }

    /**
     * @param int $index
     * @param mixed $value
     */
    public function insert(int $index, $value): void
    {
        //Check
        if ($this->size == $this->initialCapacity) {
            $this->resize();
        }

        //Copy UP | Shift
        for ($i = $this->size; $i > $index; $i--) {
            $this->data[$i] = $this->data[$i - 1];
        }

        $this->data[$index] = $value;
        $this->size++;
    }

    /**
     * @param mixed $value
     */
    public function add($value): void
    {
        //Check
        if ($this->size == $this->initialCapacity) {
            $this->resize();
        }

        $this->data[$this->size] = $value;
        $this->size++;
    }

    /**
     * @param int $index
     */
    public function delete(int $index): void
    {
        //copy down [1 2 3] => [1 3 3]  <- shift down
        for ($i = $index; $i < $this->size - 1; $i++) {
            $this->data[$i] = $this->data[$i + 1];
        }

        //clear last
        if ($index == $this->size) {
            $this->data[$index] = null;
        } else {
            $this->data[$this->size - 1] = null;
        }

        $this->size--;
    }

    /**
     * @return int
     */
    public function size(): int
    {
        return $this->size;
    }

    /**
     * @return bool
     */
    public function isEmpty(): bool
    {
        return $this->size() == 0;
    }

    /**
     * @param mixed $value
     * @return bool
     */
    public function contains($value): bool
    {
        for ($i = 0; $i < $this->size; $i++) {
            if ($this->data[$i] === $value) {
                return true;
            }
        }
        return false;
    }

    private function resize(): void
    {
        $newCapacity = $this->initialCapacity * 2;
        $newData = new SplFixedArray($newCapacity);

        for ($i = 0; $i < $this->initialCapacity; $i++) {
            $newData[$i] = $this->data[$i];
        }

        $this->data = $newData;
        $this->initialCapacity = $newCapacity;
    }
}
