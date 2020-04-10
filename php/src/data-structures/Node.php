<?php

namespace DataStructures;

class Node
{
    /**
     * @var mixed
     */
    private $data;
    /**
     * @var Node
     */
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
     * @return mixed|null
     */
    public function getData()
    {
        return $this->data;
    }
}
