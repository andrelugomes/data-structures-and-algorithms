<?php

use DataStructures\DynamicArray;
use PHPUnit\Framework\TestCase;

class DynamicArrayTest extends TestCase
{

    public function testSetThenGetByIndex()
    {
        $dynamicArray = new DynamicArray(2);
        $dynamicArray->set(0,"test");
        $dynamicArray->set(1,"test1");

        $this->assertEquals("test", $dynamicArray->get(0));
    }

    public function testInsertIntoArray()
    {
        $dynamicArray = new DynamicArray(1);
        $dynamicArray->insert(0, "insert");

        $this->assertEquals("insert", $dynamicArray->get(0));
    }
}
