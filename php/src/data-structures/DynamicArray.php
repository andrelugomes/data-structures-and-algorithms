<?php

namespace DataStructures;

use SplFixedArray;

class DynamicArray
{

    private $size, $initialCapacity, $data;

    /**
     * DynamicClass constructor.
     * @param $initialCapacity
     */
    public function __construct($initialCapacity)
    {
        $this->initialCapacity = $initialCapacity;
        //$this->data = []; //Dynamic by nature
        $this->data = new SplFixedArray($initialCapacity);
        $this->size = 0;
    }

    public function set(int $index, $value )
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

    public function insert(int $index, $value)
    {
        //Check
        if($this->size == $this->initialCapacity) {
            $this->resize();
        }

        //Copy UP | Shift
        for ($i = $this->size; $i > $index; $i--) {
            $this->data[$i] = $this->data[$i - 1];
        }

        $this->data[$index] = $value;
        $this->size++;
    }

    private function resize()
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
